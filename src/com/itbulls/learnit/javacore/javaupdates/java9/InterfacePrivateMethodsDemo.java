package com.itbulls.learnit.javacore.javaupdates.java9;

public class InterfacePrivateMethodsDemo {
	public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        // Using public methods
        System.out.println("Addition: " + calculator.add(5, 3));
        System.out.println("Subtraction: " + calculator.subtract(5, 3));
        System.out.println("Multiplication: " + calculator.multiply(5, 3));
    }
}

interface Calculator {
    // Public method
    int add(int a, int b);

    @Deprecated(since = "2.0", forRemoval = true)
    // Another public method
    int subtract(int a, int b);

    // Default method using private helper method
    default int multiply(int a, int b) {
        return multiplyHelper(a, b);
    }

    // Private helper method
    private int multiplyHelper(int a, int b) {
        return a * b;
    }
}

class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    
}

