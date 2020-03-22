package com.itbulls.learnit.javacore.operations.hw;

import java.util.Scanner;

public class AreaOfTriangle {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("This program will calculate area of triangle.");
		System.out.print("Please, enter A side of a triangle: ");
		double aSide = sc.nextDouble();
		
		System.out.print("Please, enter B side of a triangle: ");
		double bSide = sc.nextDouble();
		
		System.out.print("Please, enter C side of a triangle: ");
		double cSide = sc.nextDouble();
		
		double p = (aSide + bSide + cSide) / 2;
		double triangleArea = Math.sqrt(p * (p - aSide) 
				* (p - bSide) * (p - cSide));
		
		System.out.println("Triangle area is: " + triangleArea);
	}

}
