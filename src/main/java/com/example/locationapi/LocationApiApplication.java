package com.example.locationapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.example.controllers"})
public class LocationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationApiApplication.class, args);
	}

}
