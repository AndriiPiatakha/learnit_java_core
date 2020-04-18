package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class FilterStringArrayTest {

	@Test
	public void shouldFilterWordsByMinLength() {
		String[] input = { "asd", "asdf", "as", "asdfg", "a" };
		int minLength = 3;

		assertEquals("[asd, asdf, asdfg]",
				Arrays.toString(FilterStringArray.filterWordsByLength(minLength, input)));
	}

	@Test
	public void shouldFilterWordsByMinLength2() {
		String[] input = { "asd", "asdf", "as", "asdfg", "a" };
		int minLength = 2;

		assertEquals("[asd, asdf, as, asdfg]",
				Arrays.toString(FilterStringArray.filterWordsByLength(minLength, input)));
	}

	@Test
	public void shouldFilterWordsByMinLengthStreamApi() {
		String[] input = { "asd", "asdf", "as", "asdfg", "a" };
		int minLength = 3;

		assertEquals("[asd, asdf, asdfg]", Arrays.toString(
				FilterStringArray.filterWordsByLengthStreamApi(minLength, input)));
	}

	@Test
	public void shouldFilterWordsByMinLength2StreamApi() {
		String[] input = { "asd", "asdf", "as", "asdfg", "a" };
		int minLength = 2;

		assertEquals("[asd, asdf, as, asdfg]", Arrays.toString(
				FilterStringArray.filterWordsByLengthStreamApi(minLength, input)));
	}

}
