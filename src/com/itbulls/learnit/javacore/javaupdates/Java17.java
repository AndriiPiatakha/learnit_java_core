package com.itbulls.learnit.javacore.javaupdates;

import java.io.Serializable;

public class Java17 {
	
	public static void main(String[] args) {
		System.out.println("Demo of Sealed Classes");
	}

}


sealed interface Area permits Circle {}
//sealed class Shape extends Java17 implements Serializable permits Circle, Square, Triangle, CustomShape {}
sealed class Shape permits Circle, Square, Triangle, CustomShape { 
	
}

final class Circle extends Shape implements Area {};
non-sealed class Square extends Shape {};
sealed class Triangle extends Shape permits IsoscelesTriangle {};
final class IsoscelesTriangle extends Triangle {}
final class CustomShape extends Shape {};

// can't extend Shape because for type CustomShape2 it is not permitted
//final class CustomShape2 extends Shape {};
