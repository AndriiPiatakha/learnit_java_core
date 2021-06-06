package com.itbulls.learnit.javacore.patterns.behavioral.mediator;

public class Tv {
    private Mediator mediator;
    private boolean isOn;

    public Tv(Mediator mediator) {
    	this.mediator = mediator;
	}

	public void turnOn() {
        mediator.start();
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
        mediator.stop();
    }
    
    public boolean isOn() {
    	return this.isOn;
    }
}
