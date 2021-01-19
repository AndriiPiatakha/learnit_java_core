package com.itbulls.learnit.javacore.junit5;

import org.junit.jupiter.api.Test;

public class TestCodeCoverageDemoTest {
	
	private TestCodeCoverageDemo testInstance = new TestCodeCoverageDemo();
	
	@Test
	void testStringNull() {
		testInstance.testCodeCoverage(null);
	}

}
