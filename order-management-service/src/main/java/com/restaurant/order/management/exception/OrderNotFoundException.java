package com.restaurant.order.management.exception;

public class OrderNotFoundException extends ServiceException {

	String message;
	
	public OrderNotFoundException(String message) {
		super(message);
		this.message = message;
		
	}

}
