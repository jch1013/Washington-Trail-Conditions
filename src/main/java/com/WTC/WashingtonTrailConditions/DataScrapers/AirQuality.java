package com.WTC.WashingtonTrailConditions.DataScrapers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class AirQuality {
    private static String airQuality;
    private static String nextDayAirQuality;
    private static String futureAirQuality;
    private final String apiKey= "c8af4a9e6dd91c6b03805c5c0258f89f";

    public AirQuality(String lat, String lon) {
        try {
            setAQ(lat, lon);
        } catch (IOException ioe) {
            airQuality = "Unable to get air quality data for this location. Please try again later";
        }
    }

    public static String getAQ() {return airQuality;}
    public static String getNextDayAQ() {return nextDayAirQuality;}
    public static String getFutureAQ() {return futureAirQuality;}

    private String currentLink(String lat, String lon) {
        return "http://api.openweathermap.org/data/2.5/air_pollution/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
    }


    // Scrape web for data on current air quality
    private void setAQ(String lat, String lon) throws IOException {
        try {
            // Get all air quality data from openweather api as json string and save it as StringBuilder object
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

            // Get current air quality
            JSONObject currentAir = array.getJSONObject(0).getJSONObject("main");
            Integer currentAirValue = currentAir.getInt("aqi");
            airQuality = "Current air quality index range: " + getAQImessage(currentAirValue);

            // Calculate average air quality for next 24 hours
            int nextDayTotal = 0;
            int timespan = 23;
            for (int i = 1; i < timespan + 1; i++) {
                JSONObject airForecast = array.getJSONObject(i).getJSONObject("main");

                Integer forecastedAirValue = airForecast.getInt("aqi");
                nextDayTotal += forecastedAirValue;
            }
            double nextDayAverage = nextDayTotal / timespan * 1.0;
            nextDayAirQuality = "24 hour average air quality forecast: " + getAQImessage(nextDayAverage);

            // Calculate average air quality for 24-48 hours from current time
            int futureTotal = 0;
            try {
                for (int i = 25; i < 49; i++) {
                    JSONObject airForecast = array.getJSONObject(i).getJSONObject("main");
                    Integer forecastedAirValue = airForecast.getInt("aqi");
                    futureTotal += forecastedAirValue;
                }
                double futureAverage = futureTotal / 24.0;
                futureAirQuality = "24 to 48 hour average air quality forecast: " + getAQImessage(futureAverage);
            } catch (JSONException jse) {
                futureAirQuality = "An error occurred when fetching future air quality";
            }


        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    // Helper function to translate air quality value to an aqi rating range
    private String getAQImessage(double val) {
        int upperBound = (int) (val * 50);
        int lowerBound = (int) (val * 50.0 - 50);
        return lowerBound + " - " + upperBound;
    }


}
