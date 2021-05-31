package com.itbulls.learnit.javacore.patterns.behavioral.observer;

public class B2CCustomer implements Observer {

	public B2CCustomer(OnlineStore onlineStore) {
		onlineStore.addListener(this);
	}

	public void update() {
		System.out.println("Goods arrived to the store. Make your B2C order now");
	}

}
