package com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2;

public class Engineer extends Employee {

	public Engineer(long employeeId, String employeeName, String designation, Department department, int salary) {
		super(employeeId, employeeName, designation, department, salary);
	}

	@Override
	public int teamSize() {
		return 1;
	}

	@Override
	public boolean isManager() {
		return false;
	}

	@Override
	public String teamNames() {
		return "{NA}";
	}

}