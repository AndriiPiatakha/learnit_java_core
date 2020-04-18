package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringProcessorTest {

	private static final String INPUT_DATA = "Login;Name;Email" + System.lineSeparator()
			+ "peton;Chris Peterso;person@outlook.com" + System.lineSeparator()
			+ "jas;Derek Jame;jes@gmail.com" + System.lineSeparator()
			+ "jack;Walter Jackso;jkson@gmail.com" + System.lineSeparator()
			+ "greg;Mike Gregor;ggory@yahoo.com";

	@Test
	public void shouldFormatConvert1() {
		assertEquals(
				"peton ==> person@outlook.com" + System.lineSeparator()
						+ "jas ==> jes@gmail.com" + System.lineSeparator()
						+ "jack ==> jkson@gmail.com" + System.lineSeparator()
						+ "greg ==> ggory@yahoo.com",
				StringProcessor.convert1(INPUT_DATA).strip());
	}

	@Test
	public void shouldFormatConvert2() {
		assertEquals(
				"Chris Peterso (email: person@outlook.com)" + System.lineSeparator()
						+ "Derek Jame (email: jes@gmail.com)" + System.lineSeparator()
						+ "Walter Jackso (email: jkson@gmail.com)"
						+ System.lineSeparator() + "Mike Gregor (email: ggory@yahoo.com)",
				StringProcessor.convert2(INPUT_DATA).strip());
	}


}
