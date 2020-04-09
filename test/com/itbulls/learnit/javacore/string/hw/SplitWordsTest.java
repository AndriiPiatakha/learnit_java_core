package com.itbulls.learnit.javacore.string.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SplitWordsTest {

	private static final String RESULT_SEPARATOR = "You entered these words: ";
	
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
	public void shouldSplitByAllPunctionaCharacters() {
	    String input = "Text with random punctuation marks: Java\t is a general-purpose    "
	    		+ "programming! \'language\'?? \"that\" ;is (class-based) and, "
	    		+ "object-oriented.";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);

	    SplitWords.main(new String[] {});
	    
	    String[] result = out.toString().trim().split(RESULT_SEPARATOR);
		assertEquals("[Text, with, random, punctuation, marks, "
				+ "Java, is, a, general, purpose, programming, "
				+ "language, that, is, class, based, and, object, "
				+ "oriented]",result[1]);
	}
	
}
