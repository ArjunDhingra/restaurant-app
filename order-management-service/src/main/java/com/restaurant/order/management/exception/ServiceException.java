package com.restaurant.order.management.exception;

public class ServiceException extends Exception {

	private String message;

	public ServiceException(String message) {
		super(message);
		this.message=message;
	}

}
