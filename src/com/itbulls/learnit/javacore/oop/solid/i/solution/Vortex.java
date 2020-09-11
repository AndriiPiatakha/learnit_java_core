package com.itbulls.learnit.javacore.oop.solid.i.solution;

public class Vortex implements Drivable, Sailable {

	@Override
	public void sail() {
		System.out.println("Vortex sailes");
	}

	@Override
	public void drive() {
		System.out.println("Vortex drives");
	}

}
