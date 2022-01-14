package com.itbulls.learnit.javacore.controlstatements.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserActivitySelectorTest {

	private static final String OUTPUT_RESULT_SEPARATOR = "Please, enter action name:";
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
	public void shouldProcessLoginEvent() {
		String input = "login";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		UserActivitySelector.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("Please, enter your username", consoleOutput);
	}

	@Test
	public void shouldProcessSignUpEvent() {
		String input = "sign_up";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		UserActivitySelector.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("Welcome!", consoleOutput);
	}

	@Test
	public void shouldProcessTerminationEvent() {
		String input = "terminate_program";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		UserActivitySelector.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("Thank you! Good bye!", 
				consoleOutput);
	}

	@Test
	public void shouldProcessMainMenuEvent() {
		String input = "main_menu";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		UserActivitySelector.main(new String[] {});
		
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("Main menu", 
				consoleOutput);
	}

	@Test
	public void shouldProcessAboutAppEvent() {
		String input = "about_app";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		UserActivitySelector.main(new String[] {});
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("This app is created by me with support of ©IT-Bulls.com", 
				consoleOutput);
	}

	@Test
	public void shouldProcessDefaultEvent() {
		String input = "any other input about_app";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		UserActivitySelector.main(new String[] {});
		String consoleOutput = out.toString().split(OUTPUT_RESULT_SEPARATOR)[1].strip();
		assertEquals("Please, enter one of these values: login, sign_up, terminate_program, main_menu, about_app", 
				consoleOutput);

	}

}
