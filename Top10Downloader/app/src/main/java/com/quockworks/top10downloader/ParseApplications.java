package com.quockworks.top10downloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by Brian on 12/9/2015.
 *
 * This class parses XML data (passed to it in a String) and saves it in an array of Application objects.
 * The tag names are specialized for the "Top 10 Free Apps" XML file from the www.apple.com/rss/ site.
 * These tags can be found easily using the codebeautify.org/xmlviewer page.
 *
 */
public class ParseApplications {
    private String xmlData;
    private ArrayList<Application> applications;

    // Constructor
    public ParseApplications(String xmlData){
        this.xmlData = xmlData;
        applications = new ArrayList<Application>();
    }

    public ArrayList<Application> getApplications(){
        return applications;
    }

    // Parse data and store in applications array
    public boolean process(){
        boolean status = true;
        Application currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();

            // Move down XML document element by element
            while(eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch(eventType){
                    case XmlPullParser.START_TAG:               // Check for start tag <something>
                        //Log.d("ParseApplications", "Starting tag for " + tagName);
                        if(tagName.equalsIgnoreCase("entry")){
                            inEntry = true;
                            currentRecord = new Application();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:                 // Check for end tag </something>
                        //Log.d("ParseApplications", "Ending tag for " + tagName);
                        if(inEntry){
                            if(tagName.equalsIgnoreCase("entry")){
                                applications.add(currentRecord);    // Save the app record
                                inEntry = false;
                            }
                            else if(tagName.equalsIgnoreCase("name")){
                                currentRecord.setName(textValue);
                            }
                            else if(tagName.equalsIgnoreCase("artist")){
                                currentRecord.setArtist(textValue);
                            }
                            else if(tagName.equalsIgnoreCase("releaseDate")){
                                currentRecord.setReleaseDate(textValue);
                            }
                        }
                        break;
                    default:
                        // Nothing else to do
                }
                eventType = xpp.next();
            }
            
        }catch (Exception e){
            status = false;
            e.printStackTrace();
        }

        // Print the data collected
        for(Application app : applications){
            Log.d("ParseApplications","************");

            Log.d("ParseApplications","Name: " + app.getName());
            Log.d("ParseApplications","Artist: " + app.getArtist());
            Log.d("ParseApplications","Release Date: " + app.getReleaseDate());
        }

        return true;
    }
}
