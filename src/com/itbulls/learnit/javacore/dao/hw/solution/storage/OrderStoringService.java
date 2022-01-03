package com.itbulls.learnit.javacore.dao.hw.solution.storage;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Order;

public interface OrderStoringService {
	
	void saveOrders(List<Order> order);
	
	List<Order> loadOrders();
}
