package com.itbulls.learnit.javacore.exam.solution.menu.impl;

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

	{
		resetPasswordService = new DefaultResetPasswordService();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		System.out.println("Your password has been sent to your email. Please, check mailbox. You will receive the email within the next 5 minutes");
		CompletableFuture.runAsync(() -> {
			User user = userManagementService.getUserByEmail(userInput);
			resetPasswordService.resetPasswordForUser(user);
		});
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** RESET PASSWORD *****");
		System.out.print("Enter your email: ");
	}

}
