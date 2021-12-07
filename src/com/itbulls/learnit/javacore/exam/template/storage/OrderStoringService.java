package com.itbulls.learnit.javacore.exam.template.storage;

import java.util.List;

import com.itbulls.learnit.javacore.exam.template.enteties.Order;

public interface OrderStoringService {
	
	void saveOrders(List<Order> order);
	
	List<Order> loadOrders();
}
