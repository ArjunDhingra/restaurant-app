package com.restaurant.search.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import com.restaurant.search.entity.Items;
import com.restaurant.search.entity.Menu;
import com.restaurant.search.entity.Restaurant;
import com.restaurant.search.exception.ServiceException;
import com.restaurant.search.repo.RestaurantRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SearchServiceImplTest {

	@Mock
	RestaurantRepository mockRepository;

	@InjectMocks
	SearchServiceImpl searchService;

	@Test
	public void testSearchByLocation() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Menu menu = new Menu();
		menu.setMenuId(1);
		List<Items> items = new ArrayList<>();
		Items item = new Items();
		item.setItemId(1);
		item.setPrice(1000);
		items.add(item);
		menu.setItems(items);
		Restaurant restaurant = new Restaurant(1, "Tea Adda", "Banashankari", "12km", "Indian", 1000, 3, menu);
		restaurantList.add(restaurant);
		Mockito.when(mockRepository.findByRestaurantLocation(ArgumentMatchers.any(String.class),
				ArgumentMatchers.any(Pageable.class))).thenReturn(restaurantList);
		assertEquals(restaurantList, searchService.searchByLocation("Banashankari", 1, 1));
	}
	@Test
	public void testSearchByDistance() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Restaurant restaurant = new Restaurant(1, "Tea Adda", "Banashankari", "12km", "Indian", 1000, 3, null);
		restaurantList.add(restaurant);
		Mockito.when(
				mockRepository.findByDistance(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Pageable.class)))
				.thenReturn(restaurantList);
		assertEquals(restaurantList, searchService.searchByDistance("12km", 1, 1));
	}

	@Test
	public void testSearchByCuisine() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Restaurant restaurant = new Restaurant(1, "Tea Adda", "Banashankari", "12km", "Indian", 1000, 3, null);
		restaurantList.add(restaurant);
		Mockito.when(
				mockRepository.findByCuisine(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Pageable.class)))
				.thenReturn(restaurantList);
		assertEquals(restaurantList, searchService.searchByCuisine("Indian", 1, 1));
	}

	@Test
	public void testSearchByName() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		List<Items> items = new ArrayList<>();
		Items item = new Items(1, 1000);
		items.add(item);
		Menu menu = new Menu(1, items);
		Restaurant restaurant = new Restaurant(1, "Tea Adda", "Banashankari", "12km", "Indian", 1000, 3, menu);
		restaurantList.add(restaurant);
		Mockito.when(mockRepository.findByRestaurantName(ArgumentMatchers.any(String.class),
				ArgumentMatchers.any(Pageable.class))).thenReturn(restaurantList);
		assertEquals(restaurantList, searchService.searchByName("Tea Adda", 1, 1));
		assertEquals("12km", restaurantList.get(0).getDistance());
		assertEquals("Tea Adda", restaurantList.get(0).getRestaurantName());
		assertEquals("Indian", restaurantList.get(0).getCuisine());
		assertNotEquals(2, restaurantList.get(0).getRatings());
		assertEquals(1, restaurantList.get(0).getRestaurantId());
		assertEquals("Banashankari", restaurantList.get(0).getRestaurantLocation());
		assertNotEquals(100.00, restaurantList.get(0).getBudget());
		assertNotNull(restaurantList.get(0).getMenu());
		assertEquals(1, restaurantList.get(0).getMenu().getMenuId());
		assertNotNull(restaurantList.get(0).getMenu().getItems());
		assertEquals(1, restaurantList.get(0).getMenu().getItems().get(0).getItemId());
		assertNotEquals(100, restaurantList.get(0).getMenu().getItems().get(0).getPrice());

	}

	@Test
	public void testSearchByBudget() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Restaurant restaurant = new Restaurant();
		restaurant.setBudget(1000);
		restaurant.setCuisine("Indian");
		restaurant.setDistance("12km");
		restaurant.setRatings(3);
		restaurant.setRestaurantId(1);
		restaurant.setRestaurantLocation("Banashankari");
		restaurant.setRestaurantName("Tea Adda");
		restaurant.setMenu(null);
		restaurantList.add(restaurant);
		Mockito.when(
				mockRepository.findByBudget(ArgumentMatchers.any(Double.class), ArgumentMatchers.any(Pageable.class)))
				.thenReturn(restaurantList);
		assertEquals(restaurantList, searchService.searchByBudget(1000, 1, 1));
		assertEquals("12km", restaurantList.get(0).getDistance());
		assertEquals("Tea Adda", restaurantList.get(0).getRestaurantName());
	}

	@Test
	public void testSearchByRatings() throws ServiceException {
		List<Restaurant> restaurantList = new ArrayList<>();
		Restaurant restaurant = new Restaurant(1, "Tea Adda", "Banashankari", "12km", "Indian", 1000, 3, null);
		restaurantList.add(restaurant);
		Mockito.when(
				mockRepository.findByRatings(ArgumentMatchers.any(Double.class), ArgumentMatchers.any(Pageable.class)))
				.thenReturn(restaurantList);
		assertEquals(restaurantList, searchService.searchByRatings(3, 1, 1));
		assertEquals("12km", restaurantList.get(0).getDistance());
		assertEquals("Tea Adda", restaurantList.get(0).getRestaurantName());
	}

	@Test(expected = Exception.class)
	public void searchByRatingsException() throws ServiceException {
		List<Restaurant> restaurants = new ArrayList<>();
		Mockito.when(
				mockRepository.findByRatings(ArgumentMatchers.any(Double.class), ArgumentMatchers.any(Pageable.class)))
				.thenReturn(restaurants);
		searchService.searchByRatings(0, 0, 1);
	}

	@Test(expected = ServiceException.class)
	public void searchByBudgetException() throws ServiceException {
		List<Restaurant> restaurants = new ArrayList<>();
		Mockito.when(
				mockRepository.findByBudget(ArgumentMatchers.any(Double.class), ArgumentMatchers.any(Pageable.class)))
				.thenReturn(restaurants);
		searchService.searchByBudget(0, 0, 1);
	}

	@Test(expected = ServiceException.class)
	public void searchByLocationException() throws ServiceException {
		List<Restaurant> restaurants = new ArrayList<>();
		Mockito.when(mockRepository.findByRestaurantLocation(ArgumentMatchers.any(String.class),
				ArgumentMatchers.any(Pageable.class))).thenReturn(restaurants);
		searchService.searchByLocation("", 0, 1);
	}

	@Test(expected = ServiceException.class)
	public void searchByDistanceException() throws ServiceException {
		List<Restaurant> restaurants = new ArrayList<>();
		Mockito.when(
				mockRepository.findByDistance(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Pageable.class)))
				.thenReturn(restaurants);
		searchService.searchByDistance("", 0, 1);
	}

	@Test(expected = ServiceException.class)
	public void searchByCuisineException() throws ServiceException {
		List<Restaurant> restaurants = new ArrayList<>();
		Mockito.when(
				mockRepository.findByCuisine(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Pageable.class)))
				.thenReturn(restaurants);
		searchService.searchByCuisine("", 0, 1);
	}

	@Test(expected = ServiceException.class)
	public void searchByNameException() throws ServiceException {
		List<Restaurant> restaurants = new ArrayList<>();
		Mockito.when(mockRepository.findByRestaurantName(ArgumentMatchers.any(String.class),
				ArgumentMatchers.any(Pageable.class))).thenReturn(restaurants);
		searchService.searchByName("", 0, 1);
	}

}