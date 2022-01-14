package com.itbulls.learnit.javacore.exam.solution.menu.impl;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

import com.itbulls.learnit.javacore.exam.solution.configs.ApplicationContext;
import com.itbulls.learnit.javacore.exam.solution.menu.Menu;
import com.itbulls.learnit.javacore.exam.solution.services.ResetPasswordService;
import com.itbulls.learnit.javacore.exam.solution.services.UserManagementService;
import com.itbulls.learnit.javacore.exam.solution.services.impl.DefaultResetPasswordService;
import com.itbulls.learnit.javacore.exam.solution.services.impl.DefaultUserManagementService;
import com.itbulls.learnit.javacore.exam.solution.enteties.User;

public class ResetPasswordMenu implements Menu {
	
	private ResetPasswordService resetPasswordService;
	private UserManagementService userManagementService;
	private ResourceBundle rb;

	{
		resetPasswordService = new DefaultResetPasswordService();
		userManagementService = DefaultUserManagementService.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		System.out.println(rb.getString("pass.sent.to.email"));
		CompletableFuture.runAsync(() -> {
			User user = userManagementService.getUserByEmail(userInput);
			resetPasswordService.resetPasswordForUser(user);
		});
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(rb.getString("reset.pass.header"));
		System.out.print(rb.getString("enter.your.email.msg"));
	}

}
