package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties;

import java.util.List;

public interface Cart {

	boolean isEmpty();

	void addProduct(Product productById);

	List<Product> getProducts();

	void clear();

}

