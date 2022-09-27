package com.WTC.WashingtonTrailConditions.DataScrapers;

public class AirQuality {
    private static String airQuality;

    public AirQuality(String lat, String lon) {
        this.airQuality = setAQ(lat, lon);
    }

    public static String getAQ() {
        return airQuality;
    }

    // Scrape web for data on current air quality
    public String setAQ(String lat, String lon) {
        return "Returning Air Quality from web scraping function";
    }
}
