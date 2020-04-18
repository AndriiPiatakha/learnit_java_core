package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmptyRectangleTest {

	
	private static final String OUTPUT_RESULT_SEPARATOR = "Please, enter width of rectangle: ";
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
	public void shouldDrawRectangleEmptyInside() {
		String input = "3 6";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		EmptyRectangle.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("******" + System.lineSeparator() +
				"*    *" + System.lineSeparator() +
				"******", consoleOutput);
	}
	
	@Test
	public void shouldDrawSquareEmptyInside() {
		String input = "4 4";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		EmptyRectangle.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("****" + System.lineSeparator() +
				"*  *" + System.lineSeparator() +
				"*  *" + System.lineSeparator() +
				"****", consoleOutput);
	}
	
	@Test
	public void shouldDrawRectangleNotEmptyInside() {
		String input = "2 6";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		EmptyRectangle.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("******" + System.lineSeparator() +
				"******", consoleOutput);
	}
}
