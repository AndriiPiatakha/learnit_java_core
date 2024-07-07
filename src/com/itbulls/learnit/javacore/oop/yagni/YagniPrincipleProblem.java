package com.itbulls.learnit.javacore.oop.yagni;

import java.util.ArrayList;
import java.util.List;

// Messaging App class - Problem Statement
public class YagniPrincipleProblem {
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

	// Additional functionalities anticipated but not currently needed
	public void archiveMessage(String message) {
		// Logic to archive messages
		System.out.println("Archiving message: " + message);
	}

	public void deleteMessage(String message) {
		// Logic to delete messages
		System.out.println("Deleting message: " + message);
	}

	public void forwardMessage(String message, String recipient) {
		// Logic to forward messages
		System.out.println("Forwarding message: " + message + " to " + recipient);
	}
}
