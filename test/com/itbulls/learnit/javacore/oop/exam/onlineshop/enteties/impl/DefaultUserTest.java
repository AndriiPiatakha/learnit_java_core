package com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DefaultUserTest {

	
	@Test
	public void shouldIncrementIdFOrEachNewUser() {
		assertEquals(1, new DefaultUser().getId());
		assertEquals(2, new DefaultUser().getId());
	}
}
