package com.itbulls.learnit.javacore.oop.telldontask;

import java.math.BigDecimal;

public class Bank {

	public void withdraw(BigDecimal ammount, UserAccount userAccount) {
		if (userAccount.getBalance().compareTo(ammount) > 0)
			userAccount.setBalance(userAccount.getBalance().subtract(ammount));
	}
	
}

