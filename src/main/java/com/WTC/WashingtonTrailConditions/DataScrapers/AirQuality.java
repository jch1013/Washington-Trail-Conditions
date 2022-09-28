package com.WTC.WashingtonTrailConditions.DataScrapers;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class AirQuality {
    private static String airQuality;
    private final String apiKey= "c8af4a9e6dd91c6b03805c5c0258f89f";

    public AirQuality(String lat, String lon) {
        try {
            airQuality = setAQ(lat, lon);
        } catch (IOException ioe) {
            airQuality = "Unable to find air quality";
        }
    }

    public static String getAQ() {
        return airQuality;
    }

    private String currentLink(String lat, String lon) {
        return "http://api.openweathermap.org/data/2.5/air_pollution?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
    }


    // Scrape web for data on current air quality
    private String setAQ(String lat, String lon) throws IOException {

        // get air quality data from openweather api as a json string
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(currentLink(lat, lon));
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();

            // Extract air quality information from json string
            JSONObject obj = new JSONObject(result.toString());
            JSONArray array = obj.getJSONArray("list");
            JSONObject aq = array.getJSONObject(0).getJSONObject("main");
            Integer air = aq.getInt("aqi");

            return "Current Air Quality: " + getAQImessage(air);


        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return "Unable to get air quality data for this location. Please try again later";
        }
    }

    private String getAQImessage(int val) {
        if (val == 1) {
            return "0 - 50 (good)";
        } else if (val == 2) {
            return "50 - 100 (moderate)";
        } else if (val == 3) {
            return "100 - 150 (unhealthy for sensitive groups)";
        } else if (val == 4) {
            return "150 - 200 (unhealthy)";
        } else {
            return "over 200 (very unhealthy)";
        }
    }


}
