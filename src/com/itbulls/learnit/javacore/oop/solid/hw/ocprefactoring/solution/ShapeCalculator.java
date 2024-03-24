package com.itbulls.learnit.javacore.oop.solid.hw.ocprefactoring.solution;

import java.util.List;

public class ShapeCalculator {
	public double calculateTotalArea(List<Shape> shapes) {
		double totalArea = 0;
		if (shapes == null || shapes.size() == 0) {
			return totalArea;
		}
		for (Shape shape : shapes) {
			if (shape != null) {
				totalArea += shape.calculateArea();
			}
		}
		return totalArea;
	}
}
