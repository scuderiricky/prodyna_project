package com.example.business;


import com.example.interfaces.CityBusinessInterface;
import com.example.models.City;
import com.example.models.CityImageURL;
import com.example.utils.ConfigReader;
import com.example.utils.DateUtils;
import com.example.utils.HTTPResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.springframework.web.server.NotAcceptableStatusException;

import java.io.IOException;
import java.util.List;

public class CityLocationLogic implements CityBusinessInterface {

    private final ConfigReader configReader;

    public CityLocationLogic() throws IOException {
        configReader = new ConfigReader("config.properties");
    }

    private ResponseHandler<String> getRequestResponseHandler() {
        return response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new NotAcceptableStatusException("Unexpected response status: " + status);
            }
        };
    }

    public CityImageURL getCityLocation(String cityName) throws IllegalArgumentException, NotAcceptableStatusException, IOException {

        String bingApiKey = configReader.getPropValues("bingApiKey");
        String url = "http://dev.virtualearth.net/REST/v1/Locations/"+cityName+"?includeNeighborhood=0&maxResults=1&key="+bingApiKey;

        return MapToCityImageUrl(HTTPResponse.getHTTPJsonResponse(url, City.class, getRequestResponseHandler()));
    }


    private List<Double> getCoordinatesOfCity(City city){
        return  city.getResourceSets()
                .get(0)
                .getResources()
                .get(0)
                .getGeoCodePoints()
                .get(0)
                .getCoordinates();
    }

    // returns true if city is valid
    private boolean validateCity(City city){
        return  city != null &&
                city.getResourceSets() != null &&
                city.getResourceSets().size() != 0 &&
                city.getResourceSets().get(0).getResources() != null &&
                city.getResourceSets().get(0).getResources().size() != 0 &&
                city.getResourceSets().get(0).getResources().get(0).getGeoCodePoints() != null &&
                city.getResourceSets().get(0).getResources().get(0).getGeoCodePoints().size() != 0 &&
                city.getResourceSets().get(0).getResources().get(0).getGeoCodePoints().get(0).getCoordinates() != null &&
                city.getResourceSets().get(0).getResources().get(0).getGeoCodePoints().get(0).getCoordinates().size() != 0;

    }

    private String buildCityImageUrl(City city) throws IllegalArgumentException {

        if(!validateCity(city)){
            System.out.println("City object is invalid");
            return null;
        }

        List<Double> coordinates = getCoordinatesOfCity(city);
        Double lat = coordinates.get(0);
        Double lon = coordinates.get(1);
        String nasaApiKey = configReader.getPropValues("nasaApiKey");
        String dimension = configReader.getPropValues("dimension");
        String currentYearDate = DateUtils.GetDateFormatString("yyyy-MM-dd",DateUtils.getCurrentYearDate());

        return new StringBuilder()
                .append("https://api.nasa.gov/planetary/earth/imagery?lat=")
                .append(lat)
                .append("&lon=")
                .append(lon)
                .append("&date=")
                .append(currentYearDate)
                .append("&dim=")
                .append(dimension)
                .append("&api_key=")
                .append(nasaApiKey)
                .toString();
    }

    private CityImageURL MapToCityImageUrl(City city) throws IllegalArgumentException {
        return new CityImageURL(buildCityImageUrl(city));
    }
}
