package com.itbulls.learnit.javacore.oop.solid.i.problem;

public class InterfaceSegregationPrincipleDemo {
	
	public static void main(String[] args) {
		Vehicle car = new Car();
		Vehicle plane = new Plane();
		Vehicle boat = new Boat();
		
		car.drive();
		plane.fly();
		boat.sail();
	}

}
