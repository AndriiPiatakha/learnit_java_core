package com.itbulls.learnit.javacore.exam.solution;

import com.itbulls.learnit.javacore.exam.solution.menu.Menu;
import com.itbulls.learnit.javacore.exam.solution.menu.impl.MainMenu;

public class Main {

	public static final String EXIT_COMMAND = "exit";

	public static void main(String[] args) {
		Menu mainMenu = new MainMenu();
		mainMenu.start();
	}
	
}
