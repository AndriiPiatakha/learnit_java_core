package com.itbulls.learnit.javacore.oop.encapsulation.package2;

public class Demo {
	
	public static void main(String[] args) {
		ClassB classB = new ClassB();
		classB.doSomethingClassB(); 		// package private demo
		
//		classB.doSomethingClassBPrivate();	// private modifier demo
	}

}
