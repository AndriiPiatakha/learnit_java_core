package com.itbulls.learnit.javacore.patterns.creational.abstractfactory.example1;

//ConcreteFactory1

public class MsWindowsWidgetFactory implements AbstractWidgetFactory {

	public Window createWindow() {
		return new MSWindow();

	}

	@Override
	public Scroll createScroll() {
		return new MSScroll();
	}

	@Override
	public Button[] createNavigationButtons() {
		Button[] buttons = {
	               new MSButton("close window"),
	               new MSButton("expand window"),
	               new MSButton("collapse window"),
	               new MSButton("back"),
		};
		return buttons;
	}

}
