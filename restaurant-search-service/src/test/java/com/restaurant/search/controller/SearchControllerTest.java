package com.restaurant.search.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.search.entity.Restaurant;
import com.restaurant.search.exception.RestaurantNotFoundException;
import com.restaurant.search.exception.ServiceException;
import com.restaurant.search.service.SearchService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {

	@Mock
	SearchService service;

	@InjectMocks
	private SearchController controller;

	@Before
	public void setup() {
	}

	@Test
	public void testSearchByLocation() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantLocation("Banashankari");
		restaurantList.add(restaurant);
		Mockito.when(service.searchByLocation(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenReturn(restaurantList);
		assertNotNull(controller.searchByLocation("Banashankari", 1, 1));
	}

	@Test
	public void testSearchByDistance() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Restaurant restaurant = new Restaurant();
		restaurantList.add(restaurant);
		Mockito.when(service.searchByDistance(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenReturn(restaurantList);
		assertNotNull(controller.searchByDistance("12km", 1, 1));
	}

	@Test
	public void testSearchByCuisine() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Restaurant restaurant = new Restaurant();
		restaurantList.add(restaurant);
		Mockito.when(service.searchByCuisine(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenReturn(restaurantList);
		assertNotNull(controller.searchByCuisine("Indian", 1, 1));
	}

	@Test
	public void testSearchByName() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Restaurant restaurant = new Restaurant();
		restaurantList.add(restaurant);
		Mockito.when(service.searchByName(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenReturn(restaurantList);
		assertNotNull(controller.searchByName("Udupi", 1, 1));
	}

	@Test
	public void testSearchByBudget() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Restaurant restaurant = new Restaurant();
		restaurantList.add(restaurant);
		Mockito.when(service.searchByBudget(ArgumentMatchers.any(Double.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenReturn(restaurantList);
		assertNotNull(controller.searchByBudget(1000, 1, 1));
	}

	@Test
	public void testSearchByRatings() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Restaurant restaurant = new Restaurant();
		restaurantList.add(restaurant);
		Mockito.when(service.searchByRatings(ArgumentMatchers.any(Double.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenReturn(restaurantList);
		assertNotNull(controller.searchByRatings(3, 1, 1));
	}

	@Test(expected = RestaurantNotFoundException.class)
	public void searchByRatingsException() throws ServiceException {
		Mockito.when(service.searchByRatings(ArgumentMatchers.any(Double.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenThrow(new ServiceException("sfdf"));
		assertNotNull(controller.searchByRatings(3,1,1));
	}
	
	@Test(expected = RestaurantNotFoundException.class)
	public void searchByBudgetException() throws ServiceException {
		Mockito.when(service.searchByBudget(ArgumentMatchers.any(Double.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenThrow(new ServiceException("sfdf"));
		assertNotNull(controller.searchByBudget(3,1,1));
	}
	
	@Test(expected = RestaurantNotFoundException.class)
	public void searchByNameException() throws ServiceException {
		Mockito.when(service.searchByName(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenThrow(new ServiceException("sfdf"));
		assertNotNull(controller.searchByName("kfs",1,1));
	}
	
	@Test(expected = RestaurantNotFoundException.class)
	public void searchByCuisineException() throws ServiceException {
		Mockito.when(service.searchByCuisine(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenThrow(new ServiceException("sfdf"));
		assertNotNull(controller.searchByCuisine("kfs",1,1));
	}
	
	@Test(expected = RestaurantNotFoundException.class)
	public void searchByDistanceException() throws ServiceException {
		Mockito.when(service.searchByDistance(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenThrow(new ServiceException("sfdf"));
		assertNotNull(controller.searchByDistance("kfs",1,1));
	}
	
	@Test(expected = RestaurantNotFoundException.class)
	public void searchByLocationException() throws ServiceException {
		Mockito.when(service.searchByLocation(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Integer.class),
				ArgumentMatchers.any(Integer.class))).thenThrow(new ServiceException("sfdf"));
		assertNotNull(controller.searchByLocation("kfs",1,1));
	}
}
