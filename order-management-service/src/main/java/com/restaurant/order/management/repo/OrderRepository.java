package com.restaurant.order.management.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.order.management.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findByUserName(String userName);


}
