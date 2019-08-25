package com.restaurant.order.management.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.restaurant.order.management.entity.Order;
import com.restaurant.order.management.exception.OrderNotFoundException;
import com.restaurant.order.management.exception.ServiceException;
import com.restaurant.order.management.repo.OrderRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrdersServiceImplTest {

	@Mock
	OrderRepository mockRepository;

	@InjectMocks
	OrdersServiceImpl service;

	@Test
	public void testPlaceOrder() throws OrderNotFoundException, ServiceException {
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		Order order = new Order(1, 6.0, "Tea Adda", "Arjun", "Completed", intList);
		Mockito.when(mockRepository.save(order)).thenReturn(order);
		assertEquals("Order Placed", service.placeOrder(order));
	}

	@Test(expected = ServiceException.class)
	public void placeOrderException() throws ServiceException {
		service.placeOrder(null);
	}

	@Test
	public void testUpdateOrder() throws ServiceException {
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		Order updatedOrder = new Order();
		updatedOrder.setOrderId(1);
		updatedOrder.setOrderPrice(6.0);
		updatedOrder.setOrderStatus("Completed");
		updatedOrder.setRestaurantName("Tea Adda");
		updatedOrder.setUserName("Arjun");
		updatedOrder.setItemIds(intList);
		Mockito.when(mockRepository.save(updatedOrder)).thenReturn(updatedOrder);
		assertEquals("Order Updated", service.updateOrder(updatedOrder, 1));
	}

	@Test(expected = ServiceException.class)
	public void updateOrderException() throws ServiceException {
		service.updateOrder(null, 1);
	}

	@Test
	public void testCancelOrder() throws ServiceException {
		Order order = new Order();
		Mockito.when(mockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(order));
		assertNotNull(service.cancelOrder(1));
	}

	@Test(expected = ServiceException.class)
	public void cancelOrderException() throws ServiceException {
		service.cancelOrder(1);
	}

	@Test
	public void testViewOrder() throws ServiceException {
		List<Order> orders = new ArrayList<>();
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		Order order = new Order(1, 6.0, "Tea Adda", "Arjun", "Completed", intList);
		orders.add(order);
		Mockito.when(mockRepository.findByUserName(ArgumentMatchers.any(String.class))).thenReturn(orders);
		assertEquals(orders, service.viewOrder("Arjun"));
		assertEquals(1, order.getOrderId());
		assertNotEquals(5.0, order.getOrderPrice());
		assertEquals("Tea Adda", order.getRestaurantName());
		assertEquals("Arjun", order.getUserName());
		assertEquals("Completed", order.getOrderStatus());
		assertNotNull(order.getItemIds());
		assertNotEquals("1", order.getItemIds().get(0));
	}

	@Test(expected = ServiceException.class)
	public void viewOrderException() throws ServiceException {
		List<Order> orders = new ArrayList<>();
		Mockito.when(mockRepository.findByUserName(ArgumentMatchers.any(String.class))).thenReturn(orders);
		service.viewOrder("");
	}

}
