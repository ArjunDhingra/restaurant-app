package com.restaurant.search.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.restaurant.search.entity.Restaurant;
import com.restaurant.search.exception.ServiceException;
import com.restaurant.search.repo.RestaurantRepository;
import com.restaurant.search.service.SearchService;

import io.swagger.annotations.ApiOperation;

@Service
@ApiOperation(value="Search all Restaurants",notes="List all restaurants using Paging")
public class SearchServiceImpl implements SearchService {

	@Autowired
	private RestaurantRepository repository;

	@Override
	@Cacheable(value="restaurants")
	public List<Restaurant> searchByDistance(String distance, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByDistance(distance, pageable);
		if (!restaurants.isEmpty())
			return restaurants;
		else
			throw new ServiceException("Unable to Search Restaurant");
	}

	@Override
	@Cacheable(value="restaurants")
	public List<Restaurant> searchByLocation(String location, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByRestaurantLocation(location, pageable);
		if (!restaurants.isEmpty())
			return restaurants;
		else
			throw new ServiceException("Unable to Search Restaurant");
	}

	@Override
	@Cacheable(value="restaurants")
	public List<Restaurant> searchByCuisine(String cuisine, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByCuisine(cuisine, pageable);
		if (!restaurants.isEmpty())
			return restaurants;
		else
			throw new ServiceException("Unable to Search Restaurant");
	}

	@Override
	@Cacheable(value="restaurants")
	public List<Restaurant> searchByName(String name, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByRestaurantName(name, pageable);
		if (!restaurants.isEmpty())
			return restaurants;
		else
			throw new ServiceException("Unable to Search Restaurant");
	}

	@Override
	@Cacheable(value="restaurants")
	public List<Restaurant> searchByBudget(double budget, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByBudget(budget, pageable);
		if (!restaurants.isEmpty())
			return restaurants;
		else
			throw new ServiceException("Unable to Search Restaurant");
	}

	@Override
	@Cacheable(value="restaurants")
	public List<Restaurant> searchByRatings(double ratings, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByRatings(ratings, pageable);
		if (!restaurants.isEmpty())
			return restaurants;
		else
			throw new ServiceException("Unable to Search Restaurant");
	}

}
