package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Product;

public interface ProductManagementService {

	Product[] getProducts();

	Product getProductById(int productIdToAddToCart);

}
