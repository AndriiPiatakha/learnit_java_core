package com.itbulls.learnit.javacore.oop.solid.hw.ocprefactoring.solution;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ShapeCalculatorTest {

	@Test
	public void shouldCalculateTotalAreaForPositiveScenario() {
		// Create a list of shapes
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle(5.0));
		shapes.add(new Rectangle(4.0, 3.0));

		// Calculate total area
		ShapeCalculator calculator = new ShapeCalculator();
		double totalArea = calculator.calculateTotalArea(shapes);

		// Assert total area is correct
		assertEquals(90.53981633974483, totalArea, 0.001); // Corrected expected value
	}

	@Test
	public void shouldCalculateTotalAreaForEmptyList() {
		// Create an empty list of shapes
		List<Shape> shapes = new ArrayList<>();

		// Calculate total area
		ShapeCalculator calculator = new ShapeCalculator();
		double totalArea = calculator.calculateTotalArea(shapes);

		// Assert total area is zero for an empty list
		assertEquals(0.0, totalArea, 0.0);
	}

	@Test
	public void shouldCalculateTotalAreaForNegativeScenario() {
		// Create a list of shapes with null value (invalid scenario)
		List<Shape> shapes = new ArrayList<>();
		shapes.add(null);

		// Calculate total area
		ShapeCalculator calculator = new ShapeCalculator();
		double totalArea = calculator.calculateTotalArea(shapes);

		// Assert total area is zero (since null value is ignored)
		assertEquals(0.0, totalArea, 0.0);
	}

}
