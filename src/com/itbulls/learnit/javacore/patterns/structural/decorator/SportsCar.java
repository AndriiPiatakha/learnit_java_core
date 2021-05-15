package com.itbulls.learnit.javacore.patterns.structural.decorator;

public class SportsCar extends CarDecorator {

	private String transmissionMode;
	
	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public void drive() {
		super.drive();
		System.out.print(" And drives fast like a Sports Car");
	}
	
	public void setTransmissionMode(String transmissionMode) {
		this.transmissionMode = transmissionMode;
	}
}