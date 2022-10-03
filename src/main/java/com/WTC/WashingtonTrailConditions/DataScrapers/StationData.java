package com.WTC.WashingtonTrailConditions.DataScrapers;

import com.WTC.WashingtonTrailConditions.Models.Station;
import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebClient;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class StationData {
    private final int numberOfStations = 10;
    private final HashMap<Float, Station> stations = new HashMap<Float, Station>();
    private Station[] nearestStations = new Station[numberOfStations];
    private final List<Float> distances = new ArrayList<>();


    // Constructors
    public StationData() {}
    public StationData(String lat, String lon) {
        try {
            loadStations(lat, lon);
        } catch (IOException ioe) {
            // make this more useful
            System.out.println("error");
        }
    }

    // Getters

    public Station[] getNearestStations() {return nearestStations;}


    private String makeDataLink() {
        LocalDate today = LocalDate.now();
        String year = String.valueOf(today.getYear());
        String month = String.valueOf(today.getMonthValue());
        String day = String.valueOf(today.getDayOfMonth());

        // Reformat day and month when leading zero not included
        if (day.length() == 1) {day = "0" + day;}
        if (month.length() == 1) {month = "0" + month;}

        String dataLink = "https://www.nohrsc.noaa.gov/nsa/discussions_text/Northwest/snowdepth/"
                + year + month + "/snowdepth_" + year + month + day + "06_e.txt";
        return dataLink;
    }

    private void loadStations(String lat, String lon) throws IOException {
        try {
            WebClient client = new WebClient();
            client.getOptions().setCssEnabled(false);
            client.getOptions().setJavaScriptEnabled(false);

            String searchUrl = makeDataLink();
            TextPage page = client.getPage(searchUrl);
            String data = page.getContent();


            String[] allStations = data.split("\n");
            for (int i = 2; i < allStations.length; i++) {
                String[] dataFields = allStations[i].split("\\|");
                String stationName = dataFields[1];
                float stationLat = Float.parseFloat(dataFields[2]);
                float stationLon = Float.parseFloat(dataFields[3]);
                String stationElevation = dataFields[4];
                float stationSnowDepth = Float.parseFloat(dataFields[7]);

                Station station = new Station(stationName, stationElevation, stationLat, stationLon, stationSnowDepth);
                float distanceFromTrail = station.distanceTo(Float.parseFloat(lat), Float.parseFloat(lon));
                station.setDistance(distanceFromTrail);

                stations.put(distanceFromTrail, station);
                distances.add(distanceFromTrail);
            }

            Collections.sort(distances);

            for (int i = 0; i < numberOfStations; i++) {
                float distanceKey = distances.get(i);
                nearestStations[i] = stations.get(distanceKey);

            }



        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }




}
