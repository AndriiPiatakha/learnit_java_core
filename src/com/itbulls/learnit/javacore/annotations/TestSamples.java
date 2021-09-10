package com.itbulls.learnit.javacore.annotations;

public class TestSamples {
	
	@Test(name = "test without exception")
	public void shouldNotThrowException() {
		// method that doesn't throw exception
	}
	
	@Test(name = "test with exception", expected = RuntimeException.class)
	public void shouldThrowException() {
		throw new RuntimeException();
	}

}
