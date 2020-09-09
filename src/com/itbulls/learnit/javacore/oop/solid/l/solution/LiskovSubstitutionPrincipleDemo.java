package com.itbulls.learnit.javacore.oop.solid.l.solution;


public class LiskovSubstitutionPrincipleDemo {

	public static void main(String[] args) {
		FlyingBird[] flyingBirds = new FlyingBird[] { new Crow(), new Sparrow() };
		for (FlyingBird bird : flyingBirds) {
			bird.fly();
		}
		
		System.out.println("\n===========\n");
		
		Bird[] birds = new Bird[] { new Crow(), new Sparrow(), new Ostrich() };
		for (Bird bird : birds) {
			bird.eat();
		}
	}

}
