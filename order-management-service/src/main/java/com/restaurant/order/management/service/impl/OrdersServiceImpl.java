package com.restaurant.order.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.restaurant.order.management.controller.OrdersController;
import com.restaurant.order.management.entity.Order;
import com.restaurant.order.management.exception.ServiceException;
import com.restaurant.order.management.repo.OrderRepository;
import com.restaurant.order.management.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

	@Autowired
	private OrderRepository repository;

	@Override
	@Cacheable("orders")
	public String placeOrder(Order order) throws ServiceException {
		try {
			logger.info("Placing Order started");
			Double price = 0.0;
			List<Integer> itemId = order.getItemIds();
			for (int i : itemId) {
				price = price + i;
			}
			order.setOrderPrice(price);
			repository.save(order);
			logger.info("Successfully Placed Order");
		} catch (Exception e) {
			logger.error("Unable to Place Order" + e.getMessage());
			throw new ServiceException("Unable to place Order" + e.getMessage());
		}
		return "Order Placed";

	}

	@Override
	public String updateOrder(Order order, long id) throws ServiceException {
		try {
			logger.info("Updating Order started");
			order.setOrderId(id);
			Double price = 0.0;
			List<Integer> itemIds = order.getItemIds();
			for (int itemId : itemIds) {
				price = price + itemId;
			}
			order.setOrderPrice(price);
			repository.save(order);
			logger.info("Successfully updated order");
		} catch (Exception e) {
			logger.error("Unable to Update Order");
			throw new ServiceException("Unable to Update Order");
		}

		return "Order Updated";
	}

	@Override
	@Cacheable(value="cancel-order")
	public String cancelOrder(long id) throws ServiceException {
		try {
			logger.info("Cancelling Order Started");
			Optional<Order> order = repository.findById(id);
			Order orderDetails = order.get();
			orderDetails.setOrderStatus("Cancelled");
			repository.save(orderDetails);
			logger.info("Successfully Cancelled Order");
		} catch (Exception e) {
			logger.error("Unable to cancel order");
			throw new ServiceException("Unable to cancel order");
		}

		return "Order Cancelled";
	}

	@Override
	@Cacheable(value="view-order")
	public List<Order> viewOrder(String userName) throws ServiceException {
		List<Order> orderDetails = new CopyOnWriteArrayList<>();
		List<Order> orders = new ArrayList<>();
		orderDetails = repository.findByUserName(userName);
		for (Order order : orderDetails) {
			if (!order.getOrderStatus().equals("Cancelled"))
				orders.add(order);
		}
		if (!orders.isEmpty()) {
			logger.info("Order Viewed Successfully");
			return orders;
		} else {
			logger.error("Unable to View Order");
			throw new ServiceException("Unable to View Order");
		}

	}

}
