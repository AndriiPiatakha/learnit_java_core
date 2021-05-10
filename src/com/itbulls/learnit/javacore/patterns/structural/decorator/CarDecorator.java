package com.itbulls.learnit.javacore.patterns.structural.decorator;

public class CarDecorator implements Car {

	private Car car;

	public CarDecorator(Car car) {
		this.car = car;
	}

	@Override
	public void drive() {
		this.car.drive();
	}

}
