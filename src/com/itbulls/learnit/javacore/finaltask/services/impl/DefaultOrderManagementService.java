
package com.itbulls.learnit.javacore.finaltask.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.javacore.finaltask.enteties.Order;
import com.itbulls.learnit.javacore.finaltask.services.OrderManagementService;
import com.itbulls.learnit.javacore.finaltask.storage.OrderStoringService;
import com.itbulls.learnit.javacore.finaltask.storage.impl.DefaultOrderStoringService;


public class DefaultOrderManagementService implements OrderManagementService {

	private static DefaultOrderManagementService instance;
	private List<Order> orders;
	private OrderStoringService orderStoringService;
	
	{
		orders = new ArrayList<>();
		orderStoringService = DefaultOrderStoringService.getInstance();
	}
	
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		if (order == null) {
			return;
		}
		orders.add(order);
		orderStoringService.saveOrders(orders);
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		List<Order> userOrders = new ArrayList<>();
		for (Order order : orderStoringService.loadOrders()) {
			if (order != null && order.getCustomerId() == userId) {
				userOrders.add(order);
			}
		}
		
		return userOrders;
	}

	@Override
	public List<Order> getOrders() {
		if (orders == null || orders.size() == 0) {
			orders = orderStoringService.loadOrders();
		}
		return this.orders;
	}
	
	void clearServiceState() {
		orders.clear();
	}

}
