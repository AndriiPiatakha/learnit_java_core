package com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DefaultUserTest {

	private DefaultUser testInstance;
	
	@Before
	public void setUp() {
		testInstance = new DefaultUser();
	}
	
	@Test
	public void shouldIncrementIdFOrEachNewUser() {
		assertEquals(1, testInstance.getId());
		assertEquals(2, new DefaultUser().getId());
	}
}
