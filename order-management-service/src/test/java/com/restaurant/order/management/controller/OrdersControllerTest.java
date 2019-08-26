package com.restaurant.order.management.controller;

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

import com.restaurant.order.management.entity.Order;
import com.restaurant.order.management.exception.OrderNotFoundException;
import com.restaurant.order.management.exception.ServiceException;
import com.restaurant.order.management.service.OrdersService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrdersControllerTest {

	@Mock
	private OrdersService service;

	@InjectMocks
	private OrdersController controller;

	@Before
	public void setup() {

	}

	@Test
	public void testPlaceOrder() throws OrderNotFoundException, ServiceException {
		Order order = new Order();
		Mockito.when(service.placeOrder(Mockito.any(Order.class))).thenReturn("Order Placed");
		assertNotNull(controller.placeOrder(order));
	}

	@Test
	public void testUpdateOrder() throws OrderNotFoundException, ServiceException {
		Order order = new Order();
		Mockito.when(service.updateOrder(Mockito.any(Order.class),Mockito.anyLong())).thenReturn("Order Updated");
		assertNotNull(controller.updateOrder(order,1));
	}

	@Test
	public void testCancelOrder() throws OrderNotFoundException, ServiceException {
		Mockito.when(service.cancelOrder(Mockito.anyLong())).thenReturn("Order Cancelled");
		assertNotNull(controller.cancelOrder(1));
	}

	@Test
	public void testViewOrder() throws OrderNotFoundException, ServiceException {
		List<Order> orders = new ArrayList<>();
		Order order = new Order();
		orders.add(order);
		Mockito.when(service.viewOrder(Mockito.anyString())).thenReturn(orders);
		assertNotNull(controller.viewOrder("Arjun"));
	}
	
	@Test(expected = OrderNotFoundException.class)
	public void cancelOrderException() throws ServiceException {
		Mockito.when(service.cancelOrder(ArgumentMatchers.any(Long.class))).thenThrow(new ServiceException("sfdf"));
		assertNotNull(controller.cancelOrder(1));
	}
	
	@Test(expected = OrderNotFoundException.class)
	public void placeOrderException() throws ServiceException {
		Order order = new Order();
		Mockito.when(service.placeOrder(ArgumentMatchers.any(Order.class))).thenThrow(new ServiceException("sfdf"));
		assertNotNull(controller.placeOrder(order));
	}
	
	@Test(expected = OrderNotFoundException.class)
	public void viewOrderException() throws ServiceException {
		Mockito.when(service.viewOrder(ArgumentMatchers.any(String.class))).thenThrow(new ServiceException("sfdf"));
		assertNotNull(controller.viewOrder("ahdb"));
	}
	
	@Test(expected = OrderNotFoundException.class)
	public void updateOrderException() throws ServiceException {
		Order order = new Order();
		Mockito.when(service.updateOrder(ArgumentMatchers.any(Order.class), ArgumentMatchers.any(Long.class))).thenThrow(new ServiceException("sfdf"));
		assertNotNull(controller.updateOrder(order,1));
	}

}
