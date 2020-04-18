package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GreatestCommonDivisorTest {
	
	@Test
	public void shouldReturnGreatestCommmonDivisor() {
		assertEquals(12, GreatestCommonDivisor.gcdRecursive(12, 36));
	}
	
	@Test
	public void shouldReturnGreatestCommmonDivisor2() {
		assertEquals(12, GreatestCommonDivisor.gcdRecursive(-12, 36));
	}
	
	@Test
	public void shouldReturnGreatestCommmonDivisor3() {
		assertEquals(1, GreatestCommonDivisor.gcdRecursive(10, 3));
	}
	
	@Test
	public void shouldReturnGreatestCommmonDivisor4() {
		assertEquals(8, GreatestCommonDivisor.gcdRecursive(8, 40));
	}

}
