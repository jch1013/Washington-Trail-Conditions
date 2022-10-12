package com.WTC.WashingtonTrailConditions;

import com.WTC.WashingtonTrailConditions.Models.Trail;
import com.WTC.WashingtonTrailConditions.Repositories.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class WashingtonTrailConditionsApplication implements CommandLineRunner {
	@Autowired TrailRepository trailRepository;

	public static void main(String[] args) {
		SpringApplication.run(WashingtonTrailConditionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// used to read data from csv and save to database
		/*Scanner sc = new Scanner(new File("hikeData.csv"));
		sc.useDelimiter("\n");
		int i = 0;
		while (sc.hasNext()) {
			String data = sc.next();
			String[] trailData = data.split(",");

			String name = trailData[0];
			String region = trailData[1];
			String image = trailData[2];
			String lat = trailData[3];
			String lon = trailData[4];
			String link = trailData[5];
			i++;
			System.out.println(link);
			System.out.println(i);

			Trail toAdd = new Trail(name, region, image, lat, lon, link);
			// trailRepository.save(toAdd);
		}
		sc.close();*/

	}

}
