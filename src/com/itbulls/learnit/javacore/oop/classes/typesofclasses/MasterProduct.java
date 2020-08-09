package com.itbulls.learnit.javacore.oop.classes.typesofclasses;

public class MasterProduct extends Product {

	private boolean isAvailableForLease;

	@Override
	public boolean isAvailableInStock() {
		return getRemainingAmountInStock() > 0;
	}
}
