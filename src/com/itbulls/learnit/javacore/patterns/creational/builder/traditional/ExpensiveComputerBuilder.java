package com.itbulls.learnit.javacore.patterns.creational.builder.traditional;

public class ExpensiveComputerBuilder extends ComputerBuilder {

	@Override
	public void buildSystemBlock() {
		computer.setSystemBlock("Vinga Odin");
	}

	@Override
	public void buildDisplay() {
		computer.setDisplay("IPS");
	}

	@Override
	public void buildManipulators() {
		computer.setManipulators("mouse+keyboard+second_monitor");
	}

}
