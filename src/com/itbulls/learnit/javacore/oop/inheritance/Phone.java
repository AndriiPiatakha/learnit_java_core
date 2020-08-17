package com.itbulls.learnit.javacore.oop.inheritance;

public class Phone extends Product {
	
	// Default constructor
	public Phone() {
		super("Nokia");
		System.out.println("Some code");
	}
	
	public void ring() {
		System.out.println("Ring!");
	}
	
	@Override
	public Product[] listVariants() {
		throw new UnsupportedOperationException();
	}
	
	public int calculateAmountOfVariants() {
		return super.listVariants().length;
	}

}
