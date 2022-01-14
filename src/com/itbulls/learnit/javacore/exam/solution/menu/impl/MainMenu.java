package com.itbulls.learnit.javacore.exam.solution.menu.impl;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.itbulls.learnit.javacore.exam.solution.Main;
import com.itbulls.learnit.javacore.exam.solution.configs.ApplicationContext;
import com.itbulls.learnit.javacore.exam.solution.menu.Menu;

public class MainMenu implements Menu {

	public static final String MENU_COMMAND = "menu";
	private ResourceBundle rb;
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}
	
	@Override
	public void start() {
		if (context.getMainMenu() == null) {
			context.setMainMenu(this);
		}
		
		Menu menuToNavigate = null;
		mainLoop: while (true) {
			printMenuHeader();
			
			Scanner sc = new Scanner(System.in);

			System.out.print(rb.getString("user.input"));
			String userInput = sc.next();
			if (userInput.equalsIgnoreCase(Main.EXIT_COMMAND)) {
				System.exit(0);
			} else {
				int commandNumber = Integer.parseInt(userInput);
				switch (commandNumber) {
				
				case 1:
					menuToNavigate = new SignUpMenu();
					break mainLoop;
				case 2:
					if (context.getLoggedInUser() == null) {
						menuToNavigate = new SignInMenu();
					} else {
						menuToNavigate = new SignOutMenu();
					}
					break mainLoop;
				case 3:
					menuToNavigate = new ProductCatalogMenu();
					break mainLoop;
				case 4:
					menuToNavigate = new MyOrdersMenu();
					break mainLoop;
				case 5:
					menuToNavigate = new SettingsMenu();
					break mainLoop;
				case 6:
					menuToNavigate = new CustomerListMenu();
					break mainLoop;
				case 7:
					menuToNavigate = new ResetPasswordMenu();
					break mainLoop;
				case 8:
					menuToNavigate = new ChangeLanguageMenu();
					break mainLoop;
				default:
					System.out.println(rb.getString("err.msg"));
					continue; // continue endless loop
				}
			}
		}
		
		menuToNavigate.start();
		
	}

	@Override
	public void printMenuHeader() {
		System.out.println(rb.getString("main.menu.header"));
		if (context.getLoggedInUser() == null) {
			System.out.println(rb.getString("menu.for.not.logged.in.user"));
		} else {
			System.out.println(rb.getString("menu.for.logged.in.user"));
		}
	}

}
