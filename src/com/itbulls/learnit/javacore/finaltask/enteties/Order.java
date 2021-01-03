package com.itbulls.learnit.javacore.finaltask.enteties;

import java.util.List;

public interface Order {

	boolean isCreditCardNumberValid(String userInput);

	void setCreditCardNumber(String userInput);

	void setProducts(List<Product> products);

	void setCustomerId(int customerId);
	
	int getCustomerId();

}
