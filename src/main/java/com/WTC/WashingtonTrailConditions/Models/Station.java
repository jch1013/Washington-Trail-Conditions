package com.WTC.WashingtonTrailConditions.Models;

public class Station {
    private String stationName;
    private String elevation;
    private float latitude;
    private float longitude;
    private float snowDepth;

    public Station() {}
    public Station(String setName, String setElevation, float setLat, float setLon, float setDepth) {
        this.stationName = setName;
        this.elevation = setElevation;
        this.latitude = setLat;
        this.longitude = setLon;
        this.snowDepth = setDepth;
    }

    public String getStationName() {return stationName;}
    public String getElevation() {return elevation;}
    public float getLatitude() {return latitude;}
    public float getLongitude() {return longitude;}
    public float getSnowDepth() {return snowDepth;}

    public int distanceTo(float lat, float lon) {
        // Use haversine formula to calculate distance from station to provided coordinates
        double toRadians = Math.PI / 180;
        double deltaLat = (this.latitude - lat) * toRadians;
        double deltaLon = (this.longitude - lon) * toRadians;

        double a = Math.pow(Math.sin(deltaLat / 2.0),2) +
                Math.cos(this.latitude * toRadians) * Math.cos(lat * toRadians) * Math.pow(deltaLon / 2, 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        int earthRadius = 3961;
        double distance = earthRadius * c;
        return (int) distance;
    }

}
