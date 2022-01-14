package com.itbulls.learnit.javacore.exam.solution.menu.impl;

import java.util.ResourceBundle;
import java.util.Scanner;

import com.itbulls.learnit.javacore.exam.solution.configs.ApplicationContext;
import com.itbulls.learnit.javacore.exam.solution.menu.Menu;

public class ChangePasswordMenu implements Menu {
	
	private ApplicationContext context;
	private ResourceBundle rb;
	
	{
		context = ApplicationContext.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
		
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		context.getLoggedInUser().setPassword(userInput);
		System.out.println(rb.getString("change.password.msg"));
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(rb.getString("change.password.header"));
		System.out.print(rb.getString("enter.new.pass.cta"));		
	}

}
