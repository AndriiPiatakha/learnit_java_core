package com.itbulls.learnit.javacore.finaltask.services;

import java.util.List;

import com.itbulls.learnit.javacore.finaltask.enteties.Order;

public interface OrderManagementService {

	void addOrder(Order order);

	List<Order> getOrdersByUserId(int userId);
	
	List<Order> getOrders();

}
