package com.restaurant.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.search.entity.Restaurant;
import com.restaurant.search.exception.ServiceException;

@Service
public interface SearchService {

//	public List<Restaurant> getRestaurants(Restaurant restaurant);

	public List<Restaurant> searchByLocation(String location, int startIndex, int endIndex) throws ServiceException;

	public List<Restaurant> searchByDistance(String distance, int startIndex, int endIndex) throws ServiceException;

	public List<Restaurant> searchByCuisine(String cuisine, int startIndex, int endIndex) throws ServiceException;

	public List<Restaurant> searchByName(String name, int startIndex, int endIndex) throws ServiceException;

	public List<Restaurant> searchByBudget(double budget, int startIndex, int endIndex) throws ServiceException;

	public List<Restaurant> searchByRatings(double ratings, int startIndex, int endIndex) throws ServiceException;
}
