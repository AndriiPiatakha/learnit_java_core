package com.itbulls.learnit.javacore.exam.template.storage;

import java.util.List;

import com.itbulls.learnit.javacore.exam.template.enteties.Product;

public interface ProductStoringService {
	
	List<Product> loadProducts();

}
