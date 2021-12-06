package com.itbulls.learnit.javacore.exam.template;

import com.itbulls.learnit.javacore.exam.template.menu.Menu;
import com.itbulls.learnit.javacore.exam.template.menu.impl.MainMenu;

public class Main {

	public static final String EXIT_COMMAND = "exit";

	public static void main(String[] args) {
		Menu mainMenu = new MainMenu();
		mainMenu.start();
	}
	
}
