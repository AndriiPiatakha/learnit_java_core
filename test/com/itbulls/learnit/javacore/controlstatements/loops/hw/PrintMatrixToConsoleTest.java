package com.itbulls.learnit.javacore.controlstatements.loops.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrintMatrixToConsoleTest {
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
	public void shouldPrintMatrixToConsole() {
		PrintMatrixToConsole.main(new String[] {});
		
		String consoleOutput = out.toString().strip();
		String[] lines = consoleOutput.split(System.lineSeparator());
		assertEquals("12345", lines[0].replaceAll("\\s+", ""));
		assertEquals("67", lines[1].replaceAll("\\s+", ""));
		assertEquals("8910", lines[2].replaceAll("\\s+", ""));
	}
}
