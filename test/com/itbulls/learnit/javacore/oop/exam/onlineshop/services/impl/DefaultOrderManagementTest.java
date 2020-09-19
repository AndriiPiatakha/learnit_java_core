package com.itbulls.learnit.javacore.oop.exam.onlineshop.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Order;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.impl.DefaultOrder;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.OrderManagementService;

public class DefaultOrderManagementTest {

	private static final int TEST_CUSTOMER_ID = 1;
	private static final int MORE_THAN_TEN = 20;
	private OrderManagementService testInstance;

	@Before
	public void setUp() {
		testInstance = DefaultOrderManagementService.getInstance();
		((DefaultOrderManagementService) testInstance).clearServiceState();
	}

	@Test
	public void shouldAddOrder() {
		Order order = new DefaultOrder();

		testInstance.addOrder(order);

		assertEquals(1, testInstance.getOrders().length);
	}

	@Test
	public void shouldNotAddOrderIfOrderIsNull() {
		testInstance.addOrder(null);

		assertEquals(0, testInstance.getOrders().length);
	}

	@Test
	public void shouldAddMoreThanTenOrders() {
		Order order = new DefaultOrder();

		for (int i = 0; i < MORE_THAN_TEN; i++) {
			testInstance.addOrder(order);
		}

		assertEquals(MORE_THAN_TEN, testInstance.getOrders().length);
	}

	@Test
	public void shouldRetrieveOrdersByCustomerId() {
		Order order = new DefaultOrder();
		order.setCustomerId(TEST_CUSTOMER_ID);
		
		testInstance.addOrder(order);

		assertSame(order, testInstance.getOrdersByUserId(1)[0]);
	}
}
