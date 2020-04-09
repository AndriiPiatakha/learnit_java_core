package com.itbulls.learnit.javacore.string.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PINumberFormattingTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setStreams() {
		System.setOut(new PrintStream(out));
	}

	@After
	public void restoreInitialStreams() {
		System.setOut(originalOut);
	}
	
	@Test
	public void shouldPrintPiNumberFiveTimes() {
	    PINumberFormatting.main(new String[] {});
		assertEquals("3.1,3.14,3.142,3.1416,3.14159",out.toString().trim().replace(System.lineSeparator(), ","));
	}

}
