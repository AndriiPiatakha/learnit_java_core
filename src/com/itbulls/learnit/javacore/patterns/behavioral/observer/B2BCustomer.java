package com.itbulls.learnit.javacore.patterns.behavioral.observer;

public class B2BCustomer implements Observer {

	public B2BCustomer(OnlineStore onlineStore) {
		onlineStore.addListener(this);
	}

	public void update() {
		System.out.println("Goods arrived to the store. Make your B2B order now");
	}

}
