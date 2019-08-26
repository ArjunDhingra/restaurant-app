package com.restaurant.search.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "restaurant_search")
@ApiModel(value = "Restaurant", description = "Restaurant resource representation")
public class Restaurant {

	@Id
	@GeneratedValue
	@ApiModelProperty(value = "Restaurant's Id", required = true)
	private long restaurantId;
	@ApiModelProperty(value = "Restaurant's Name", required = true)
	private String restaurantName;
	@ApiModelProperty(value = "Restaurant's Location", required = true)
	private String restaurantLocation;
	@ApiModelProperty(value = "Distance", required = true)
	private String distance;
	@ApiModelProperty(value = "Restaurant's Cuisine", required = true)
	private String cuisine;
	@ApiModelProperty(value = "On Average Budget", required = true)
	private double budget;
	@ApiModelProperty(value = "Ratings provided by users", required = true)
	private double ratings;
	@OneToOne
	@ApiModelProperty(value = "Restaurant's Menu", required = true)
	private Menu menu;

	public Restaurant() {
		super();
	}

	public Restaurant(long restaurantId, String restaurantName, String restaurantLocation, String distance,
			String cuisine, double budget, double ratings, Menu menu) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantLocation = restaurantLocation;
		this.distance = distance;
		this.cuisine = cuisine;
		this.budget = budget;
		this.ratings = ratings;
		this.menu = menu;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
