
package com.itbulls.learnit.javacore.dao.hw.template.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.itbulls.learnit.javacore.dao.hw.template.enteties.Order;
import com.itbulls.learnit.javacore.dao.hw.template.services.OrderManagementService;
import com.itbulls.learnit.javacore.dao.hw.template.storage.OrderStoringService;
import com.itbulls.learnit.javacore.dao.hw.template.storage.impl.DefaultOrderStoringService;


public class DefaultOrderManagementService implements OrderManagementService {

	private static DefaultOrderManagementService instance;
	private List<Order> orders;
	private OrderStoringService orderStoringService;
	
	{
		orderStoringService = DefaultOrderStoringService.getInstance();
		orders = orderStoringService.loadOrders();
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
		return orderStoringService.loadOrders().stream()
				.filter(Objects::nonNull)
				.filter(order -> order.getCustomerId() == userId)
				.collect(Collectors.toList());
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
