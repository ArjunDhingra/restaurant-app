package com.restaurant.order.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.order.management.entity.Order;
import com.restaurant.order.management.exception.OrderNotFoundException;
import com.restaurant.order.management.exception.ServiceException;
import com.restaurant.order.management.service.OrdersService;

@RestController
@RequestMapping(path = "/order")
public class OrdersController {

	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

	@Autowired
	private OrdersService service;

	@PostMapping("/place")
	public String placeOrder(@RequestBody Order order) throws OrderNotFoundException {
		try {
			logger.info("Placing Order");
			service.placeOrder(order);
			logger.info("Order Placed");
		} catch (ServiceException e) {
			logger.error("Unable to Place Order" +e.getMessage());
			throw new OrderNotFoundException("Unable to Place Order");
		}
		return "Order Placed";
	}

	@PutMapping("/update/{id}")
	public String updateOrder(@RequestBody Order order, @PathVariable long id) throws OrderNotFoundException {
		try {
			logger.info("Updating Order");
			service.updateOrder(order, id);
			logger.info("Order Updated");
		} catch (ServiceException e) {
			logger.error("Unable to update Order");
			throw new OrderNotFoundException("Unable to update order");
		}
		return "Order Updated";
	}

	@GetMapping("/cancel/{id}")
	public String cancelOrder(@PathVariable long id) throws OrderNotFoundException {
		try {
			logger.info("Cancelling Order");
			service.cancelOrder(id);
			logger.info("Order Cancelled");
		} catch (ServiceException e) {
			logger.error("Unable to cancel Order");
			throw new OrderNotFoundException("Unable to cancel order");
		}
		return "Order Cancelled";
	}

	@GetMapping("/view/{userName}")
	public List<Order> viewOrder(@PathVariable String userName) throws OrderNotFoundException {
		try {
			logger.info("Order Viewed");
			return service.viewOrder(userName);
		} catch (ServiceException e) {
			logger.error("Unable to view Order");
			throw new OrderNotFoundException("Unable to view order");
		}
	}

}
