package com.itbulls.learnit.javacore.dao.hw.solution.dao;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.dto.ProductDto;

public interface ProductDao {
	
	List<ProductDto> getProducts();

	ProductDto getProductById(int productId);
	
}
