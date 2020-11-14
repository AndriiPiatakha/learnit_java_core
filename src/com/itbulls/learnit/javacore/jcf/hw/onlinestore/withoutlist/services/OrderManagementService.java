package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.services;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.enteties.Order;

public interface OrderManagementService {

	void addOrder(Order order);

	Order[] getOrdersByUserId(int userId);
	
	Order[] getOrders();

}
