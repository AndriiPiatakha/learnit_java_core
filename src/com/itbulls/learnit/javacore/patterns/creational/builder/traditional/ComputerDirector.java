package com.itbulls.learnit.javacore.patterns.creational.builder.traditional;

public class ComputerDirector {
	private ComputerBuilder computerBuilder;

	public ComputerDirector(ComputerBuilder computerBuilder) {
		this.computerBuilder = computerBuilder;
	}

	public Computer getComputer() {
		return computerBuilder.getComputer();
	}

	public void buildComputer() {
		computerBuilder.createNewComputer();
		computerBuilder.buildSystemBlock();
		computerBuilder.buildDisplay();
		computerBuilder.buildManipulators();
	}

	public void setComputerBuilder(ComputerBuilder computerBuilder) {
		this.computerBuilder = computerBuilder;
	}
}
