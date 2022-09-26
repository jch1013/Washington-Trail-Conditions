package com.WTC.WashingtonTrailConditions.Models;

import com.WTC.WashingtonTrailConditions.DataScrapers.AirQuality;

import java.util.List;

public class Conditions {
    private List<String> weatherForecasts;
    private AirQuality airQuality;
    //add more fields here as needed


    public Conditions(String lat, String lon) {
        airQuality = new AirQuality(lat, lon);
    }

    public String getAirQuality() {
        return airQuality.getAQ();
    }


}
