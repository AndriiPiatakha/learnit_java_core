package com.itbulls.learnit.javacore.patterns.creational.abstractfactory.example1;


public class MacOsWidgetFactory implements AbstractWidgetFactory {

	@Override
	public Window createWindow() {
		return new MacOsWindow();
	}

	@Override
	public Scroll createScroll() {
		return new MacOsScroll();
	}

	@Override
	public Button[] createNavigationButtons() {
		Button[] buttons = {
		               new MacOsButton("close window"),
		               new MacOsButton("expand window"),
		               new MacOsButton("collapse window"),
		               new MacOsButton("back"),
		};
		return buttons;
	}
	
}
