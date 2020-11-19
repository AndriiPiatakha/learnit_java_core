package com.itbulls.learnit.javacore.jcf.collections.list.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class ListIteratorTest {
	
	private DefaultMyList testInstance;
	private ListIterator testListIterator;
	
	@Before
	public void setUp() {
		DefaultMyList testList = new DefaultMyList();
		testList.add(1);
		testList.add(2);
		testList.add(30);
		testList.add(4);
		testList.add(5);
		
		testInstance = testList;
		testListIterator = testInstance.listIterator();
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionWhenSetMethodInvokedWithoutNextOrPrevious() {
		testListIterator.set(1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionWhenRemoveMethodInvokedWithoutNextOrPrevious() {
		testListIterator.remove();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void shouldThrowExcpetionWhenNoElement() {
		while (true) {
			testListIterator.next();
		}
	}
	
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowExcpetionWhenRemoveIsCalledTwoTimesInARow() {
		testListIterator.next();
		testListIterator.next();
		testListIterator.remove();
		testListIterator.remove();
	}
	
	@Test
	public void shouldReturnFalseWhenHasNextCalledAndNoElements() {
		while (testListIterator.hasNext()) {
			testListIterator.next();
		}
		assertFalse(testListIterator.hasNext());
	}
	
	@Test
	public void shouldReturnTrueWhenHasNextCalledAndThereAreElements() {
		assertTrue(testListIterator.hasNext());
	}
	
	@Test
	public void shouldReturnTheNextElement() {
		testListIterator.next();
		testListIterator.next();
		assertEquals("30", testListIterator.next().toString());
	}
	
	@Test
	public void shouldRemoveElementAfterNext() {
		testListIterator.next();
		testListIterator.next();
		testListIterator.next();
		testListIterator.remove();
		assertFalse(testInstance.contains(30));
	}
	
	@Test
	public void shouldBeInstanceOfListIterable() {
		assertTrue(testInstance instanceof ListIterable);
	}
	
	@Test
	public void shouldReturnPreviousElement() {
		testListIterator.next();
		assertEquals("1", testListIterator.previous().toString());
	}
	
	@Test
	public void shouldRemoveAfterPrevious() {
		testListIterator.next();
		testListIterator.previous();
		testListIterator.remove();
		assertFalse(testInstance.contains(1));
	}
	
	@Test
	public void shouldSetNewElement() {
		testListIterator.next();
		testListIterator.set(10);
		assertEquals("10", testListIterator.previous().toString());
	}
	
	@Test
	public void shouldReturnTrueWhenHasPreviousIsCalledAndThereIsElement() {
		testListIterator.next();
		assertTrue(testListIterator.hasPrevious());
	}
	
	@Test
	public void shouldReturnFalseWhenHasPreviousIsCalledAndThereIsNoElement() {
		assertFalse(testListIterator.hasPrevious());
	}

}
