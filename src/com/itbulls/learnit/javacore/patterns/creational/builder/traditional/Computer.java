package com.itbulls.learnit.javacore.patterns.creational.builder.traditional;

public class Computer {
	private String display = null;
	private String systemBlock = null;
	private String manipulators = null;

	public void setDisplay(final String display) {
		this.display = display;
	}

	public void setSystemBlock(final String systemBlock) {
		this.systemBlock = systemBlock;
	}

	public void setManipulators(final String manipulators) {
		this.manipulators = manipulators;
	}

	@Override
	public String toString() {
		return "Computer [display=" + display + ", systemBlock=" + systemBlock + ", manipulators=" + manipulators + "]";
	}
}


