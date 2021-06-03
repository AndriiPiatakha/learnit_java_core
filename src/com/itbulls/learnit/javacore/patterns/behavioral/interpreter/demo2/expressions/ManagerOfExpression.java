package com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2.expressions;

import java.util.stream.Collectors;

import com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2.Employee;
import com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2.Manager;

public class ManagerOfExpression extends TerminalExpression {

	protected String name;

	public ManagerOfExpression(String name) {
		this.name = name;
	}

	@Override
	public boolean interpret(Employee context) {
		if (context.isManager()) {
			Manager manager = (Manager) context;
			return manager.getManagingEmployees().stream()
					.map(managingEmployee -> managingEmployee.getEmployeeName().toLowerCase())
					.collect(Collectors.toList()).contains(name.toLowerCase());
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManagerOfExpression [name=").append(name).append("]");
		return builder.toString();
	}

}
