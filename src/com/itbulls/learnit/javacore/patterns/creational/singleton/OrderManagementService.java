package com.itbulls.learnit.javacore.patterns.creational.singleton;

public class OrderManagementService {
	
	private static OrderManagementService instance;
	
	private OrderManagementService() {
	}
	
	public static synchronized OrderManagementService getInstance() {
		if (instance == null) {
			instance = new OrderManagementService();
		}
		return instance;
	}
	
	public void placeOrder() {
		System.out.println("Place order method is invoked");
	}

}
