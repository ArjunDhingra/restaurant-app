package com.restaurant.search.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Menu {

	@Id
	@GeneratedValue
	private long menuId;
	@OneToMany
	private List<Items> items;
//	private double price;
//	@ManyToOne
//	private Restaurant restaurant;
}
