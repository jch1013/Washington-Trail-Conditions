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
		Scanner scanner = new Scanner(new File("src/main/java/com/WTC/WashingtonTrailConditions/Services/traildata.csv"));
		scanner.useDelimiter(",");
		while (scanner.hasNext()) {
			String trail = scanner.nextLine();
			String[] trailData = trail.split(",");

			String name = trailData[0];
			String region = trailData[1];
			String imageLink = trailData[2];
			String lat = trailData[3];
			String lon = trailData[4];
			String link = trailData[5];

			// Trail newTrail = new Trail(name, region, imageLink, lat, lon, link);
			// System.out.println(newTrail);
			// trailRepository.save(newTrail);
		}
	}

}
