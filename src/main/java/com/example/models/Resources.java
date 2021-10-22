package com.example.models;

import java.util.List;

public class Resources {
    private final List<GeocodePoints> geocodePoints;

    private CityAdress address;

    public void setAddress(CityAdress address){
        this.address = address;
    }

    public CityAdress getAddress(){
        return this.address;
    }

    public Resources(List<GeocodePoints> geocodePoints){
        this.geocodePoints = geocodePoints;
    }

    public final List<GeocodePoints> getGeoCodePoints(){
        return geocodePoints;
    }
}
