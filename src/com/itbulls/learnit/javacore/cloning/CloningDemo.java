package com.itbulls.learnit.javacore.cloning;

import java.util.List;

import com.itbulls.learnit.javacore.finaltask.enteties.Product;
import com.itbulls.learnit.javacore.finaltask.services.ProductManagementService;
import com.itbulls.learnit.javacore.finaltask.services.impl.DefaultProductManagementService;

public class CloningDemo {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		User user = new User();
//		user.clone();
		
		ProductManagementService productService = DefaultProductManagementService.getInstance();
		List<Product> products = productService.getProducts();
		Order order = new Order("1234123412341234", products, 1);
		System.out.println("Original order: " + order);
		
		Order clonedOrder = (Order) order.clone();
		System.out.println("Cloned order: " + clonedOrder);
		
		clonedOrder.getProducts().clear();
		System.out.println("*** Cleared products for cloned order object ***");
		
		System.out.println("Original order: " + order);
		
		System.out.println("===== Deep cloning demo =====");
		DefaultProductManagementService.loadProductsFromStorage();
		products = productService.getProducts();
		System.out.println(products);
		OrderWithDeepCloning order1 = new OrderWithDeepCloning("1234123412341234", products, 1);
		
		var order2 = (OrderWithDeepCloning) order1.clone();
		order2.getProducts().clear();
		
		System.out.println("Original order: " + order1);
		System.out.println("Cloned order: " + order2);
	}

}
