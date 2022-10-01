package com.WTC.WashingtonTrailConditions.Models;

import com.WTC.WashingtonTrailConditions.DataScrapers.StationData;

public class SnowConditions {
    private StationData stationData;
    private String currentEstimatedSnowDepth;
    private String snowfallTomorrow;
    private String snowfallWeek;
    private String avalancheRating;

    // Constructors
    public SnowConditions(String lat, String lon) {
        stationData = new StationData(lat, lon);
        avalancheRating = "9000";
    }

    // Getters
    public String getCurrentEstimatedSnowDepth() {return currentEstimatedSnowDepth;}
    public String getSnowfallTomorrow() {return snowfallTomorrow;}
    public String getSnowfallWeek() {return snowfallWeek;}
    public String getAvalancheRating() {return avalancheRating;}

    public Station[] getNearbyStations() {
        return stationData.getNearestStations();
    }


}
