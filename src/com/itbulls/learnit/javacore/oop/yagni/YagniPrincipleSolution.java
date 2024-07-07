package com.itbulls.learnit.javacore.oop.yagni;

import java.util.ArrayList;
import java.util.List;

// Messaging App class - Solution
public class YagniPrincipleSolution {
	private List<String> messages = new ArrayList<>();

	// Basic messaging functionalities
	public void sendMessage(String message) {
		messages.add(message);
		System.out.println("Message sent: " + message);
	}

	public void receiveMessage() {
		if (!messages.isEmpty()) {
			String message = messages.remove(0);
			System.out.println("Message received: " + message);
		} else {
			System.out.println("No messages to receive.");
		}
	}
}
