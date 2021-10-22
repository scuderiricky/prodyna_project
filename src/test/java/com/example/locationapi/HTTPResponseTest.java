package com.example.locationapi;

import com.example.utils.HTTPResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class HTTPResponseTest {
    //INTERNET CONNECTION REQUIRED
    @Test
    void testGetHTTPJsonResponseWrongUri() throws IOException {
      Assertions.assertThrows(NullPointerException.class, ()->HTTPResponse.getHTTPJsonResponse(null,Object.class, httpResponse -> null));
        try {
            HTTPResponse.getHTTPJsonResponse("asdsadjiu",Object.class, httpResponse -> null);
        }
        catch (ClientProtocolException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void testGetHTTPJsonResponseNullableResponseHandler() {
        Assertions.assertThrows(NullPointerException.class, ()-> HTTPResponse.getHTTPJsonResponse("http://google.com",Object.class, null));
    }

    @Test
    void testGetHTTPJsonResponseRight() throws IOException {
        Assertions.assertTrue(HTTPResponse.getHTTPJsonResponse("https://api.coindesk.com/v1/bpi/currentprice.json",Object.class,response -> {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
        }) != null);
    }

}
