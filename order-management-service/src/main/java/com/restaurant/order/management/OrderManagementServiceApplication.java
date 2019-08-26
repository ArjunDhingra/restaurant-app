package com.restaurant.order.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OrderManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementServiceApplication.class, args);
	}

}
