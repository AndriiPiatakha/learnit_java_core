package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AmountOfWordsTest {
	
	@Test
	public void shouldReturnAmountOfWordsForText() {
		String inputText = "some random text! With punctuation, marks...";
		assertEquals(6, AmountOfWords.getWordsAmount(inputText));
	}

}
