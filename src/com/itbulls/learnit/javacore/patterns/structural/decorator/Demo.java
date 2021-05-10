package com.itbulls.learnit.javacore.patterns.structural.decorator;

public class Demo {
	public static void main(final String[] args) {
		Car basicCar = new BasicCar();
		basicCar.drive();
		System.out.println("\n*****");
		
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.drive();
		System.out.println("\n*****");

		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.drive();
		System.out.println("\n*****");
		
		
	}
}
