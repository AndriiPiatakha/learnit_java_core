package com.itbulls.learnit.javacore.dao.hw.template.services;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.template.enteties.Order;

public interface OrderManagementService {

	void addOrder(Order order);

	List<Order> getOrdersByUserId(int userId);
	
	List<Order> getOrders();

}
