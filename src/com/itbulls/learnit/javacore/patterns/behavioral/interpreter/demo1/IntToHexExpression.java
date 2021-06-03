package com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo1;

public class IntToHexExpression implements Expression {

	private int i;

	public IntToHexExpression(int c) {
		this.i = c;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getHexadecimalFormat(i);
	}

}
