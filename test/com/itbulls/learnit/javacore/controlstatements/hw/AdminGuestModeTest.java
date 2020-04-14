package com.itbulls.learnit.javacore.controlstatements.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdminGuestModeTest {

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
	public void shouldBeStartedInAdminMode() {
		AdminGuestMode.main(new String[] {"asd sdqwd wqdw --admin asdqwk lq"});
		String consoleOutput = out.toString().trim();
		assertEquals("Hello, Admin!", consoleOutput);
	}
	
	@Test
	public void shouldBeStartedInGuestMode() {
		AdminGuestMode.main(new String[] {"asd sdqwd wqdw --guest asdqwk lq"});
		String consoleOutput = out.toString().trim();
		assertEquals("Hello, Guest!", consoleOutput);
	}
	
	@Test
	public void shouldNotBeStartedInGuestAndAdminMode() {
		AdminGuestMode.main(new String[] {"asd --admin wqdw --guest asdqwk lq"});
		String consoleOutput = out.toString().trim();
		assertEquals("Please, select either 'ADMIN' or "
				+ "'GUEST' mode for this program", consoleOutput);
	}
	
}
