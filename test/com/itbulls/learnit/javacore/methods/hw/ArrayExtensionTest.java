package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayExtensionTest {
	
	@Test
	public void shouldGenerateRandomIntArrayInRangeFrom1To100With5Elements() {
		int amountOfElements = 5;
		int[] generateRandomArray = ArrayExtension.generateRandomArray(amountOfElements);
		assertEquals(amountOfElements, generateRandomArray.length);
	}
	
	@Test
	public void shouldGenerateRandomIntArrayInRangeFrom1To100With100Elements() {
		int amountOfElements = 100;
		int[] generateRandomArray = ArrayExtension.generateRandomArray(amountOfElements);
		assertEquals(amountOfElements, generateRandomArray.length);
	}
	
	@Test
	public void shouldGenerateRandomIntArrayInRangeFrom1To100() {
		int amountOfElements = 100;
		int[] generateRandomArray = ArrayExtension.generateRandomArray(amountOfElements);
		for (int i : generateRandomArray) {
			assertTrue(i >= 0);
			assertTrue(i <= 100);
		}
	}

}
