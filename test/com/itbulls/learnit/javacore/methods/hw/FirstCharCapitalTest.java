package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FirstCharCapitalTest {
	
	private static final String INPUT_DATA = "When\tI   was younger" + System.lineSeparator()
	+ "I never\t  needed";
	
	@Test
	public void shouldFormatString() {
		assertEquals("When	I   Was Younger" + System.lineSeparator() +
				"I Never	  Needed", FirstCharCapital.firstCharToTitleCase(INPUT_DATA));
	}

}
