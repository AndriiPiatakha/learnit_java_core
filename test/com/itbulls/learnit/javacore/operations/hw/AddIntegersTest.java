package com.itbulls.learnit.javacore.operations.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddIntegersTest {

	
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
		AddIntegers.main(new String[]{"1", "-2"});
		assertEquals("-1", out.toString().trim());
	}
	
	@Test
	public void shouldAddPositiveAndPositiveInteger() {
		AddIntegers.main(new String[]{"1", "3"});
		assertEquals("4", out.toString().trim());
	}
	
	@Test
	public void shouldAddZeroToZero() {
		AddIntegers.main(new String[]{"0", "0"});
		assertEquals("0", out.toString().trim());
	}

}
