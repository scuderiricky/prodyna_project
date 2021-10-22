package com.example.interfaces;

import com.example.models.CityImageURL;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

public interface CityBusinessInterface {
     CityImageURL getCityLocation(String cityName) throws IOException;
}
