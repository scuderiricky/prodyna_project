package com.example.locationapi;

import com.example.business.CityLocationLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class LocationApiApplicationTests {

	//INTERNET CONNECTION REQUIRED

	private static CityLocationLogic cityLocationLogic;
	@BeforeAll
	static void contextLoads() throws IOException {
		cityLocationLogic = new CityLocationLogic();
	}

	@Test
	 void TestWrongCityName() throws IOException {
		Assertions.assertNull(cityLocationLogic.getCityLocation("null").getCityImageUrl());
		Assertions.assertNull(cityLocationLogic.getCityLocation(null).getCityImageUrl());
	}

	@Test
	void TestRightCityName() throws IOException {
		Assertions.assertNotNull(cityLocationLogic.getCityLocation("Basel"));
		Assertions.assertNotNull(cityLocationLogic.getCityLocation("zürich"));
		Assertions.assertNotNull(cityLocationLogic.getCityLocation("Zürich"));
		Assertions.assertNotNull(cityLocationLogic.getCityLocation("Zurich"));
	}

}
