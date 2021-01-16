package com.itbulls.learnit.javacore.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.itbulls.learnit.javacore.exceptions.NotEnoughMoneyException;

import org.junit.jupiter.api.AfterEach;

public class MoneyTransactionServiceTest {
	
	private static final String MONEY_AMOUNT_EXCEPTION_MSG = "Money amount should be greater than 0";
	private static final String ACCOUNT_EXCEPTION_MSG = "Accounts shouldn't be null";
	private static final double RANDOM_MONEY_AMOUNT = 100;
	private static final double ZERO_MONEY_AMOUNT = 0;
	private static final double MORE_THAN_RANDOM_MONEY_AMOUNT = 200;
	private static final double NEGATIVE_MONEY_AMOUNT = -1;
	
	
	private MoneyTransactionService testInstance;
	
//	@Before 			// in JUnit 4
	@BeforeEach 		// in JUnit 5
	void setUp() {
		testInstance = new MoneyTransactionService();
	}
	
//	@After 			// in JUnit 4
	@AfterEach		// in JUnit 5
	void tearDown() {
		// this method will be executed after each test method
	}
	
//	@BeforeClass	// in JUnit 4 and static method!
	@BeforeAll		// in JUnit 5 and static method!
	static void beforeAll() {
		// this method will be executed before all tests
	}
	
//	@AfterClass // in JUnit 4
	@AfterAll	// in JUnit 5
	static void afterAll() {
		
	}
	
	@Test
//	void transferMoneyTest() {
	void shouldTransferMoneyFromOneAccountToAnother() {
		// GIVEN
		var account1 = new Account(RANDOM_MONEY_AMOUNT);
		var account2 = new Account(ZERO_MONEY_AMOUNT);
		
		// WHEN
		testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT);
		
		// THEN
		assertEquals(ZERO_MONEY_AMOUNT, account1.getMoneyAmount());
		assertEquals(RANDOM_MONEY_AMOUNT, account2.getMoneyAmount());
	}
	

	@Test
	void shouldThrowExceptionIfAccountFromIsNull() {
		// GIVEN
		Account account1 = null;
		Account account2 = new Account(RANDOM_MONEY_AMOUNT);
		
		// WHEN & THEN
		var exception = assertThrows(IllegalArgumentException.class, () -> 
			testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT)
		);
		
		assertEquals(ACCOUNT_EXCEPTION_MSG, exception.getMessage());
	}
	
//	@org.junit.Test(expected = IllegalArgumentException.class)
//	public void shouldThrowExceptionIfAccountFromIsNull2() {
//		// GIVEN
//		Account account1 = null;
//		Account account2 = new Account(RANDOM_MONEY_AMOUNT);
//		testInstance = new MoneyTransactionService();
//		
//		// WHEN & THEN
//		testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT);
//	}
	
	@Test
	void shouldThrowExceptionIfAccountToIsNull() {
		// GIVEN
		Account account1 = new Account(RANDOM_MONEY_AMOUNT);
		Account account2 = null;
		
		// WHEN & THEN
		var exception = assertThrows(IllegalArgumentException.class, () -> 
			testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT)
		);
		
		assertEquals(ACCOUNT_EXCEPTION_MSG, exception.getMessage());
	}
	
	@Test
	void shouldThrowNotEnoughMoneyExceptionWhenTransferMoreMoney() {
		// GIVEN
		var account1 = new Account(RANDOM_MONEY_AMOUNT);
		var account2 = new Account(ZERO_MONEY_AMOUNT);
		
		// WHEN
		assertThrows(NotEnoughMoneyException.class, () -> 
			testInstance.transferMoney(account1, account2, MORE_THAN_RANDOM_MONEY_AMOUNT)
		);
		
	}
	
	@Test
	void shouldThrowExcpetionWhenTransferNegativeAmount() {
		// GIVEN
		var account1 = new Account();
		var account2 = new Account();
		
		// WHEN
		var exception = assertThrows(IllegalArgumentException.class, () -> 
					testInstance.transferMoney(account1, account2, NEGATIVE_MONEY_AMOUNT)
				);
		
		assertEquals(MONEY_AMOUNT_EXCEPTION_MSG, exception.getMessage());
	}
	
	@Test
	void shouldThrowExcpetionWhenTransferZeroMoneyAmount() {
		// GIVEN
		var account1 = new Account();
		var account2 = new Account();

		// WHEN
		var exception = assertThrows(IllegalArgumentException.class, () -> 
					testInstance.transferMoney(account1, account2, ZERO_MONEY_AMOUNT)
				);
		
		assertEquals(MONEY_AMOUNT_EXCEPTION_MSG, exception.getMessage());
	}
}
