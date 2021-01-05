package com.itbulls.learnit.javacore.finaltask.storage;

import java.util.List;

import com.itbulls.learnit.javacore.finaltask.enteties.Order;

public interface OrderStoringService {
	
	void saveOrders(List<Order> order);
	
	List<Order> loadOrders();
}
