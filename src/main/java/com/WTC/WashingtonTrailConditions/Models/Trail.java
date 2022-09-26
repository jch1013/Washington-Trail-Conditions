package com.WTC.WashingtonTrailConditions.Models;

import javax.persistence.Entity;
import org.springframework.stereotype.Indexed;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Indexed
@Table(name = "trail")
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String region;
    private String imageLink;
    private String latitude;
    private String longitude;
    private String link;


    public Trail(){
    }

    public Trail(String setName, String setRegion, String setImageLink, String setLat, String setLong, String setLink){
        this.name = setName;
        this.region = setRegion;
        this.imageLink = setImageLink;
        this.latitude = setLat;
        this.longitude = setLong;
        this.link = setLink;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trail trail = (Trail) o;

        return Objects.equals(id, trail.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}

