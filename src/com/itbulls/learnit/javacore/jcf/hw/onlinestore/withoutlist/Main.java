package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.menu.Menu;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.menu.impl.MainMenu;

public class Main {

	public static final String EXIT_COMMAND = "exit";

	public static void main(String[] args) {
		Menu mainMenu = new MainMenu();
		mainMenu.start();
	}
	
}
