package com.restaurant.order.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.order.management.entity.Order;
import com.restaurant.order.management.exception.ServiceException;

@Service
public interface OrdersService {

	public String placeOrder(Order order) throws ServiceException;

	public String updateOrder(Order order, long id) throws ServiceException;

	public String cancelOrder(long id) throws ServiceException;

//	public ResponseEntity<List<Order>> viewOrder(String userName);

	public List<Order> viewOrder(String userName) throws ServiceException;

}
