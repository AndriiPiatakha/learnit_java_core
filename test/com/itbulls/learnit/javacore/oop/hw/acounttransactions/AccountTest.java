package com.itbulls.learnit.javacore.oop.hw.acounttransactions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class AccountTest {
	
	private static final int ZERO_MONEY = 0;
	private static final int ACCOUNT_ID_FROM = 1;
	private static final int ACCOUNT_ID_TO = 2;
	private static final int RANDOM_MONEY_AMOUNT = 100;
	
	private Account testInstance;
	
	@Before
	public void setUp() {
		testInstance = new Account(ACCOUNT_ID_FROM);
	}
	
	@Test
	public void shouldNotSendMoneyToAccountIfAccountToIsNull() {
		testInstance.sendMoneyToAccount(null, RANDOM_MONEY_AMOUNT);
		assertEquals(0, testInstance.getTransactions().length);
	}
	
	@Test
	public void shouldNotSendMoneyToAccountIfMoneyIsZero() {
		testInstance.sendMoneyToAccount(new Account(ACCOUNT_ID_TO), ZERO_MONEY);
		assertEquals(0, testInstance.getTransactions().length);
	}
	
	@Test
	public void shouldCreateTransactionWhenMoneySent() {
		Account accountTo = new Account(ACCOUNT_ID_TO);
		testInstance.sendMoneyToAccount(accountTo, RANDOM_MONEY_AMOUNT);
		
		Account.Transaction createdTransaction = testInstance.getTransactions()[0];
		
		assertEquals(testInstance, createdTransaction.getAccountFrom());
		assertEquals(accountTo, createdTransaction.getAccountTo());
		assertEquals(RANDOM_MONEY_AMOUNT, createdTransaction.getMoneyAmount(), 0.01);
		assertEquals(StandardAccountOperations.MONEY_TRANSFER_SEND, createdTransaction.getOperation());
	}
	
	@Test
	public void shouldCreateTransactionWhenMoneyReceived() {
		Account accountTo = new Account(ACCOUNT_ID_TO);
		testInstance.sendMoneyToAccount(accountTo, RANDOM_MONEY_AMOUNT);
		
		Account.Transaction createdTransaction = accountTo.getTransactions()[0];
		
		assertEquals(testInstance, createdTransaction.getAccountFrom());
		assertEquals(accountTo, createdTransaction.getAccountTo());
		assertEquals(RANDOM_MONEY_AMOUNT, createdTransaction.getMoneyAmount(), 0.01);
		assertEquals(StandardAccountOperations.MONEY_TRANSFER_RECEIVE, createdTransaction.getOperation());
	}
	
	@Test
	public void shouldCreateTransactionWhenWithdrawMoney() {
		testInstance.withdrawMoney(RANDOM_MONEY_AMOUNT);
		
		Account.Transaction createdTransaction = testInstance.getTransactions()[0];
		
		assertEquals(testInstance, createdTransaction.getAccountFrom());
		assertEquals(RANDOM_MONEY_AMOUNT, createdTransaction.getMoneyAmount(), 0.01);
		assertEquals(StandardAccountOperations.WITHDRAW, createdTransaction.getOperation());
	
	}

}
