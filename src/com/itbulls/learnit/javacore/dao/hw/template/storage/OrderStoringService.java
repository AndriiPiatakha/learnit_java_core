package com.itbulls.learnit.javacore.dao.hw.template.storage;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.template.enteties.Order;

public interface OrderStoringService {
	
	void saveOrders(List<Order> order);
	
	List<Order> loadOrders();
}
