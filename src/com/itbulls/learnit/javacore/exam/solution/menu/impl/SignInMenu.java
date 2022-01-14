package com.itbulls.learnit.javacore.exam.solution.menu.impl;

import java.util.ResourceBundle;
import java.util.Scanner;

import com.itbulls.learnit.javacore.exam.solution.configs.ApplicationContext;
import com.itbulls.learnit.javacore.exam.solution.enteties.User;
import com.itbulls.learnit.javacore.exam.solution.menu.Menu;
import com.itbulls.learnit.javacore.exam.solution.services.UserManagementService;
import com.itbulls.learnit.javacore.exam.solution.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	private ResourceBundle rb;

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);

		System.out.print(rb.getString("please.enter.email"));
		String userEmail = sc.next();

		System.out.print(rb.getString("please.enter.pass"));
		String userPassword = sc.next();

		User user = userManagementService.getUserByEmail(userEmail);
		if (user != null && user.getPassword().equals(userPassword)) {
			System.out.printf(rb.getString("glad.to.see.you.back"), user.getFirstName(),
					user.getLastName() + System.lineSeparator());
			context.setLoggedInUser(user);
		} else {
			System.out.println(rb.getString("login.and.password.not.exist"));
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(rb.getString("sign.in.header"));		
	}

}
