package com.itbulls.learnit.javacore.junit5;

public class Account {

	private double moneyAmount;
	
	public Account() {
	}
	
	public Account(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	
	public double getMoneyAmount() {
		return this.moneyAmount;
	}

	public void setMoneyAmount(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

}
