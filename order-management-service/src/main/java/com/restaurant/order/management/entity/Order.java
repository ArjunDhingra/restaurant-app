package com.restaurant.order.management.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class Order {

	@Id
	@GeneratedValue
	private long orderId;
	private double orderPrice;
	private String restaurantName;
	private String userName;
	private String orderStatus;
	@ElementCollection
	private List<Integer> itemIds;
//	private double numberOfItems;

	/**
	 * @return the orderId
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the restaurantName
	 */
	public String getRestaurantName() {
		return restaurantName;
	}

	/**
	 * @param restaurantName the restaurantName to set
	 */
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the itemIds
	 */
	public List<Integer> getItemIds() {
		return itemIds;
	}

	/**
	 * @param itemIds the itemIds to set
	 */
	public void setItemIds(List<Integer> itemIds) {
		this.itemIds = itemIds;
	}

	/**
	 * @return the orderPrice
	 */
	public double getOrderPrice() {
		return orderPrice;
	}

	/**
	 * @param orderPrice the orderPrice to set
	 */
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order(long orderId, double orderPrice, String restaurantName, String userName, String orderStatus,
			List<Integer> itemIds) {
		super();
		this.orderId = orderId;
		this.orderPrice = orderPrice;
		this.restaurantName = restaurantName;
		this.userName = userName;
		this.orderStatus = orderStatus;
		this.itemIds = itemIds;
	}

	public Order() {
	}

}
