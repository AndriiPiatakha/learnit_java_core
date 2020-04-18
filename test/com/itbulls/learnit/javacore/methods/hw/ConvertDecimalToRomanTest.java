package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConvertDecimalToRomanTest {

	
	@Test
	public void shouldConvertRomanToDecimal1() {
		assertEquals(24, ConvertDecimalToRoman.roman2Decimal("XXIV"));
	}
	
	@Test
	public void shouldConvertRomanToDecimal2() {
		assertEquals(87, ConvertDecimalToRoman.roman2Decimal("LXXXVII"));
	}
	
	@Test
	public void shouldValidateRomanString() {
		assertTrue(ConvertDecimalToRoman.isRomanNumberValid("LXXXVII"));
	}
	
	@Test
	public void shouldNotValidateRomanString() {
		assertFalse(ConvertDecimalToRoman.isRomanNumberValid("LXXXVIIaaa"));
	}
	
	@Test
	public void shouldConvertDecimalToRoman() {
		assertEquals("LXXXVII", ConvertDecimalToRoman.decimal2Roman(87));
	}
	
	@Test
	public void shouldConvertDecimalToRoman2() {
		assertEquals("XXIV", ConvertDecimalToRoman.decimal2Roman(24));
	}
	
	@Test
	public void shouldValidateDecimalNumber() {
		assertTrue(ConvertDecimalToRoman.isDecimalNumberValid(15));
	}
	
	@Test
	public void shouldValidateDecimalNumber2() {
		assertTrue(ConvertDecimalToRoman.isDecimalNumberValid(1));
	}
	
	@Test
	public void shouldValidateDecimalNumber3() {
		assertTrue(ConvertDecimalToRoman.isDecimalNumberValid(100));
	}
	
	@Test
	public void shouldNotValidateDecimalNumber() {
		assertFalse(ConvertDecimalToRoman.isDecimalNumberValid(-15));
	}
	
	@Test
	public void shouldNotValidateDecimalNumber2() {
		assertFalse(ConvertDecimalToRoman.isDecimalNumberValid(0));
	}
	
	@Test
	public void shouldNotValidateDecimalNumber3() {
		assertFalse(ConvertDecimalToRoman.isDecimalNumberValid(101));
	}
}
