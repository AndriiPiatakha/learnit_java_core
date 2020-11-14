package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.menu.Menu;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.menu.impl.MainMenu;

public class Main {

	public static final String EXIT_COMMAND = "exit";

	public static void main(String[] args) {
		Menu mainMenu = new MainMenu();
		mainMenu.start();
	}
	
}
