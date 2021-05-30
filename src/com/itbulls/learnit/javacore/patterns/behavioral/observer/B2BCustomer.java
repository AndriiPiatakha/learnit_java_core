package com.itbulls.learnit.javacore.patterns.behavioral.observer;

public class B2BCustomer implements Observer {

	private OnlineStore onlineStore;
	
	public B2BCustomer(OnlineStore onlineStore) {
	        this.onlineStore = onlineStore;
	        this.onlineStore.addListener(this);
	    }

	public void update() {
		System.out.println("Goods arrived to the store. Make your B2B order now");
	}

}
