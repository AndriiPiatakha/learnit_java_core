package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SumDigitsInNumberTest {
	
	@Test
	public void shouldSumDigitInNumber() {
		assertEquals(6, SumDigitsInNumber.sumDigitsInNumber(123));
	}
	
	@Test
	public void shouldSumDigitInNumber2() {
		assertEquals(21, SumDigitsInNumber.sumDigitsInNumber(123456));
	}
	
	@Test
	public void shouldSumDigitInNegativeNumber() {
		assertEquals(6, SumDigitsInNumber.sumDigitsInNumber(-123));
	}

}
