package com.itbulls.learnit.javacore.patterns.creational.singleton;

public class Demo {
	
	public static void main(String[] args) {
		var orderManagService1 = OrderManagementService.getInstance();
		var orderManagService2 = OrderManagementService.getInstance();
		
//		var orderManagService3 = new OrderManagementService();
		
		System.out.println(orderManagService1 == orderManagService2);
		orderManagService1.placeOrder();
	}

}
