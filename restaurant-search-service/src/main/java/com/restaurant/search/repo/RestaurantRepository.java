package com.restaurant.search.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.search.entity.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

	List<Restaurant> findByCuisine(String cuisine, Pageable pageable);

	List<Restaurant> findByDistance(String distance, Pageable pageable);

	List<Restaurant> findByRestaurantLocation(String restaurantLocation, Pageable pageable);

	List<Restaurant> findByRestaurantName(String restaurantName, Pageable pageable);

	List<Restaurant> findByRatings(double ratings, Pageable pageable);

	List<Restaurant> findByBudget(double budget, Pageable pageable);
}
