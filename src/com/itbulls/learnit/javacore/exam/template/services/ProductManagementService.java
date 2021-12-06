package com.itbulls.learnit.javacore.exam.template.services;

import java.util.List;

import com.itbulls.learnit.javacore.exam.template.enteties.Product;

public interface ProductManagementService {

	List<Product> getProducts();

	Product getProductById(int productIdToAddToCart);

}
