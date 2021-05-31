package com.itbulls.learnit.javacore.patterns.behavioral.memento;


public class Demo {
	
	public static void main(String[] args) {
		TextEditor textEditor = new TextEditor();
		TextWindow textWindow = new TextWindow();
		textWindow.write("This is the lesson about memento pattern" + System.lineSeparator());
		textWindow.write("Memento is a behavioral GoF pattern." + System.lineSeparator());
		textEditor.save(textWindow.save());
		textWindow.write("This is example of memento pattern implementation by Andrii Piatakha");
		textEditor.save(textWindow.save());
		
		textWindow.print();
		System.out.println("===============================");
		textWindow.restore(textEditor.getStateBySnapshotIndex(0));
		
		textWindow.print();
		System.out.println("===============================");
		textWindow.restore(textEditor.getStateBySnapshotIndex(1));
		
		textWindow.print();
	}
	
}
