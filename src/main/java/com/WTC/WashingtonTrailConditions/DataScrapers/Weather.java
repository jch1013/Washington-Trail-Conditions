package com.WTC.WashingtonTrailConditions.DataScrapers;

import java.util.List;

public class Weather {
    private List<String> forecasts;

    public Weather(String lat, String lon) {

    }

    public List<String> getForecasts() {
        return forecasts;
    }

    public void addForecasts(String lat, String lon) {
        //scrape web forecasts here and call addForecasts in constructor
    }
}
