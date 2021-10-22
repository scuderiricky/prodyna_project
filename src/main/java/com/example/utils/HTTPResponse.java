package com.example.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;

public class HTTPResponse {

    private static <T> T mapToJson(String body,Class<T> tClass){
        try {
            return new Gson().fromJson(body, tClass);
        }
        catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T getHTTPJsonResponse(String uri, Class<T> tClass, ResponseHandler<String> responseHandler) throws ClientProtocolException, JsonSyntaxException, IOException, NullPointerException {

        if(responseHandler == null || uri == null || uri.equals("")) {
            throw new NullPointerException("ResponseHandler can't be null");
        }

        String responseBody = null;

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            responseBody = httpclient.execute(new HttpGet(uri), responseHandler);
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return mapToJson(responseBody,tClass);
    }

}
