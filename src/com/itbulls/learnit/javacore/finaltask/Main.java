package com.itbulls.learnit.javacore.finaltask;

import com.itbulls.learnit.javacore.finaltask.menu.Menu;
import com.itbulls.learnit.javacore.finaltask.menu.impl.MainMenu;

public class Main {

	public static final String EXIT_COMMAND = "exit";

	public static void main(String[] args) {
		Menu mainMenu = new MainMenu();
		mainMenu.start();
	}
	
}
