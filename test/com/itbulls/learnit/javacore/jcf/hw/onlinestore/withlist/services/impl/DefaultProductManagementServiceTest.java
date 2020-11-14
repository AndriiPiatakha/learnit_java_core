package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.services.impl;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.Product;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.services.ProductManagementService;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.services.impl.DefaultProductManagementService;


public class DefaultProductManagementServiceTest {
	
	private ProductManagementService testInstance;
	
	@Before
	public void setUp() {
		testInstance = DefaultProductManagementService.getInstance();
	}
	
	@Test
	public void shouldFindProductById() {
		Product product = testInstance.getProducts().get(0);
		
		assertSame(product, testInstance.getProductById(product.getId()));
	}

}
