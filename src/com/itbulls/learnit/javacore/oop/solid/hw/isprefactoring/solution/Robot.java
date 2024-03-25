package com.itbulls.learnit.javacore.oop.solid.hw.isprefactoring.solution;

//Class implementing relevant interface
public class Robot implements Workable {
	@Override
	public void work() {
		System.out.println("Robot is working");
	}
}
