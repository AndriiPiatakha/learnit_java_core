package com.itbulls.learnit.javacore.patterns.behavioral.memento;

// Memento class
public class TextWindowState {
	private String state;

	public TextWindowState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
