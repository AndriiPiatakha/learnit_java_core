package com.itbulls.learnit.javacore.oop.datastructures;

public class Motorcycle implements Vehicle {

	@Override
	public void drive() {
		System.out.println("Motorcycle drives");
	}

	@Override
	public void startEngine() {
		System.out.println("Engine is started");		
	}

}



