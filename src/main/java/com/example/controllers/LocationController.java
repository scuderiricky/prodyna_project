package com.example.controllers;
import com.example.business.CityLocationLogic;
import com.example.interfaces.CityBusinessInterface;
import com.example.models.CityImageURL;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "*")
public class LocationController {

    private final CityBusinessInterface cityLocationLogic;

    public LocationController() throws IOException {
        cityLocationLogic = new CityLocationLogic();
    }

    @GetMapping("/")
    public CityImageURL getCityLocation(@RequestParam(value = "city_name") String city_name) throws IOException {
        if(city_name == null || city_name.equals("")){
            return new CityImageURL(null);
        }
        return cityLocationLogic.getCityLocation(city_name);
    }
}
