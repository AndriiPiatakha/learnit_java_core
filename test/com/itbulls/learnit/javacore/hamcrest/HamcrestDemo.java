package com.itbulls.learnit.javacore.hamcrest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class HamcrestDemo {
	
	@Test
	void firstHamcrestTest() {
		String actualString = "some value";
		String expectedString = "some value";
		
//		assertThat("optional error message", actualString, equalTo(expectedString));
		assertThat(actualString, equalTo(expectedString));
	}
	
	@Test
	void secondHamcrestTest() {
		var list = new ArrayList<>(Arrays.asList("a", "b", "c"));
		
		assertThat(list, hasItem(anyOf(equalTo("a"), equalTo("b"), equalTo("c"))));
		
		assertTrue(list.contains("a") || list.contains("b") || list.contains("c"));
	}

}
