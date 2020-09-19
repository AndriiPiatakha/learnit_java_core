package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.impl;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Order;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Product;

public class DefaultOrder implements Order {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;
	
	private String creditCardNumber;
	private Product[] products;
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		// <write your code here>
		return false;
	}

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		// <write your code here>
	}

	@Override
	public void setProducts(Product[] products) {
		// <write your code here>
	}

	@Override
	public void setCustomerId(int customerId) {
		// <write your code here>
	}


	@Override
	public int getCustomerId() {
		return this.customerId;
	}
	
	@Override
	public String toString() {
		// <write your code here>
		return null;
	}

	
	
	

}
