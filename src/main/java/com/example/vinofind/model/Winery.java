package com.example.vinofind.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
public class Winery extends BaseEntity{
    @Id
    private Long id;
    private String name;
    private double Longitude;
    private double Latitude;
    private double rating;
    private int numberOfRatings;

    public Winery(Long id, String name, double longitude, double latitude){
        super();
        this.id = id;
        this.name = name;
        this.Longitude = longitude;
        this.Latitude = latitude;
        this.rating = 0;
        this.numberOfRatings = 0;
    }

    public Winery() {

    }

    public boolean equals(Winery winery){
        return this.getId().equals(winery.getId());
    }

}
