package com.itbulls.learnit.javacore.exam.solution.menu.impl;

import java.util.ResourceBundle;
import java.util.Scanner;

import com.itbulls.learnit.javacore.exam.solution.configs.ApplicationContext;
import com.itbulls.learnit.javacore.exam.solution.menu.Menu;

public class SettingsMenu implements Menu {

	private ApplicationContext context;
	private ResourceBundle rb;
	
	{
		context = ApplicationContext.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}

	@Override
	public void start() {
		Menu menuToNavigate = null;
		mainLoop: while (true) {
			printMenuHeader();
			if (context.getLoggedInUser() == null) {
				System.out.println(
						"Please, log in or create new account to change your account settings");
				new MainMenu().start();
				return;
			} else {
				System.out.println(rb.getString("settings.options"));
				System.out.print(rb.getString("enter.option"));
				Scanner sc = new Scanner(System.in);
				String userInput = sc.next();

				if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
					menuToNavigate = new MainMenu();
					break mainLoop;
				}

				int userOption = Integer.parseInt(userInput);
				switch (userOption) {
				case 1:
					menuToNavigate = new ChangePasswordMenu();
					break mainLoop;
				case 2:
					menuToNavigate = new ChangeEmailMenu();
					break mainLoop;
				default:
					System.out.println(rb.getString("settings.option.validation.msg"));
					continue;
				}
			}
		}

		menuToNavigate.start();

	}

	@Override
	public void printMenuHeader() {
		System.out.println(rb.getString("settings.menu.header"));		
	}

}
