package com.itbulls.learnit.javacore.oop.solid.l.problem;

public class Ostrich implements Bird {
	
	@Override
	public void fly() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void eat() {
		System.out.println("Ostrich eats");
	}
}
