package com.itbulls.learnit.javacore.oop.solid.hw.lsprefactoring.solution;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AreaCalculationTest {
	@Test
    public void testRectangleAreaCalculation() {
        Rectangle rectangle = new Rectangle(5, 4);
        assertEquals(20, rectangle.calculateArea());
    }

    @Test
    public void testSquareAreaCalculation() {
        Square square = new Square(5);
        assertEquals(25, square.calculateArea());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeRectangleWidth() {
        Rectangle rectangle = new Rectangle(-5, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSquareSide() {
        Square square = new Square(-5);
    }
}
