package com.itbulls.learnit.javacore.oop.hw.present;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PresentTest {

	private static final double WEIGHT_3 = 0.5;
	private static final double WEIGHT_2 = 0.2;
	private static final double WEIGHT_1 = 0.05;
	private static final double MORE_THAN_MAX_THRESHOLD_SUGAR_WEIGHT = 0.53;
	private static final double LESS_THAN_MAX_THRESHOLD_SUGAR_WEIGHT = 0.1;
	private static final double TEST_MAX_THRESHOLD_SUGAR_WEIGHT = 0.2;
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
		candy.setSugarWeight(MORE_THAN_MAX_THRESHOLD_SUGAR_WEIGHT);
		candy.setWeight(WEIGHT_1);
		
		Cookie cookie = new Oreo();
		cookie.setName("Milk Oreo");
		cookie.setSugarWeight(LESS_THAN_MAX_THRESHOLD_SUGAR_WEIGHT);
		cookie.setDoughWeight(0.3);
		cookie.setWeight(WEIGHT_2);
		
		Sweet lollipop = new Lollipop();
		lollipop.setWeight(WEIGHT_3);
		lollipop.setName("Lollipop");
		lollipop.setSugarWeight(TEST_MAX_THRESHOLD_SUGAR_WEIGHT);
		
		testInstance.addSweet(candy);
		testInstance.addSweet(cookie);
		testInstance.addSweet(lollipop);
		
		assertEquals(0.75, testInstance.calculateTotalWeight(), 0.01);
	}
	
	@Test
	public void shouldFilterSweetsBySugarRange() {
		Sweet candy = new ChocolateCandy();
		candy.setName("Ritter Sport");
		candy.setSugarWeight(MORE_THAN_MAX_THRESHOLD_SUGAR_WEIGHT);
		candy.setWeight(WEIGHT_1);
		
		Cookie cookie = new Oreo();
		cookie.setName("Milk Oreo");
		cookie.setSugarWeight(LESS_THAN_MAX_THRESHOLD_SUGAR_WEIGHT);
		cookie.setDoughWeight(0.3);
		cookie.setWeight(WEIGHT_2);
		
		Sweet lollipop = new Lollipop();
		lollipop.setWeight(WEIGHT_3);
		lollipop.setName("Lollipop");
		lollipop.setSugarWeight(TEST_MAX_THRESHOLD_SUGAR_WEIGHT);
		
		testInstance.addSweet(candy);
		testInstance.addSweet(cookie);
		testInstance.addSweet(lollipop);
		
		Sweet[] expectedFilteredArray = new Sweet[] {cookie, lollipop};
		assertArrayEquals(expectedFilteredArray, testInstance.filterSweetsBySugarRange(0, TEST_MAX_THRESHOLD_SUGAR_WEIGHT));
	}
	
	@Test
	public void shouldAddMoreThanTenSweets() {
		Sweet candy = new ChocolateCandy();
		candy.setName("Ritter Sport");
		candy.setSugarWeight(TEST_MAX_THRESHOLD_SUGAR_WEIGHT);
		candy.setWeight(WEIGHT_1);
		
		for (int i = 0; i < MORE_THAN_TEN; i++) {
			testInstance.addSweet(candy);
		}
		
		assertEquals(MORE_THAN_TEN, testInstance.getSweets().length);
	}
	
}
