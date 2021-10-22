package com.example.models;

import java.util.List;

public class GeocodePoints {

    private String type;
    //List consists of two values. The first value is the latitude, the second the longitude
    private List<Double> coordinates;

    public final List<Double> getCoordinates(){
        return this.coordinates;
    }

    public String getType(){
        return this.type;
    }

}
