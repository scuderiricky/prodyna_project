package com.example.models;

public class CityAdress {
    private String locality;
    private String countryRegion;

    public void setCountryRegion(String countryRegion){
        this.countryRegion = countryRegion;
    }
    public void setLocality(String locality){
        this.locality = locality;
    }

    public String getLocality(){
        return this.locality;
    }

    public String getCountryRegion(){
        return this.countryRegion;
    }
}
