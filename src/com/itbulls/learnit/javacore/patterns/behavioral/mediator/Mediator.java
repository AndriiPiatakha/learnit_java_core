package com.itbulls.learnit.javacore.patterns.behavioral.mediator;

public class Mediator {
    private Tv tv;
    private Display display;
    
    public void press() {
        if (tv.isOn()) {
            tv.turnOff();
        } else {
            tv.turnOn();
        }
    }

    public void start() {
        display.turnOn();
    }

    public void stop() {
        display.turnOff();
    }


	public void setTv(Tv tv) {
		this.tv = tv;
	}

	public void setPowerDisplay(Display display) {
		this.display = display;
	}
}