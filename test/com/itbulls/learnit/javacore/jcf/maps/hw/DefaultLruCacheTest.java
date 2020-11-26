package com.itbulls.learnit.javacore.jcf.maps.hw;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DefaultLruCacheTest {
	
	private DefaultLruCache testInstance;
	
	@Before
	public void setUp() {
		testInstance = new DefaultLruCache();
	}
	
	@Test
	public void shouldWorkAsLruCacheWithLimittedCapacity() {
		testInstance.setCapacity(2);
		testInstance.put(1, 1); // cache is {1=1}
		testInstance.put(2, 2); // cache is {1=1, 2=2}
		assertEquals(1, testInstance.get(1));
		testInstance.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		assertEquals(-1, testInstance.get(2));
		testInstance.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		assertEquals(-1, testInstance.get(1));
		assertEquals(3, testInstance.get(3));
		assertEquals(4, testInstance.get(4));
	}

}
