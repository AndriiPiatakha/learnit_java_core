package com.itbulls.learnit.javacore.controlstatements.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddNumbersTest {
	
	private static final String FLOATING_POINT_NUMBER_PLACES_SEPARATOR = ".";
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
	public void shouldAddPositiveAndNegativeInteger() {
		AddNumbers.main(new String[]{"1", "-2"});
		String consoleOutput = out.toString().trim();
		assertFalse(consoleOutput.contains(FLOATING_POINT_NUMBER_PLACES_SEPARATOR));
		assertEquals("-1", consoleOutput);
	}
	
	@Test
	public void shouldAddPositiveAndPositiveInteger() {
		AddNumbers.main(new String[]{"1", "3"});
		String consoleOutput = out.toString().trim();
		assertFalse(consoleOutput.contains(FLOATING_POINT_NUMBER_PLACES_SEPARATOR));
		assertEquals("4", consoleOutput);
	}
	
	@Test
	public void shouldAddZeroToZero() {
		AddNumbers.main(new String[]{"0", "0"});
		String consoleOutput = out.toString().trim();
		assertFalse(consoleOutput.contains(FLOATING_POINT_NUMBER_PLACES_SEPARATOR));
		assertEquals("0", consoleOutput);
	}
	
	@Test
	public void shouldAddFloatingPointNumberToInteger() {
		AddNumbers.main(new String[]{"1.1", "1"});
		String consoleOutput = out.toString().trim();
		assertTrue(consoleOutput.contains(FLOATING_POINT_NUMBER_PLACES_SEPARATOR));
		assertEquals("2.1", consoleOutput);
	}
	
	@Test
	public void shouldAddFloatingPointNumberToInteger2() {
		AddNumbers.main(new String[]{"1", "2.1"});
		String consoleOutput = out.toString().trim();
		assertTrue(consoleOutput.contains(FLOATING_POINT_NUMBER_PLACES_SEPARATOR));
		assertEquals("3.1", consoleOutput);
	}
	
	@Test
	public void shouldAddFloatingPointNumbers() {
		AddNumbers.main(new String[]{"1.1", "2.1"});
		String consoleOutput = out.toString().trim();
		assertTrue(consoleOutput.contains(FLOATING_POINT_NUMBER_PLACES_SEPARATOR));
		assertEquals("3.2", consoleOutput);
	}

}
