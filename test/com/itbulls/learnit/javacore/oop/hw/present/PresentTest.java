package com.itbulls.learnit.javacore.oop.hw.present;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PresentTest {

	private static final int MORE_THAN_TEN = 20;
	private Present testInstance;
	
	@Before
	public void setUp() {
		testInstance = new Present();
	}
	
	@Test
	public void shouldNotAddSweetIfSweetIsNull() {
		testInstance.addSweet(null);
		
		assertEquals(0, testInstance.getSweets().length);
	}
	
	@Test
	public void shouldAddSweet() {
		Sweet candy = new ChocolateCandy();
		candy.setName("Ritter Sport");
		
		testInstance.addSweet(candy);
		
		assertEquals(candy, testInstance.getSweets()[0]);
	}
	
	@Test
	public void shouldCalculateWeight() {
		Sweet candy = new ChocolateCandy();
		candy.setName("Ritter Sport");
		candy.setSugarWeight(0.53);
		candy.setWeight(0.05);
		
		Cookie cookie = new Oreo();
		cookie.setName("Milk Oreo");
		cookie.setSugarWeight(0.1);
		cookie.setDoughWeight(0.3);
		cookie.setWeight(0.2);
		
		Sweet lollipop = new Lollipop();
		lollipop.setWeight(0.5);
		lollipop.setName("Lollipop");
		lollipop.setSugarWeight(0.2);
		
		testInstance.addSweet(candy);
		testInstance.addSweet(cookie);
		testInstance.addSweet(lollipop);
		
		assertEquals(0.75, testInstance.calculateTotalWeight(), 0.01);
	}
	
	@Test
	public void shouldFilterSweetsBySugarRange() {
		Sweet candy = new ChocolateCandy();
		candy.setName("Ritter Sport");
		candy.setSugarWeight(0.53);
		candy.setWeight(0.05);
		
		Cookie cookie = new Oreo();
		cookie.setName("Milk Oreo");
		cookie.setSugarWeight(0.1);
		cookie.setDoughWeight(0.3);
		cookie.setWeight(0.2);
		
		Sweet lollipop = new Lollipop();
		lollipop.setWeight(0.5);
		lollipop.setName("Lollipop");
		lollipop.setSugarWeight(0.2);
		
		testInstance.addSweet(candy);
		testInstance.addSweet(cookie);
		testInstance.addSweet(lollipop);
		
		testInstance.filterSweetsBySugarRange(0, 0.20);
		
		Sweet[] expectedFilteredArray = new Sweet[] {cookie, lollipop};
		assertArrayEquals(expectedFilteredArray, testInstance.filterSweetsBySugarRange(0, 0.20));
	}
	
	@Test
	public void shouldAddMoreThanTenSweets() {
		Sweet candy = new ChocolateCandy();
		candy.setName("Ritter Sport");
		candy.setSugarWeight(0.53);
		candy.setWeight(0.05);
		
		for (int i =0; i < MORE_THAN_TEN; i++) {
			testInstance.addSweet(candy);
		}
		
		assertEquals(MORE_THAN_TEN, testInstance.getSweets().length);
	}
	
}
