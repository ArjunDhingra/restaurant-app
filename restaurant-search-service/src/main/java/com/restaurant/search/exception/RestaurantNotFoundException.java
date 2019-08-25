package com.restaurant.search.exception;

public class RestaurantNotFoundException extends ServiceException {

	private String message;

	public RestaurantNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
