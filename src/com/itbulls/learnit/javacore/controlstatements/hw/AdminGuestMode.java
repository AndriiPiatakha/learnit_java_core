package com.itbulls.learnit.javacore.controlstatements.hw;

public class AdminGuestMode {
	
	public static void main(String[] args) {
		String inputArguments = String.join(",", args);
		String adminFlag = "--admin";
		String guestFlag = "--guest";
		if (inputArguments.contains(adminFlag) && inputArguments.contains(guestFlag)) {
			System.out.println("Please, select either 'ADMIN' or "
					+ "'GUEST' mode for this program");
		} else if (inputArguments.contains(adminFlag)) {
			System.out.println("Hello, Admin!");
		} else if (inputArguments.contains(guestFlag)) {
			System.out.println("Hello, Guest!");
		}
		
	}

}
