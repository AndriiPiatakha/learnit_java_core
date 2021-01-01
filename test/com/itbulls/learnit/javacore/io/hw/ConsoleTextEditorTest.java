package com.itbulls.learnit.javacore.io.hw;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ConsoleTextEditorTest {

	@Rule
	public TemporaryFolder tempFolderRule = new TemporaryFolder();
	
	private ConsoleTextEditor testInstance;
	private File fileToWrite;
	
	@Before
	public void setUp() throws IOException {
		fileToWrite = tempFolderRule.newFile();
		testInstance = new ConsoleTextEditor(fileToWrite);
	}
	
	@Test
	public void shouldWriteUserInputToFile() throws IOException {
		String input = "aaa" + System.lineSeparator() + "bbb" + System.lineSeparator() + "ccc" + 
					System.lineSeparator() + "exit";
		String expectedOutput = "aaa" + System.lineSeparator() + "bbb" + System.lineSeparator() + "ccc";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		testInstance.start();
		assertEquals(expectedOutput, 
				Files.readAllLines(fileToWrite.toPath())
									.stream()
									.collect(Collectors.joining(System.lineSeparator())));
	}
}
