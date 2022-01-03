package com.itbulls.learnit.javacore.dao.hw.solution.storage;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Product;

public interface ProductStoringService {
	
	List<Product> loadProducts();

}
