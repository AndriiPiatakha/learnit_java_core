package com.itbulls.learnit.javacore.jcf.collections.list.hw.parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class IteratrorTestParameterized {

	private MyListParameterized<Integer> testList;

	private Iterator<Integer> testInstanceIterator;

	@Before
	public void setUp() {
		testList = new DefaultMyListParameterized<>();
		testList.add(1);
		testList.add(2);
		testList.add(30);
		testList.add(4);
		testList.add(5);

		testInstanceIterator = testList.iterator();
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldThrowExcpetionWhenNoElement() {
		while (true) {
			testInstanceIterator.next();
		}
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExcpetionWhenRemoveInvokedAndNextIsNotCalled() {
		testInstanceIterator.remove();
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExcpetionWhenRemoveIsCalledTwoTimesInARow() {
		testInstanceIterator.next();
		testInstanceIterator.next();
		testInstanceIterator.remove();
		testInstanceIterator.remove();
	}
	
	@Test
	public void shouldReturnFalseWhenHasNextCalledAndNoElements() {
		while (testInstanceIterator.hasNext()) {
			testInstanceIterator.next();
		}
		assertFalse(testInstanceIterator.hasNext());
	}
	
	@Test
	public void shouldReturnTrueWhenHasNextCalledAndThereAreElements() {
		assertTrue(testInstanceIterator.hasNext());
	}
	
	@Test
	public void shouldReturnTheNextElement() {
		testInstanceIterator.next();
		testInstanceIterator.next();
		assertEquals("30", testInstanceIterator.next().toString());
	}
	
	@Test
	public void shouldRemoveElement() {
		testInstanceIterator.next();
		testInstanceIterator.next();
		testInstanceIterator.next();
		testInstanceIterator.remove();
		assertFalse(testList.contains(30));
	}
	
	

}
