package com.itbulls.learnit.javacore.dao.hw.template.storage;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.template.enteties.Product;

public interface ProductStoringService {
	
	List<Product> loadProducts();

}
