package com.itbulls.learnit.javacore.exam.template.services;

import java.util.List;

import com.itbulls.learnit.javacore.exam.template.enteties.Order;

public interface OrderManagementService {

	void addOrder(Order order);

	List<Order> getOrdersByUserId(int userId);
	
	List<Order> getOrders();

}
