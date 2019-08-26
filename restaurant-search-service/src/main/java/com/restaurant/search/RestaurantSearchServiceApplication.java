package com.restaurant.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RestaurantSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantSearchServiceApplication.class, args);
	}

}
