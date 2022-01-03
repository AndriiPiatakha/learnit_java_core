package com.itbulls.learnit.javacore.dao.hw.template.enteties.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.template.enteties.Cart;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.Product;

public class DefaultCart implements Cart {

	private List<Product> products;
	
	{
		products = new ArrayList<>();
	}
	
	@Override
	public boolean isEmpty() {
		return products.isEmpty();
	}

	@Override
	public void addProduct(Product product) {
		if (product == null) {
			return;
		}
		products.add(product);
	}

	@Override
	public List<Product> getProducts() {
//		return Collections.unmodifiableList(this.products); // returns unmodifiable List
		return this.products;
	}

	@Override
	public void clear() {
		products.clear();
	}

}
