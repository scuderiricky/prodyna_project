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
	 void TestWrongCityName()  {
		Assertions.assertThrows(IllegalArgumentException.class, () -> cityLocationLogic.getCityLocation("null"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> cityLocationLogic.getCityLocation(null));
	}

	@Test
	void TestRightCityName()  {
		Assertions.assertDoesNotThrow(() -> {cityLocationLogic.getCityLocation("Basel");});
		Assertions.assertDoesNotThrow(() -> {cityLocationLogic.getCityLocation("zürich");});
		Assertions.assertDoesNotThrow(() -> {cityLocationLogic.getCityLocation("Zürich");});
		Assertions.assertDoesNotThrow(() -> {cityLocationLogic.getCityLocation("Zurich");});
	}

}
