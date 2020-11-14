package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.impl.DefaultUser;

public class DefaultUserTest {

	
	@Test
	public void shouldIncrementIdFOrEachNewUser() {
		assertEquals(1, new DefaultUser().getId());
		assertEquals(2, new DefaultUser().getId());
	}
}
