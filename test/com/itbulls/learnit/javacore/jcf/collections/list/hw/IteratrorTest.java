package com.itbulls.learnit.javacore.jcf.collections.list.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class IteratrorTest {

	private MyList testList;

	private Iterator testInstance;

	@Before
	public void setUp() {
		testList = new DefaultMyList();
		testList.add(1);
		testList.add(2);
		testList.add(30);
		testList.add(4);
		testList.add(5);

		testInstance = testList.iterator();
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldThrowExcpetionWhenNoElement() {
		while (true) {
			testInstance.next();
		}
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExcpetionWhenRemoveInvokedAndNextIsNotCalled() {
		testInstance.remove();
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExcpetionWhenRemoveIsCalledTwoTimesInARow() {
		testInstance.next();
		testInstance.next();
		testInstance.remove();
		testInstance.remove();
	}
	
	@Test
	public void shouldReturnFalseWhenHasNextCalledAndNoElements() {
		while (testInstance.hasNext()) {
			testInstance.next();
		}
		assertFalse(testInstance.hasNext());
	}
	
	@Test
	public void shouldReturnTrueWhenHasNextCalledAndThereAreElements() {
		assertTrue(testInstance.hasNext());
	}
	
	@Test
	public void shouldReturnTheNextElement() {
		testInstance.next();
		testInstance.next();
		assertEquals("30", testInstance.next().toString());
	}
	
	@Test
	public void shouldRemoveElement() {
		testInstance.next();
		testInstance.next();
		testInstance.next();
		testInstance.remove();
		assertFalse(testList.contains(30));
	}
	
	

}
