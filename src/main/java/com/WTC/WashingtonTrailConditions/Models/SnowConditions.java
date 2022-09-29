package com.WTC.WashingtonTrailConditions.Models;

public class SnowConditions {
    private String currentEstimatedSnowDepth;
    private String snowfallTomorrow;
    private String snowfallWeek;
    private String avalancheRating;

    // Constructors
    public SnowConditions(String lat, String lon) {

    }

    // Getters
    public String getCurrentEstimatedSnowDepth() {return currentEstimatedSnowDepth;}
    public String getSnowfallTomorrow() {return snowfallTomorrow;}
    public String getSnowfallWeek() {return snowfallWeek;}
    public String getAvalancheRating() {return avalancheRating;}

}
