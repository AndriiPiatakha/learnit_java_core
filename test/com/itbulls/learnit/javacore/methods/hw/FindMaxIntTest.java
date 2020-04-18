package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindMaxIntTest {
	
	@Test
	public void shouldFindMaxIntInArray() {
		int[] arr = {1, 100, 2, 5, 8 -100};
		assertEquals(100, FindMaxInt.findMaxIntInArray(arr));
	}
	
	@Test
	public void shouldFindMaxIntInArrayStreamApi() {
		int[] arr = {1, 100, 2, 5, 8 -100};
		assertEquals(100, FindMaxInt.findMaxIntInArrayStreamApi(arr));
	}

}
