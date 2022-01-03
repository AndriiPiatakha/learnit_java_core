package com.itbulls.learnit.javacore.dao.hw.solution.menu.impl;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.User;
import com.itbulls.learnit.javacore.dao.hw.solution.menu.Menu;
import com.itbulls.learnit.javacore.dao.hw.solution.services.UserManagementService;
import com.itbulls.learnit.javacore.dao.hw.solution.services.impl.DefaultUserManagementService;

public class ResetPasswordMenu implements Menu {
	
	private UserManagementService userManagementService;

	{
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
			userManagementService.resetPasswordForUser(user);
		});
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** RESET PASSWORD *****");
		System.out.print("Enter your email: ");
	}

}
