package com.itbulls.learnit.javacore.oop.staticdemo;

public class User {

	public static final String DEFAULT_USER_GROUP = "customers";
	
	private static int counter;
	
	private int id;
	private String name;
	
	{
		++counter;
//		DEFAULT_USER_GROUP = "employees";
	}

	public static void doAnyStaticAction() {
		System.out.println("Static method in User class is called.");
	}
	
	public int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		User.counter = counter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
