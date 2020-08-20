package com.itbulls.learnit.javacore.oop.polymorphism;

public abstract class User {
	
	private int id;
	public String name;
	
	public void validateAccessRights() {
		System.out.println("I'm an abstract user. I don't have any specific rights.");
	};
	
	public abstract ProfileInformationData getProfileInformtaion(Profile profile);
	
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
