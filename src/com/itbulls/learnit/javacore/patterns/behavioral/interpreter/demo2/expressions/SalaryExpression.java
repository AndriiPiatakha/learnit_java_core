package com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2.expressions;

import com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2.Employee;

public class SalaryExpression extends TerminalExpression {

	protected String salary;

	public SalaryExpression(String salary) {
		super();
		this.salary = salary;
	}

	@Override
	public boolean interpret(Employee context) {
		if (!Character.isDigit(salary.charAt(0))) {
			char operator = salary.charAt(0);
			return interpretIntSalary(context, salary.substring(1), operator);
		} else {
			return interpretIntSalary(context, salary, '=');
		}
	}

	private boolean interpretIntSalary(Employee context, String salary, char operator) {
		try {
			int intSalary = Integer.parseInt(salary);
			switch (operator) {
			case '>':
				return context.getSalary() > intSalary;
			case '<':
				return context.getSalary() < intSalary;
			case '+':
			case '-':
			default:
				return context.getSalary() == intSalary;
			}
		} catch (NumberFormatException exp) {
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaryExpression [salary=").append(salary).append("]");
		return builder.toString();
	}

}
