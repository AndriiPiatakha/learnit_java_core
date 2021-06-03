package com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2.expressions;

import com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2.Employee;

public class NameExpression extends TerminalExpression {

	protected String name;

	public NameExpression(String name) {
		this.name = name;
	}

	@Override
	public boolean interpret(Employee context) {
		return context.getEmployeeName().equalsIgnoreCase(name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NameExpression [name=").append(name).append("]");
		return builder.toString();
	}

}
