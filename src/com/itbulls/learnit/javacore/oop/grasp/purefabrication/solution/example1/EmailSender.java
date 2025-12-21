package com.itbulls.learnit.javacore.oop.grasp.purefabrication.solution.example1;

//Pure Fabrication: sending email does not belong to Order entity
public class EmailSender {

	public void send(String to, String subject, String body) {
		System.out.println("EMAIL to " + to + " | " + subject + " | " + body);
	}
}
