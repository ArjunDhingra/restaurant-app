package com.restaurant.search.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@ApiOperation(value = "Search all Restaurants", notes = "List all restaurants using Paging")
public class SearchServiceImpl implements SearchService {

	private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

	@Autowired
	private RestaurantRepository repository;

	@Override
	@Cacheable(value = "distance")
	public List<Restaurant> searchByDistance(String distance, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByDistance(distance, pageable);
		if (!restaurants.isEmpty()) {
			logger.info("Restaurants searched ");
			return restaurants;
		} else {
			logger.error("Unable to Search Restaurant");
			throw new ServiceException("Unable to Search Restaurant");
		}

	}

	@Override
	@Cacheable(value = "location")
	public List<Restaurant> searchByLocation(String location, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByRestaurantLocation(location, pageable);
		if (!restaurants.isEmpty()) {
			logger.info("Restaurants searched ");
			return restaurants;
		} else {
			logger.error("Unable to Search Restaurant");
			throw new ServiceException("Unable to Search Restaurant");
		}
	}

	@Override
	@Cacheable(value = "cuisine")
	public List<Restaurant> searchByCuisine(String cuisine, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByCuisine(cuisine, pageable);
		if (!restaurants.isEmpty()) {
			logger.info("Restaurants searched ");
			return restaurants;
		} else {
			logger.error("Unable to Search Restaurant");
			throw new ServiceException("Unable to Search Restaurant");
		}
	}

	@Override
	@Cacheable(value = "name")
	public List<Restaurant> searchByName(String name, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByRestaurantName(name, pageable);
		if (!restaurants.isEmpty()) {
			logger.info("Restaurants searched ");
			return restaurants;
		} else {
			logger.error("Unable to Search Restaurant");
			throw new ServiceException("Unable to Search Restaurant");
		}
	}

	@Override
	@Cacheable(value = "budget")
	public List<Restaurant> searchByBudget(double budget, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByBudget(budget, pageable);
		if (!restaurants.isEmpty()) {
			logger.info("Restaurants searched ");
			return restaurants;
		} else {
			logger.error("Unable to Search Restaurant");
			throw new ServiceException("Unable to Search Restaurant");
		}
	}

	@Override
	@Cacheable(value = "ratings")
	public List<Restaurant> searchByRatings(double ratings, int startIndex, int endIndex) throws ServiceException {
		Pageable pageable = PageRequest.of(startIndex, endIndex);
		List<Restaurant> restaurants = repository.findByRatings(ratings, pageable);
		if (!restaurants.isEmpty()) {
			logger.info("Restaurants searched ");
			return restaurants;
		} else {
			logger.error("Unable to Search Restaurant");
			throw new ServiceException("Unable to Search Restaurant");
		}
	}

}
