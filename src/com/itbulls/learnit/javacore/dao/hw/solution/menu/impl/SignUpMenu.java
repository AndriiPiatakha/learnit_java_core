package com.itbulls.learnit.javacore.dao.hw.solution.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.dao.hw.solution.configs.ApplicationContext;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.User;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.impl.DefaultUser;
import com.itbulls.learnit.javacore.dao.hw.solution.menu.Menu;
import com.itbulls.learnit.javacore.dao.hw.solution.services.UserManagementService;
import com.itbulls.learnit.javacore.dao.hw.solution.services.impl.DefaultUserManagementService;
import com.itbulls.learnit.javacore.dao.hw.solution.services.impl.MySqlUserManagementService;

public class SignUpMenu implements Menu {

	private UserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = new MySqlUserManagementService();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your first name: ");
		String firstName = sc.next();
		System.out.print("Please, enter your last name: ");
		String lastName = sc.next();
		System.out.print("Please, enter your password: ");
		String password = sc.next();
		System.out.print("Please, enter your email: ");
		sc = new Scanner(System.in);
		String email = sc.nextLine();
		sc = new Scanner(System.in);
		System.out.print("Please, enter your credit card number: ");
		String creditCard = sc.next();

		User user = new DefaultUser(firstName, lastName, password, email, creditCard);
		
		String errorMessage = userManagementService.registerUser(user);
		if (errorMessage != null && errorMessage.equals(MySqlUserManagementService.SUCCESSFULL_REGISTRATION_MESSAGE)) {
			context.setLoggedInUser(user);
			System.out.println("New user is created");
		} else {
			System.out.println(errorMessage);
		}

		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SIGN UP *****");		
	}

}
