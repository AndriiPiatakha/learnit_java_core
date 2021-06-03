package com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2.expressions;

public class ExpressionParser {

	protected static final String NAME = "name";
	protected static final String DESIG = "desig";
	protected static final String DEPTT = "deptt";
	protected static final String MANAGES = "manages";
	protected static final String SALARY = "salary";

	public static Expression parseExpression(String contextString) {
		Expression expression = null;
		String[] keyValues = contextString.split(",");
		for (int index = 0; index < keyValues.length; index++) {
			String keyValue = keyValues[index];
			String[] words = keyValue.trim().split(":");
			Expression anotherExpression = getExpression(words[0].trim(), words[1].trim());
			if (expression == null) {
				expression = anotherExpression;
			} else {
				expression = new AndExpression(expression, anotherExpression);
			}
		}
		return expression;
	}

	public static Expression getExpression(String keyword, String value) {
		if (NAME.equalsIgnoreCase(keyword)) {
			return new NameExpression(value);
		} else if (DESIG.equalsIgnoreCase(keyword)) {
			return new DesignationExpression(value);
		} else if (DEPTT.equalsIgnoreCase(keyword)) {
			return new DepartmentExpression(value);
		} else if (MANAGES.equalsIgnoreCase(keyword)) {
			return new ManagerOfExpression(value);
		} else if (SALARY.equalsIgnoreCase(keyword)) {
			return new SalaryExpression(value);
		}
		return null;
	}

}
