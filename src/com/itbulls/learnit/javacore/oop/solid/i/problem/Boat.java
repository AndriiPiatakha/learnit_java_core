package com.itbulls.learnit.javacore.oop.solid.i.problem;

public class Boat implements Vehicle {

	@Override
	public void drive() {
		throw new UnsupportedOperationException();

	}

	@Override
	public void fly() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sail() {
		System.out.println("Boat sails");
	}

}
