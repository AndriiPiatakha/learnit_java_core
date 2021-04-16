package com.itbulls.learnit.javacore.patterns.creational.abstractfactory.example1;

//Client

public class GUIBuilder {

	public void buildWindow(AbstractWidgetFactory widgetFactory) {
		Window window = widgetFactory.createWindow();
		window.setTitle("New Window");
		widgetFactory.createScroll();
		widgetFactory.createNavigationButtons();
	}

}
