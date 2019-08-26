package com.restaurant.search.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Menu {

	@Id
	@GeneratedValue
	private long menuId;
	@OneToMany
	private List<Items> items;

	public Menu() {
		super();
	}

	public Menu(long menuId, List<Items> items) {
		super();
		this.menuId = menuId;
		this.items = items;
	}

	/**
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the items
	 */
	public List<Items> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Items> items) {
		this.items = items;
	}

}
