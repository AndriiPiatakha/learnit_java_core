package com.itbulls.learnit.javacore.operations.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CircleCircumferenceTest {
	
	private static final String RESULT_SEPARATOR = "Circle circumference is: ";

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
	public void shouldCalculateCircleCircumference1() {
		String input = "10";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		CircleCircumference.main(new String[] {});

		String[] result = out.toString().trim().split(RESULT_SEPARATOR);
		assertEquals(62.83185307179586, Double.parseDouble(result[1]), 0.01);
	}

	@Test
	public void shouldCalculateCircleCircumference2() {
		String input = "5";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		CircleCircumference.main(new String[] {});

		String[] result = out.toString().trim().split(RESULT_SEPARATOR);
		assertEquals(31.41592653589793, Double.parseDouble(result[1]), 0.01);
	}

}
