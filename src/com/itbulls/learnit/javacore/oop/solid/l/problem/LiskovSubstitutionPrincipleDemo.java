package com.itbulls.learnit.javacore.oop.solid.l.problem;

public class LiskovSubstitutionPrincipleDemo {

	public static void main(String[] args) {
		Bird[] birds = new Bird[] { new Crow(), new Sparrow(), new Ostrich() };
		for (Bird bird : birds) {
			bird.fly();
		}
	}

}
