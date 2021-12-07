package com.itbulls.learnit.javacore.exam.solution.services;

import java.util.List;

import com.itbulls.learnit.javacore.exam.solution.enteties.Product;

public interface ProductManagementService {

	List<Product> getProducts();

	Product getProductById(int productIdToAddToCart);

}
