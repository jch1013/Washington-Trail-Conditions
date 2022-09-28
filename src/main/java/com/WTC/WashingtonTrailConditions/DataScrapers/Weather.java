package com.WTC.WashingtonTrailConditions.DataScrapers;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Weather {
    private List<String> forecasts = new ArrayList<>();


    public Weather(String lat, String lon) {
        try {
            addForecasts(lat, lon);
        } catch (IOException ioe) {
            forecasts.add("Error retrieving forecast. Please try again later");
        }

    }

    public List<String> getForecasts() {
        return forecasts;
    }

    public void addForecasts(String lat, String lon) throws IOException {
        //scrape web forecasts here and call addForecasts in constructor
        String searchUrl = "https://forecast.weather.gov/MapClick.php?lon=" + URLEncoder.encode(lon, "UTF-8") +
                "&lat=" + URLEncoder.encode(lat, "UTF-8");

        // Web client setup
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        HtmlPage page = client.getPage(searchUrl);

        List<HtmlDivision> labels = page.getByXPath("//div[@class='col-sm-2 forecast-label']");
        List<HtmlDivision> forecastText = page.getByXPath("//div[@class='col-sm-10 forecast-text']");

        for (int i = 0; i < labels.size(); i++) {

            String label = labels.get(i).getTextContent();
            String text = forecastText.get(i).getTextContent();
            forecasts.add(label + ": " + text);
        }

    }
}
