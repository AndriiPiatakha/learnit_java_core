package com.itbulls.learnit.javacore.oop.datastructures;

public class PetrolCar implements Vehicle {

	@Override
	public void drive() {
		System.out.println("Petrol car drives");
	}

	@Override
	public void startEngine() {
		System.out.println("Engine is started");		
	}

}


