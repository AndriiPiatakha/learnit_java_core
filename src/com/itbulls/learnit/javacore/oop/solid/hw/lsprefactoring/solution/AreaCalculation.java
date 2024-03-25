package com.itbulls.learnit.javacore.oop.solid.hw.lsprefactoring.solution;

public class AreaCalculation {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(5, 4);
		System.out.println("Area: " + rectangle.calculateArea());

		Square square = new Square(5);
		System.out.println("Area: " + square.calculateArea());
	}
}
