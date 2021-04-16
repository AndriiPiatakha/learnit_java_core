package com.itbulls.learnit.javacore.patterns.creational.abstractfactory.example1;

public class Demo {
	
	public static void main(final String[] args) {
		GUIBuilder builder = new GUIBuilder();

		AbstractWidgetFactory widgetFactory = null;

		// check what platform we're on
		String platform = "MACOSX";
		if (platform.equals("MACOSX")) {
			widgetFactory = new MacOsWidgetFactory();
		} else {
			widgetFactory = new MsWindowsWidgetFactory();
		}
		
		builder.buildWindow(widgetFactory);
	}
}
