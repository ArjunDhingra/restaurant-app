package com.restaurant.order.management.controller;

import java.util.List;

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

	@Autowired
	private OrdersService service;

	@PostMapping("/place")
	public String placeOrder(@RequestBody Order order) throws OrderNotFoundException {
		try {
			service.placeOrder(order);
		} catch (ServiceException e) {
			throw new OrderNotFoundException("Unable to Place Order");
		}
		return "Order Placed";
	}

	@PutMapping("/update/{id}")
	public String updateOrder(@RequestBody Order order, @PathVariable long id) throws OrderNotFoundException {
		try {
			service.updateOrder(order, id);
		} catch (ServiceException e) {
			throw new OrderNotFoundException("Unable to update order");
		}
		return "Order Updated";
	}

	@GetMapping("/cancel/{id}")
	public String cancelOrder(@PathVariable long id) throws OrderNotFoundException {
		try {
			service.cancelOrder(id);
		} catch (ServiceException e) {
			throw new OrderNotFoundException("Unable to cancel order");
		}
		return "Order Cancelled";
	}

	/*
	 * @GetMapping("/view/{userName}") public ResponseEntity<List<Order>>
	 * viewOrder(@PathVariable String userName){ return service.viewOrder(userName);
	 * }
	 */

	@GetMapping("/view/{userName}")
	public List<Order> viewOrder(@PathVariable String userName) throws OrderNotFoundException {
		try {
			return service.viewOrder(userName);
		} catch (ServiceException e) {
			throw new OrderNotFoundException("Unable to view order");
		}
	}

}
