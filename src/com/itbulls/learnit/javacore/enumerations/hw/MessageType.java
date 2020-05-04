package com.itbulls.learnit.javacore.enumerations.hw;

public enum MessageType {

	A(Priority.HIGH), B(Priority.MEDIUM), C(Priority.LOW), D(Priority.LOW);
	
	private Priority priority;
	
	private MessageType(Priority priority) {
		this.priority = priority;
	}
	
	public Priority getPriority() {
		return this.priority;
	}
	
}
