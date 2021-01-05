package com.itbulls.learnit.javacore.cloning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.itbulls.learnit.javacore.finaltask.enteties.Product;

public class OrderWithDeepCloning implements Cloneable {
	
	private String creditCardNumber;
	private List<Product> products;
	private int customerId;
	
	public OrderWithDeepCloning() {
	}

	public OrderWithDeepCloning(String creditCardNumber, List<Product> products, int customerId) {
		this.creditCardNumber = creditCardNumber;
		this.products = products;
		this.customerId = customerId;
	}
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "Order [creditCardNumber=" + creditCardNumber + ", products=" + products + ", customerId=" + customerId
				+ "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		OrderWithDeepCloning clonedOrder = (OrderWithDeepCloning) super.clone();
		
		// deep cloning of mutable fields
		List<Product> productsCopy = new ArrayList<>(this.products);
		clonedOrder.setProducts(productsCopy);
		
		return clonedOrder;
	}
	
}
