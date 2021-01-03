package com.itbulls.learnit.javacore.io.hw;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class SearchFilesByExtensionTest {
	
	private SearchFilesByExtension testInstance;
	
	@Before
	public void setUp() {
		testInstance = new SearchFilesByExtension();
	}
	
	@Test
	public void shouldCalculateNumberOfFilesWithSpecificExtension() throws IOException {
		File f = new File("." + File.separator + "test"
						+ File.separator + "com" 
						+ File.separator + "itbulls" 
						+ File.separator + "learnit"
						+ File.separator + "javacore"
						+ File.separator + "io"
						+ File.separator + "hw");
		long numberOfFiles = testInstance.getNumberOfFilesWithExtension(f.toPath(), ".java");
		System.out.println(numberOfFiles);
		assertEquals(2, numberOfFiles);
	}
	
	@Test
	public void shouldIgnoreNullInputs() throws IOException {
		assertEquals(0, testInstance.getNumberOfFilesWithExtension(null, null));
	}

}
