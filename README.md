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

In order to see this code in action using Android Studio, copy the create a new project in Android Studio and name the project "Fetch IP Addresses for Android". Android Studio should then automatically create a package name called "com.example.fetchipaddressesonlineforandroid". Also select the 

# Requirements
* Android Studio, Eclipse or a similar Integrated Development Environment (IDE) that can compile and run Android software.
* Windows, Mac or Linux
* Internet access
* 
It is not necessary to have a physical Android device but you can test it on your device as well if that suits your fancy. Given the elemental nature of this script, this script should work on practically all versions of Android, despite the fact that targetSdkVersion is labelled as 33 and compileSdkVersion is 33. However, you might need to change the line <b> import androidx.appcompat.app.AppCompatActivity; </b> . Please consult official Android documentation surrounding this, otherwise just continue with the latest version of Android as of writing (33). Then copy and paste the code in this repository labelled "MainActivity.java". Once that is done, you must edit the constant APIKEY to include your API key and edit the constant ipADDRESS for the IP Address you want to look up. Voila! You are now able to fetch information for IP addresses on Android. This script handles all the difficult stuff in the context of Android, such as connecting to the internet as well as managing threads. 

# Credits

# Disclaimer
"This site or product includes IP2Location LITE data available from http://www.ip2location.com."

IP2Location is a registered trademark of Hexasoft Development Sdn Bhd. All other trademarks are the property of their respective owners.
