package com.itbulls.learnit.javacore.junit5;

import com.itbulls.learnit.javacore.exceptions.NotEnoughMoneyException;

public class MoneyTransactionService {
	
	public boolean transferMoney(Account accountFrom, Account accountTo, double moneyAmountToSend) {
		if (accountFrom == null || accountTo == null ) {
			throw new IllegalArgumentException("Accounts shouldn't be null");
		}
		
		if (moneyAmountToSend <= 0) {
			throw new IllegalArgumentException("Money amount should be greater than 0");
		}
		
		if (accountFrom.getMoneyAmount() < moneyAmountToSend) {
			throw new NotEnoughMoneyException();
		}
		
		accountFrom.setMoneyAmount(accountFrom.getMoneyAmount() - moneyAmountToSend);
		accountTo.setMoneyAmount(accountTo.getMoneyAmount() + moneyAmountToSend);
		
		return true;
	}

}
