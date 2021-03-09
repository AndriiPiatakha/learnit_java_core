package com.itbulls.learnit.javacore.oop.telldontask;

import java.math.BigDecimal;

public class Bank {
	private UserAccount userAccount = new UserAccount();

	public void withdraw(BigDecimal ammount) {
		if (this.userAccount.getBalance().compareTo(ammount) > 0)
			this.userAccount.setBalance(this.userAccount.getBalance().min(ammount));
	}
}

