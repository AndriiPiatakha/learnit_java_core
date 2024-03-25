package com.itbulls.learnit.javacore.oop.solid.hw.lsprefactoring.solution;

public class Rectangle extends Shape {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
    	if (width <= 0 || height <= 0) {
    		throw new IllegalArgumentException();
    	}
        this.width = width;
        this.height = height;
    }

    @Override
    public int calculateArea() {
        return width * height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
