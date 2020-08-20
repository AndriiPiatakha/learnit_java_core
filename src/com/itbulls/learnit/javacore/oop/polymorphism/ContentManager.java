package com.itbulls.learnit.javacore.oop.polymorphism;

public class ContentManager extends User {

	@Override
	public void validateAccessRights() {
		System.out.println("I'm a content manager. I have no enough rights to withdraw money.");
	}

	@Override
	public ProfileInformationData getProfileInformtaion(Profile profile) {
		return new AccountInformation();
	}

}
