package com.WTC.WashingtonTrailConditions.Models;

import com.WTC.WashingtonTrailConditions.DataScrapers.AirQuality;
import com.WTC.WashingtonTrailConditions.DataScrapers.Weather;

import java.util.List;

public class Conditions {
    private Weather weather;
    private AirQuality airQuality;
    //add more fields here as needed


    public Conditions(String lat, String lon) {
        airQuality = new AirQuality(lat, lon);
    }

    public String getAirQuality() {
        return airQuality.getAQ();
    }


}
