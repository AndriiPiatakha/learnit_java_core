package com.itbulls.learnit.javacore.oop.grasp.infoexpert.problem.example1;

import java.util.List;

//Fake Expert: this class pretends to be an "expert",
//but it only exists to hold logic that really belongs to domain objects.

public class OrderCalculator {

	public double calculateTotal(Order order) {
		double total = 0.0;

		for (OrderLine line : order.getLines()) {
			// This class "knows" too much about discounts and pricing rules
			double price = line.getProduct().getPrice();
			int quantity = line.getQuantity();
			double discount = 0.0;

			if (quantity > 10) {
				discount = 0.1; // 10% discount
			}

			total += price * quantity * (1 - discount);
		}

		// Also knows about shipping rules - more fake "expertise"
		if (total < 50) {
			total += 5.99; // shipping fee
		}

		return total;
	}
}

