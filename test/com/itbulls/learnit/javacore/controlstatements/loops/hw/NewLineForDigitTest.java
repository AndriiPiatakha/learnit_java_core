package com.itbulls.learnit.javacore.controlstatements.loops.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NewLineForDigitTest {
	
	private static final String OUTPUT_RESULT_SEPARATOR = "Please, enter any integer: ";
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
	public void shouldPrintDigitsInPositiveNumberFromNewLine() {
		String input = "125348";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		NewLineForDigit.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"8", consoleOutput);
	}
	

}
