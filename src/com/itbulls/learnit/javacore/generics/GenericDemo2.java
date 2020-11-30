package com.itbulls.learnit.javacore.generics;

import java.util.Comparator;

public class GenericDemo2 {
	
	public static void main(String args[]) {
		System.out.printf("Max of %d, %d and %d is %d\n\n", 1, 2, 3, 
				maxValue(1, 2, 3));

		System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 
				1.1, 2.2, 3.3, maxValue(1.1, 2.2, 3.3));

		System.out.printf("Max of %s, %s and %s is %s\n", "Audi", 
				"Acura", "Aston Martin", maxValue("Audi", "Acura", "Aston Martin"));
	}
	
	// Example of multiple bounds
//	public static <T extends Comparable<T> & Comparator<T>> T maxValue(T x, T y, T z) {
	
	public static <T extends Comparable<T>> T maxValue(T x, T y, T z) {
		T max = x; // assume x is initially the largest

		if (y.compareTo(max) > 0) {
			max = y; // y is the largest so far
		}

		if (z.compareTo(max) > 0) {
			max = z; // z is the largest now
		}
		return max; // returns the largest object
	}
	
}
