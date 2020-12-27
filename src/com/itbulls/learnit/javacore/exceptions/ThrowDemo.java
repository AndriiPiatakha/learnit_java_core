package com.itbulls.learnit.javacore.exceptions;

import java.io.FileNotFoundException;

public class ThrowDemo {
	
	public static void main(String[] args) {
		ThrowDemo demo = new ThrowDemo();
		demo.transferMoney(null, null, 0);
	}
	
	public void transferMoney(Account from, Account to, double moneyToTransfer) {
		if (from == null || to == null || from.getMoney() < moneyToTransfer) {
//			throw new IllegalArgumentException();
//			throw new IllegalArgumentException("Invalid arguments");
			throw new RuntimeException(new FileNotFoundException());
		}
		// and here goes money transferring logic
	}
	
	public void transferMoney2(Account from, Account to, double moneyToTransfer) {
		if (from == null || to == null) {
			throw new IllegalArgumentException();
		}
		if (from.getMoney() < moneyToTransfer) {
			throw new NotEnoughMoneyException();
		}
	}

}

class Account {

	private double money;
	
	public double getMoney() {
		return this.money;
	}
	
}
