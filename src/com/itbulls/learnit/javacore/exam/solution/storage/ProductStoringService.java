package com.itbulls.learnit.javacore.exam.solution.storage;

import java.util.List;

import com.itbulls.learnit.javacore.exam.solution.enteties.Product;

public interface ProductStoringService {
	
	List<Product> loadProducts();

}
