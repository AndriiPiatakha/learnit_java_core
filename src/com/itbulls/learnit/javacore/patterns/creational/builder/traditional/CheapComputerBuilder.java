package com.itbulls.learnit.javacore.patterns.creational.builder.traditional;

public class CheapComputerBuilder extends ComputerBuilder {
	@Override
	public void buildSystemBlock() {
		computer.setSystemBlock("Everest");
	}

	@Override
	public void buildDisplay() {
		computer.setDisplay("CRT");
	}

	@Override
	public void buildManipulators() {
		computer.setManipulators("mouse+keyboard");
	}
}
