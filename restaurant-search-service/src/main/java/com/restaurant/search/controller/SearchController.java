package com.restaurant.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.search.entity.Restaurant;
import com.restaurant.search.exception.RestaurantNotFoundException;
import com.restaurant.search.exception.ServiceException;
import com.restaurant.search.service.SearchService;

@RestController
@RequestMapping(path = "/restaurant/search")
public class SearchController {

	@Autowired
	private SearchService service;

	@GetMapping("/location/{location}/{pageindex}/{size}")
	public List<Restaurant> searchByLocation(@PathVariable String location, @PathVariable int pageindex,
			@PathVariable int size) throws RestaurantNotFoundException {
		try {
			return service.searchByLocation(location, pageindex, size);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}
	}

	@GetMapping("/distance/{distance}/{pageindex}/{size}")
	public List<Restaurant> searchByDistance(@PathVariable String distance, @PathVariable int pageindex,
			@PathVariable int size) throws RestaurantNotFoundException {
		try {
			return service.searchByDistance(distance, pageindex, size);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}
	}

	@GetMapping("/cuisine/{cuisine}/{pageindex}/{size}")
	public List<Restaurant> searchByCuisine(@PathVariable String cuisine, @PathVariable int pageindex,
			@PathVariable int size) throws RestaurantNotFoundException {
		try {
			return service.searchByCuisine(cuisine, pageindex, size);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}
	}

	@GetMapping("/name/{name}/{pageindex}/{size}")
	public List<Restaurant> searchByName(@PathVariable String name, @PathVariable int pageindex, @PathVariable int size)
			throws RestaurantNotFoundException {
		try {
			return service.searchByName(name, pageindex, size);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}
	}

	@GetMapping("/budget/{budget}/{pageindex}/{size}")
	public List<Restaurant> searchByBudget(@PathVariable double budget, @PathVariable int pageindex, @PathVariable int size)
			throws RestaurantNotFoundException {
		try {
			return service.searchByBudget(budget, pageindex, size);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}

	}

	@GetMapping("/ratings/{ratings}/{page}/{size}")
	public List<Restaurant> searchByRatings(@PathVariable double ratings, @PathVariable int pageindex,
			@PathVariable int size) throws RestaurantNotFoundException {
		try {
			return service.searchByRatings(ratings, pageindex, size);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}
	}

}
