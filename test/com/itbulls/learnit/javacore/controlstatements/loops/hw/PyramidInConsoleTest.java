package com.itbulls.learnit.javacore.controlstatements.loops.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PyramidInConsoleTest {
	private static final String OUTPUT_RESULT_SEPARATOR = 
			"Please, enter height of the pyramid: ";
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
	public void shouldDrawPyramid() {
		String input = "3";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		PyramidInConsole.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("*" + System.lineSeparator() +
				"**" + System.lineSeparator() +
				"***" + System.lineSeparator() +
				"**" + System.lineSeparator() +
				"*", consoleOutput);
	}
	
	@Test
	public void shouldDrawPyramid2() {
		String input = "5";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		PyramidInConsole.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("*" + System.lineSeparator() +
				"**" + System.lineSeparator() +
				"***" + System.lineSeparator() +
				"****" + System.lineSeparator() +
				"*****" + System.lineSeparator() +
				"****" + System.lineSeparator() +
				"***" + System.lineSeparator() +
				"**" + System.lineSeparator() +
				"*", consoleOutput);
	}
	
	@Test
	public void shouldDrawPyramid3() {
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		PyramidInConsole.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("*", consoleOutput);
	}
}
