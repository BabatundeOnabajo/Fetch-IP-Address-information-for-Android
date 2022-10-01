# About Fetch IP Address for Android
This is a short - spanning only one Activity - but useful script for programmers in Android development to extract information relating to an IP address from IP2Location. This script obtains the following information from IP2Location where available:
* IP Address
* Country code
* Country name
* Region name
* City name
* Latitude
* Longitude
* Zip code
* Time zone
* ASN
* AS
* Whether or not IP address is a proxy

Note that this script can only be used for the XML option for IP2Location. It does not work for the JSON version; please consult a different script if this is your preference.


# Instructions
You can copy and paste this code. You only need to edit the variable identified as APIKEY (which indicates the API key you should have obtained from IP2Location. Contact them if you would like information on how to receive this) as well as ipADDRESS (which refers to the IP Address you would like to obtain information for). 

In order to see this code in action using Android Studio, copy the create a new project in Android Studio and name the project "Fetch IP Addresses for Android". Android Studio should then automatically create a package name called "com.example.fetchipaddressesonlineforandroid". Also select the option <b> Empty Activity </b>. Then copy all the information from MainActiviy.java here and paste it into the file, overwriting anything that might be present. 

To test the script, a series of Toast functions are in the script. They are commented out, but you can uncomment them to see them in action. To see them in action, click "<b>Run 'app'</b>" and then the emulator should open up. Click on the app that has been installed and you should see the requested information appear as a series of Toast bubble messages. 

# Requirements
* Android Studio, Eclipse or a similar Integrated Development Environment (IDE) that can compile and run Android software.
* Windows, Mac or Linux
* Internet access
* 
It is not necessary to have a physical Android device but you can test it on your device as well if that suits your fancy. Given the elemental nature of this script, this script should work on practically all versions of Android, despite the fact that targetSdkVersion is labelled as 33 and compileSdkVersion is 33. However, you might need to change the line <b> import androidx.appcompat.app.AppCompatActivity; </b> . Please consult official Android documentation surrounding this, otherwise just continue with the latest version of Android as of writing (33). Then copy and paste the code in this repository labelled "MainActivity.java". Once that is done, you must edit the constant APIKEY to include your API key and edit the constant ipADDRESS for the IP Address you want to look up. Voila! You are now able to fetch information for IP addresses on Android. This script handles all the difficult stuff in the context of Android, such as connecting to the internet as well as managing threads. You can build upon this script, for instance, saving the variable responseForCountryName into a local database. 


# Credits
* Babatunde Onabajo (ChurchMapped Limited)
* IP2Location


# Disclaimer
* "This site or product includes IP2Location LITE data available from http://www.ip2location.com." IP2Location is a registered trademark of Hexasoft Development Sdn Bhd. All other trademarks are the property of their respective owners.
* This script is written in a personal capacity by Babatunde Onabajo. This script does not reflect the opinion(s) of any past, present or future employer. Any geographical or political categorisation associated with the response from information provided by IP2Location does not necessarily imply or reflect the personal opinion held by Babatunde Onabajo. 

