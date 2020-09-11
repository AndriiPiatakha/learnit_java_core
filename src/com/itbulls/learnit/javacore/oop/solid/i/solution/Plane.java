package com.itbulls.learnit.javacore.oop.solid.i.solution;

public class Plane implements Drivable, Flyable {

	@Override
	public void drive() {
		System.out.println("Plane drives");
	}

	@Override
	public void fly() {
		System.out.println("Plane flies");
	}

}
