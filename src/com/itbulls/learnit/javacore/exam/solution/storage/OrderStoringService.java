package com.itbulls.learnit.javacore.exam.solution.storage;

import java.util.List;

import com.itbulls.learnit.javacore.exam.solution.enteties.Order;

public interface OrderStoringService {
	
	void saveOrders(List<Order> order);
	
	List<Order> loadOrders();
}
