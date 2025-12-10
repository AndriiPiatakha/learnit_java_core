package com.itbulls.learnit.javacore.oop.grasp.infoexpert.problem.example2;

import java.util.List;

//Misused Data Class: DTO that was supposed to just carry data,
//but now contains domain logic and rules.

public class OrderDto {

	private List<OrderLineDto> lines;
	private String customerId;
	private String status;

	public List<OrderLineDto> getLines() {
		return lines;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getStatus() {
		return status;
	}

	// BAD: DTO starts to contain business logic
	public double calculateTotalPrice() {
		double total = 0.0;

		for (OrderLineDto line : lines) {
			total += line.getUnitPrice() * line.getQuantity();
		}

		if ("VIP".equals(customerId)) {
			total *= 0.9; // 10% discount for VIP
		}

		return total;
	}

	// BAD: more domain logic inside a data transfer object
	public boolean isCancelable() {
		return !"SHIPPED".equals(status) && !"DELIVERED".equals(status);
	}
}
