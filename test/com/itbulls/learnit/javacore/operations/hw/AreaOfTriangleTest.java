package com.itbulls.learnit.javacore.operations.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AreaOfTriangleTest {
	
	private static final String RESULT_SEPARATOR = "Triangle area is: ";
	
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
	public void shouldCalculateTriangleArea() {
	    String input = "4 4 4";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);

	    AreaOfTriangle.main(new String[] {});
	    
	    String[] result = out.toString().trim().split(RESULT_SEPARATOR);
		assertEquals(6.928203230275509, Double.parseDouble(result[1]), 0.01);
	}
	
	@Test
	public void shouldReturnNaNIfTriangleNotExist() {
	    String input = "5 1 1";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);

	    AreaOfTriangle.main(new String[] {});
	    
	    String[] result = out.toString().trim().split(RESULT_SEPARATOR);
		assertTrue(Double.isNaN(Double.parseDouble(result[1])));
	}
}
