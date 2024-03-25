package com.itbulls.learnit.javacore.oop.solid.hw.lsprefactoring.task;

/*

In this file you can find violation of Liskov Substitution Principle. 
You should refactor this file. 
You can remove this file completely, because it will not be used during the evaluation of the solution.

Objective: Understand and apply the Liskov Substitution Principle (LSP) in Java programming.

Task:

You are provided with an initial Java code that violates the Liskov Substitution Principle.

Identify the violation in the code and refactor it to adhere to the LSP.

Steps: 

Study the provided code carefully, paying attention to the inheritance hierarchy and method overrides.

Identify how the Square class violates the LSP when inheriting from the Rectangle class.

Refactor the code to create a solution where both Rectangle and Square are substitutable for a common superclass Shape. 

Ensure that the refactored code maintains functionality while adhering to the LSP.

Note: During the implementation consider best practices. Namely, make input validations. In case negative value or equal to zero value is passed for one of the sides of the shape - then you need to throw IllegalArgumentException.  
 
The source code of my solution is located here - https://github.com/AndriiPiatakha/learnit_java_core/tree/master/src/com/itbulls/learnit/javacore/oop/solid/hw/lsprefactoring
 
 */

public class AreaCalculation {
    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setWidth(5);
        rectangle.setHeight(4);
        System.out.println("Area: " + rectangle.calculateArea());
    }
}

class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}
