package com.itbulls.learnit.javacore.patterns.behavioral.memento;

import java.util.ArrayList;

//Caretaker
public class TextEditor {
	private ArrayList<TextWindowState> mementos = new ArrayList<>();

	public void save(TextWindowState memento) {
		mementos.add(memento);
	}

	public TextWindowState getStateBySnapshotIndex(int indexOfSnapshot) {
		return mementos.get(indexOfSnapshot);
	}
}
