package com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2;

import com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2.expressions.Expression;
import com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2.expressions.ExpressionParser;

public class Demo {

	public static void main(String[] args) {
		Engineer artem = new Engineer(1001l, "Artem", "Developer", Department.ENG, 75000);
		Engineer vitalii = new Engineer(1002l, "Vitalii", "Sr. Developer", Department.ENG, 90000);
		Engineer eugenii = new Engineer(1003l, "Eugenii", "Lead", Department.ENG, 100000);
		Engineer david = new Engineer(1004l, "David", "QA", Department.ENG, 70000);
		Manager andrey = new Manager(1005l, "Andrey", "Manager", Department.ENG, 110000);
		Engineer aleksey = new Engineer(1006l, "Aleksey", "Developer", Department.ENG, 95000);
		Manager yaroslav = new Manager(1007l, "Yaroslav", "Sr. Manager", Department.ENG, 140000);
		Engineer egor = new Engineer(1008l, "Egor", "Developer", Department.ENG, 85000);
		Manager maxim = new Manager(1009l, "Maxim", "Product Manager", Department.ENG, 150000);
		Engineer sveta = new Engineer(1010l, "Sveta", "Engineer", Department.ENG, 80000);

		andrey.manages(artem);
		andrey.manages(david);
		andrey.manages(vitalii);

		yaroslav.manages(eugenii);
		yaroslav.manages(aleksey);
		yaroslav.manages(sveta);

		maxim.manages(andrey);
		maxim.manages(egor);
		maxim.manages(yaroslav);

		String contextString = "Desig:manager, Deptt:eng, Manages:artem, salary:110000";
		Expression expression = ExpressionParser.parseExpression(contextString);
		System.out.println("contextString = " + contextString);
		System.out.println();
		System.out.println(andrey);
		System.out.printf("For '%s', %s: %s.\n", andrey.getEmployeeName(), expression, expression.interpret(andrey));

		System.out.println("=======================================================================\n");
		contextString = "Desig:developer, Deptt:eng, salary:<85000";
		expression = ExpressionParser.parseExpression(contextString);
		System.out.println("contextString = " + contextString);
		System.out.println();
		System.out.println(artem);
		System.out.printf("For '%s', %s: %s.\n", artem.getEmployeeName(), expression, expression.interpret(artem));
		System.out.println();
		System.out.println(aleksey);
		System.out.printf("For '%s', %s: %s.\n", aleksey.getEmployeeName(), expression,
				expression.interpret(aleksey));
	}

}
