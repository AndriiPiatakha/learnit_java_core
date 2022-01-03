package com.itbulls.learnit.javacore.dao.hw.solution.menu.impl;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.configs.ApplicationContext;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.User;
import com.itbulls.learnit.javacore.dao.hw.solution.menu.Menu;
import com.itbulls.learnit.javacore.dao.hw.solution.services.UserManagementService;
import com.itbulls.learnit.javacore.dao.hw.solution.services.impl.DefaultUserManagementService;
import com.itbulls.learnit.javacore.dao.hw.solution.services.impl.MySqlUserManagementService;

public class CustomerListMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = new MySqlUserManagementService();
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		List<User> users = userManagementService.getUsers();
		
		if (users == null || users.size() == 0) {
			System.out.println("Unfortunately, there are no customers.");
		} else {
			for (User user : users) {
				System.out.println(user);
			}
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** USERS *****");		
	}

}
