package com.itbulls.learnit.javacore.oop.polymorphism;

public class AdminUser extends User {

	@Override
	public void validateAccessRights() {
		System.out.println("I'm an admin user. I can do whatever I want in the system.");
	}

}
