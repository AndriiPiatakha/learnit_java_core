package com.itbulls.learnit.javacore.controlstatements.hw;

public class AdminGuestMode {
	
	public static final String ADMIN_MODE = "--admin";
	public static final String GUEST_MODE = "--guest";
	
	public static void main(String[] args) {
		String inputArguments = String.join(",", args);
		if (inputArguments.contains(ADMIN_MODE) && inputArguments.contains(GUEST_MODE)) {
			System.out.println("Please, select either 'ADMIN' or "
					+ "'GUEST' mode for this program");
		} else if (inputArguments.contains(ADMIN_MODE)) {
			System.out.println("Hello, Admin!");
		} else if (inputArguments.contains(GUEST_MODE)) {
			System.out.println("Hello, Guest!");
		}
		
	}

}
