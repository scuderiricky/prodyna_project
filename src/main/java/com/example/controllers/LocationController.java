package com.example.controllers;
import com.example.business.CityLocationLogic;
import com.example.interfaces.CityBusinessInterface;
import com.example.models.CityImageURL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final CityBusinessInterface cityLocationLogic;

    public LocationController() throws IOException {
        cityLocationLogic = new CityLocationLogic();
    }

    @GetMapping("/")
    public CityImageURL getCityLocation(@RequestParam(value = "city_name") String city_name) throws IOException {
        if(city_name == null || city_name.equals("")){
            return null;
        }
       return cityLocationLogic.getCityLocation(city_name);
    }
}
