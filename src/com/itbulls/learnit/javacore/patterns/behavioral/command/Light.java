package com.itbulls.learnit.javacore.patterns.behavioral.command;

//Receiver

public class Light {

	private boolean isOn;

	public void switchOn() {
		isOn = true;
	}

	public void switchOff() {
		isOn = false;
	}

}
