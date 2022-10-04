// This script is written to help assist programmers in Android to obtain an IP Address from the internet. It uses information stored by IP2Location. To use this script, simply edit the variables denoted by APIKEY and ipADDRESS. APIKEY denotes the APIKEY you should have from IP2Location; if you do not have this, seek assistance from the organisation. ipAddress denotes the IP address you are seeking information for.

// Written by Babatunde Onabajo, and under the MIT licence, for the 2022 IP2Location contest, this day 30th September 2022. This script is written by Babatunde Onabajo in a personal capacity. The contents of this script does not represent any past, present or future employer. The categorisation of certain geographical information does not necessarily reflect the opinion(s) held by Babatunde Onabajo.

// "This site or product includes IP2Location LITE data available from http://www.ip2location.com." IP2Location is a registered trademark of Hexasoft Development Sdn Bhd. All other trademarks are the property of their respective owners.

// The format used for links https://api.ip2location.io/?key={YOUR_API_KEY}&ip=8.8.8.8&format=xml

// Note that this particular script only gets information for XML documents. For JSON information, please consult the programmer.


package com.example.fetchipaddressesonlineforandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


//The following import declarations are needed to request particular information over the internet.
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//The following import declarations are needed to parse the XML file from IP2Location
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;




public class MainActivity extends AppCompatActivity {

// Here we declare a range of variables that are associated with the XML response, with the exception of the IP Address which you can alter yourself later down below inside the Thread identified as threadForFetchingIPAddressFromIP2Location.

// These are arranged exactly as they appear in the XML document that IP2Location returns to us. This is important to note because when we iterate over the XML document, the iteration assumes a certain format.

    public String responseForIPAddress;
    public String responseForCountryCode;
    public String responseForCountryName;
    public String responseForRegionName;
    public String responseForCityName;
    public String responseForLatitude;
    public String responseForLongitude;
    public String responseForZipCode;
    public String responseForTimeZone;
    public String responseForASN;
    public String responseForAS;
    public String responseForIsProxy;


    @Override
    protected void onCreate(Bundle savedInstanceState) { //This is for the onCreate() part of the lifecycle.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread threadForFetchingIPAddressFromIP2Location = new Thread(new Runnable() {

            public static final String APIKEY = ""; //Input your API key here which can be obtained from IP2Location.io.
            public static final String ipADDRESS = ""; //Input the IP address you are looking for here (e.g. 8.8.8.8.)

            @Override
            public void run() {
                URL url;
                try {
                    String websiteToObtainIPAddress = "https://api.ip2location.io/?key=" + APIKEY + "&ip=" + ipADDRESS + "&format=xml";

                    url = new URL(websiteToObtainIPAddress);

                    URLConnection connection;
                    connection = url.openConnection();

                    HttpURLConnection httpConnection = (HttpURLConnection) connection;
                    int responseCode = httpConnection.getResponseCode();

                    if (responseCode == HttpURLConnection.HTTP_OK) { //We begin to open up the internet connection.

                        InputStream in = httpConnection.getInputStream();

                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        factory.setIgnoringComments(true);
                        factory.setIgnoringElementContentWhitespace(true);
                        factory.setValidating(false); //The setValidating() method checks to see whether an XML file conforms to a DTD. By default, it is set to false. We have set it here to false too due to time constraints. In future editions, we will set it to true.

                        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
                        Document document = documentBuilder.parse(in);
                        Element root = document.getDocumentElement(); //This helps us to get the node


                        try {
                            NodeList resultsOfIPAddressSearchQuery = root.getElementsByTagName("result"); //This gets the information from the XML document

                            for (int i = 0; i < 11; i++) { //The response for IP2Location's IP address quest typically provides 12 responses, so we iterate from 0 to 11 (remembering that such iterations are zero-indexed meaning that we count from 0 not from 1. We can be reasonably sure

                                if (resultsOfIPAddressSearchQuery.item(i).getTextContent().length() > 0) { //Here we check that the response is not empty.
                                    if(i == 0 ){
                                        responseForIPAddress = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }
                                    else if(i == 1){
                                        responseForCountryCode = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }else if(i == 2){
                                        responseForCountryName = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }else if(i == 3){
                                        responseForRegionName = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }
                                    else if(i == 4){
                                        responseForCityName = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }else if(i == 5){
                                        responseForLatitude = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }else if(i == 6){
                                        responseForLongitude = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }else if(i == 7){
                                        responseForZipCode = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }else if(i == 8){
                                        responseForTimeZone = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }else if(i == 9){
                                        responseForASN = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }else if(i == 10){
                                        responseForAS = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }else if(i == 11){
                                        responseForIsProxy = resultsOfIPAddressSearchQuery.item(i).getTextContent();
                                    }

                                    // If you want to test to see whether this works, you can uncomment this part out.

                                    // Toast.makeText(MainActivity.this, responseForIPAddress, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForCountryCode, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForCountryName, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForRegionName, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForCityName, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForLatitude, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForLongitude, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForZipCode, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForTimeZone, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForASN, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForAS, Toast.LENGTH_LONG).show();
                                    // Toast.makeText(MainActivity.this, responseForIsProxy, Toast.LENGTH_LONG).show();

                                }else{ // If there is no response or some other issue, we alert the programmer with the well-known "Toast" feature.
                                    Toast.makeText(MainActivity.this, "There appears to be an issue. Please check whether the IP address provided is correct or otherwise consult the programmer", Toast.LENGTH_LONG).show();
                                }
                            }

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                } catch (MalformedURLException e) { //We are obliged to catch any errors. This is a checked exception.

                } catch (IOException e) { //We are obliged to catch any errors. This is a checked exception.

                } catch (ParserConfigurationException e) { //We are obliged to catch any errors. This is a checked exception.

                } catch (SAXException e) { //We are obliged to catch any errors. This is a checked exception.
                }
            }
        });
        threadForFetchingIPAddressFromIP2Location.start();//This begins the thread.
        
    }

    @Override
    protected void onStart(){ // This is for the onStart() part of the lifecycle.
        super.onStart();
    }

    @Override
    protected void onRestart(){ //This is for the onRestart() part of the lifecycle.
        super.onRestart();
    }

    @Override
    protected void onResume(){ //This is for the onResume() part of the lifecycle.
        super.onResume();

    }

    @Override
    protected void onPause(){ //This is for the onPause() part of the lifecycle.
        super.onPause();
    }

    @Override
    protected void onStop(){ //This is for the onStop() part of the lifecycle.
        super.onStop();
    }

    @Override
    protected void onDestroy(){ //This is for the onDestroy() part of the lifecycle.
        super.onDestroy();
    }

    
}
