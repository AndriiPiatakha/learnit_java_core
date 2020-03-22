package com.itbulls.learnit.javacore.operations.hw;

import java.util.Scanner;

public class CircleCircumference {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("This program will calculate circle circumference.");
		System.out.print("Please, enter circle radius: ");
		double radius = sc.nextDouble();
		
		double circleCircumference = 2 * Math.PI * radius;
		
		System.out.println("Circle circumference is: " + circleCircumference);
	}

}
