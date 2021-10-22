package com.example.models;

import java.util.List;

public class City {
    private final List<ResourceSets> resourceSets;

    public City(List<ResourceSets> resourceSets){
        this.resourceSets = resourceSets;
    }

    public final List<ResourceSets> getResourceSets(){
        return this.resourceSets;
    }

}
