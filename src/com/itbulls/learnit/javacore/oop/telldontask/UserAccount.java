package com.itbulls.learnit.javacore.oop.telldontask;

import java.math.BigDecimal;

public class UserAccount {
	
	private User userName;
	private Long accountNumber;
	private BigDecimal balance;

	public void withdraw(BigDecimal amount) {
		if (getBalance().compareTo(amount) > 0) {
			setBalance(getBalance().subtract(amount));
		}
	}
	
	//...
	
	public User getUserName() { 
		return userName; 
	}

	public void setUserName(User userName) { 
		this.userName = userName; 
	}

	public Long getAccountNumber() { 
		return accountNumber; 
	}

	public void setAccountNumber(Long an) { 
		this.accountNumber = an; 
	}

	public BigDecimal getBalance() { 
		return balance; 
	}

	public void setBalance(BigDecimal balance) { 
		this.balance = balance;
	}
}
