package com.itbulls.learnit.javacore.dao.hw.template.enteties;

import java.util.List;

public interface Cart {

	boolean isEmpty();

	void addProduct(Product productById);

	List<Product> getProducts();

	void clear();

}

