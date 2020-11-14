package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.services;

import java.util.List;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.Product;

public interface ProductManagementService {

	List<Product> getProducts();

	Product getProductById(int productIdToAddToCart);

}
