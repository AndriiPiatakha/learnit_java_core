package com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo1;

public class IntToBinaryExpression implements Expression {

	private int i;

	public IntToBinaryExpression(int c) {
		this.i = c;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getBinaryFormat(this.i);
	}

}
