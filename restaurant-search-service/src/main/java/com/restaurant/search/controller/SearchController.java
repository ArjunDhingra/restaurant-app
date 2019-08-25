package com.restaurant.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	/*
	 * @PostMapping("/getRestaurants") public List<Restaurant>
	 * getRestaurants(@RequestBody Restaurant restaurant) { return
	 * service.getRestaurants(restaurant); }
	 */

	@GetMapping("/location/{location}/{startIndex}/{endIndex}")
	public List<Restaurant> searchByLocation(@PathVariable String location, @RequestParam int startIndex,
			@RequestParam int endIndex) throws RestaurantNotFoundException {
		try {
			return service.searchByLocation(location, startIndex, endIndex);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant" + e);
		}
	}

	/*
	 * @GetMapping("/budget/{budget}/{startIndex}/{endIndex}") public
	 * Map<String,Object> searchByBudget(@PathVariable double budget, @PathVariable
	 * int startIndex,
	 * 
	 * @PathVariable int endIndex) throws RestaurantNotFoundException {
	 * List<Restaurant> restaurants = null; Map<String, Object> responses = new
	 * HashMap<String, Object>(); try { restaurants =
	 * service.searchByBudget(budget,startIndex,endIndex); responses.put("SUCCESS",
	 * "true"); responses.put("BODY", restaurants); responses.put("ERROR", "false");
	 * responses.put("HttpStatus", HttpStatus.OK.value());
	 * responses.put("HttpStatusCode",HttpStatus.OK); } catch (ServiceException e) {
	 * responses.put("Message", "Restaurant Not Found"); responses.put("HttpStatus",
	 * "Error Occured"); responses.put("HttpStatusCode", HttpStatus.BAD_REQUEST);
	 * responses.put("SUCCESS", "false"); responses.put("ERROR", "true"); } return
	 * responses; }
	 */

	@GetMapping("/distance/{distance}/{startIndex}/{endIndex}")
	public List<Restaurant> searchByDistance(@PathVariable String distance, @PathVariable int startIndex,
			@PathVariable int endIndex) throws RestaurantNotFoundException {
		try {
			return service.searchByDistance(distance, startIndex, endIndex);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}
	}

	@GetMapping("/cuisine/{cuisine}/{startIndex}/{endIndex}")
	public List<Restaurant> searchByCuisine(@PathVariable String cuisine, @PathVariable int startIndex,
			@PathVariable int endIndex) throws RestaurantNotFoundException {
		try {
			return service.searchByCuisine(cuisine, startIndex, endIndex);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}
	}

	@GetMapping("/name/{name}/{startIndex}/{endIndex}")
	public List<Restaurant> searchByName(@PathVariable String name, @PathVariable int startIndex,
			@PathVariable int endIndex) throws RestaurantNotFoundException {
		try {
			return service.searchByName(name, startIndex, endIndex);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}
	}

	@GetMapping("/budget/{budget}/{startIndex}/{endIndex}")
	public List<Restaurant> searchByBudget(@PathVariable double budget, @PathVariable int startIndex,
			@PathVariable int endIndex) throws RestaurantNotFoundException {
		try {
			return service.searchByBudget(budget, startIndex, endIndex);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}

	}

	@GetMapping("/ratings/{ratings}/{startIndex}/{endIndex}")
	public List<Restaurant> searchByRatings(@PathVariable double ratings, @PathVariable int startIndex,
			@PathVariable int endIndex) throws RestaurantNotFoundException {
		try {
			return service.searchByRatings(ratings, startIndex, endIndex);
		} catch (ServiceException e) {
			throw new RestaurantNotFoundException("Unable to Search Restaurant");
		}
	}

}
