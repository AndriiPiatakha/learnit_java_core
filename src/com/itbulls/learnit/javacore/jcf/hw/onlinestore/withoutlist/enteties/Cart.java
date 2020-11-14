package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.enteties;

public interface Cart {

	boolean isEmpty();

	void addProduct(Product productById);

	Product[] getProducts();

	void clear();

}
