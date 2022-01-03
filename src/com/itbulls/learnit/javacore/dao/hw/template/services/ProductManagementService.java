package com.itbulls.learnit.javacore.dao.hw.template.services;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.template.enteties.Product;

public interface ProductManagementService {

	List<Product> getProducts();

	Product getProductById(int productIdToAddToCart);

}
