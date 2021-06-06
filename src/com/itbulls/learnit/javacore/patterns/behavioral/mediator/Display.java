package com.itbulls.learnit.javacore.patterns.behavioral.mediator;

public class Display {
	
	private Mediator mediator;
	
    public Display(Mediator mediator) {
    	this.mediator = mediator;
    }

	public void turnOn() {
        System.out.println("Display is turned on");
    }

    public void turnOff() {
    	System.out.println("Display is turned off");
    }
}
