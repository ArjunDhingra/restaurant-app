package com.restaurant.search.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Items {

	@Id
	@GeneratedValue
	private long itemId;
	private double price;
	
}
