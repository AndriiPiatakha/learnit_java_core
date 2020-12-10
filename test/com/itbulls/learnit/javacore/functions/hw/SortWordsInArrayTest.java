package com.itbulls.learnit.javacore.functions.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortWordsInArrayTest {
	
	private static final String OUTPUT_RESULT_SEPARATOR = "Please, enter words separated by space: ";
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
	public void shouldSortWordsInArray() {
		String input = "apple windows oracle microsoft Apple zpple";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		SortWordsInArray.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("microsoft windows oracle apple Apple zpple", consoleOutput);
	}
	
	@Test
	public void shouldSortWordsInArray2() {
		String input = "appleeee  window1s orac23le microsoft   zeApple zpplsde";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		SortWordsInArray.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("microsoft appleeee orac23le window1s zeApple zpplsde", consoleOutput);
	}



}
