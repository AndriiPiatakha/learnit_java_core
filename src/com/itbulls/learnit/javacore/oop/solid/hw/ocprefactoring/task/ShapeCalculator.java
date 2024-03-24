package com.itbulls.learnit.javacore.oop.solid.hw.ocprefactoring.task;

import java.util.List;

/*

In this file you can find violation of Open / Closed Principle. 
You should refactor this file. 
You can remove this file completely, because it will not be used during the evaluation of the solution.

Exercise Title: Open/Closed Principle (OCP) Refactoring Challenge

Objective: In this exercise, you will practice applying the Open/Closed Principle (OCP) to refactor a given codebase. OCP states that software entities should be open for extension but closed for modification. You will enhance the codebase's flexibility and maintainability by allowing it to be easily extended with new functionalities without modifying existing code.

Instructions:

Review the Provided Code: Start by examining the original code provided. Identify areas where the code violates the Open/Closed Principle by requiring modification to add new functionalities.

Identify Extension Points: Analyze the code to identify areas where future enhancements or modifications may be needed. Look for behaviors or functionalities that are likely to change or be extended in the future.

Refactor the Code: Refactor the code to introduce abstraction and encapsulation, allowing for easy extension without modifying existing code. Use techniques such as inheritance, composition, or dependency injection to achieve this.

Implement Extensions: Create new classes or modules to implement additional functionalities or behaviors. Ensure that these extensions can be added without modifying existing code, adhering to the OCP.

Note: Focus on designing flexible and extensible solutions that allow for easy maintenance and future enhancements. Consider best practices, namely, input validation. Consider cases with Null value objects. Do not forget to put all required null-checks in your solution. 

The source code of my solution of this coding exercise is here - https://github.com/AndriiPiatakha/learnit_java_core/tree/master/src/com/itbulls/learnit/javacore/oop/solid/hw/ocprefactoring

*/

public class ShapeCalculator {
	public double calculateTotalArea(List<Shape> shapes) {
		double totalArea = 0;
		for (Shape shape : shapes) {
			if (shape instanceof Circle) {
				Circle circle = (Circle) shape;
				totalArea += Math.PI * Math.pow(circle.getRadius(), 2);
			} else if (shape instanceof Rectangle) {
				Rectangle rectangle = (Rectangle) shape;
				totalArea += rectangle.getWidth() * rectangle.getHeight();
			}
			// Add more conditions for other shapes (e.g., Triangle)
		}
		return totalArea;
	}
}

class Shape {
	// Common properties and methods for all shapes
}

class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
}

class Rectangle extends Shape {
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
}
