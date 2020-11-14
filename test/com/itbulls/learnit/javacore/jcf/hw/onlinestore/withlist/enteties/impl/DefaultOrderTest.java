package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.impl.DefaultOrder;

public class DefaultOrderTest {
	
	private DefaultOrder testInstance;
	
	@Before
	public void setUp() {
		testInstance = new DefaultOrder();
	}
	
	@Test
	public void shouldCheckIfCreditCardNumberValid() {
		assertTrue(testInstance.isCreditCardNumberValid("1234123412341234"));
	}
	
	@Test
	public void shouldCheckIfCreditCardNumberIsNotValidStringWithSpaces() {
		assertFalse(testInstance.isCreditCardNumberValid("1234 1234 1234 1234"));
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldCheckIfCreditCardNumberIsNotValidString() {
		assertFalse(testInstance.isCreditCardNumberValid("asdfasdfasdfasdf"));
	}
	
	

}
