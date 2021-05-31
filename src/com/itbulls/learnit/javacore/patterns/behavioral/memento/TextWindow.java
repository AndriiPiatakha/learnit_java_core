package com.itbulls.learnit.javacore.patterns.behavioral.memento;

// Originator class
public class TextWindow {
	private StringBuilder textInWindow = new StringBuilder();

	public void write(String text) {
		this.textInWindow.append(text);
	}

	public TextWindowState save() {
		return new TextWindowState(textInWindow.toString());
	}

	public void restore(TextWindowState memento) {
		textInWindow = new StringBuilder(memento.getState());
	}
	
	public void print() {
		System.out.println(textInWindow);
	}
}
