package com.itbulls.learnit.javacore.dao.hw.solution.services;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Order;

public interface OrderManagementService {

	void addOrder(Order order);

	List<Order> getOrdersByUserId(int userId);
	
	List<Order> getOrders();

}
