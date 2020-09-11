package com.itbulls.learnit.javacore.oop.solid.i.problem;

public class Plane implements Vehicle {

	@Override
	public void drive() {
		System.out.println("Plane drives");
	}

	@Override
	public void fly() {
		System.out.println("Plane flies");
	}

	@Override
	public void sail() {
		throw new UnsupportedOperationException();
	}

}
