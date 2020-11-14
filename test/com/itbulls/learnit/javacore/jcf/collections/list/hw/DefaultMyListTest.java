package com.itbulls.learnit.javacore.jcf.collections.list.hw;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DefaultMyListTest {
	
	private MyList testInstance;
	
	@Before
	public void setUp() {
		testInstance = new DefaultMyList();
	}
	
	@Test
	public void shouldAddElement() {
		testInstance.add(1);
		assertEquals(1, testInstance.size());
	}
	
	@Test
	public void shouldClearList() {
		testInstance.add(1);
		testInstance.clear();
		assertEquals(0, testInstance.size());
	}
	
	@Test
	public void shouldRemoveElement() {
		testInstance.add(0);
		testInstance.add(1);
		testInstance.add(0);
		
		testInstance.remove(0);
		
		assertEquals(2, testInstance.size());
	}
	
	@Test
	public void shouldConvertListToArray() {
		testInstance.add(0);
		testInstance.add(1);
		
		Object[] expectedArray = {0, 1};
		Object[] actualArray = testInstance.toArray();
		
		assertTrue(actualArray instanceof Object[]);
		assertArrayEquals(expectedArray, actualArray);
	}
	
	@Test
	public void shouldReturnSize() {
		testInstance.add(0);
		testInstance.add(1);
		
		assertEquals(2, testInstance.size());
	}
	
	@Test
	public void shouldTestIfListContainsElement() {
		testInstance.add(0);
		testInstance.add(1);
		
		assertTrue(testInstance.contains(0));
	}
	
	@Test
	public void shouldTestIfListDoesntContainsElement() {
		testInstance.add(0);
		testInstance.add(1);
		
		assertFalse(testInstance.contains(10));
	}
	
	@Test
	public void shouldTestIfContainsElementsFromAnotherList() {
		testInstance.add(0);
		testInstance.add(1);
		
		MyList newList = new DefaultMyList();
		newList.add(1);
		newList.add(0);
		
		assertTrue(testInstance.containsAll(newList));
	}
	
	@Test
	public void shouldTestIfDoesntContainElementsFromAnotherList() {
		testInstance.add(0);
		testInstance.add(1);
		
		MyList newList = new DefaultMyList();
		newList.add(1);
		newList.add(100);
		
		assertFalse(testInstance.containsAll(newList));
	}

}
