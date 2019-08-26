package com.restaurant.order.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.restaurant.order.management.entity.Order;
import com.restaurant.order.management.exception.ServiceException;
import com.restaurant.order.management.repo.OrderRepository;
import com.restaurant.order.management.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrderRepository repository;

	@Override
	@Cacheable("orders")
	public String placeOrder(Order order) throws ServiceException {
		try {
			Double price = 0.0;
			List<Integer> itemId = order.getItemIds();
			for (int i : itemId) {
				price = price + i;
			}
			order.setOrderPrice(price);
			repository.save(order);
		} catch (Exception e) {
			throw new ServiceException("Unable to place Order");
		}
		return "Order Placed";

	}

	@Override
	public String updateOrder(Order order, long id) throws ServiceException {
		try {
			order.setOrderId(id);
			Double price = 0.0;
			List<Integer> itemIds = order.getItemIds();
			for (int itemId : itemIds) {
				price = price + itemId;
			}
			order.setOrderPrice(price);
			repository.save(order);
		} catch (Exception e) {
			throw new ServiceException("Unable to Update Order");
		}

		return "Order Updated";
	}

	@Override
	public String cancelOrder(long id) throws ServiceException {
		try {
			Optional<Order> order = repository.findById(id);
			Order orderDetails = order.get();
			orderDetails.setOrderStatus("Cancelled");
			repository.save(orderDetails);
		} catch (Exception e) {
			throw new ServiceException("Unable to cancel order");
		}

		return "Order Cancelled";
	}

	@Override
	public List<Order> viewOrder(String userName) throws ServiceException {
		List<Order> orderDetails = repository.findByUserName(userName);
		for (Order order : orderDetails) {
			if (order.getOrderStatus().equals("Cancelled"))
				orderDetails.remove(order);
		}
		if (!orderDetails.isEmpty() || orderDetails.size() != 0)
			return orderDetails;
		else
			throw new ServiceException("Unable to View Order");

	}

}
