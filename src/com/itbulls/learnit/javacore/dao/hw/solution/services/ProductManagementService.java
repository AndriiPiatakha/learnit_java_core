package com.itbulls.learnit.javacore.dao.hw.solution.services;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Product;

public interface ProductManagementService {

	List<Product> getProducts();

	Product getProductById(int id);
	
}
