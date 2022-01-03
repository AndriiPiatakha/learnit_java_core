package com.itbulls.learnit.javacore.dao.hw.solution.services.impl;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.dao.ProductDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dao.impl.MySqlJdbcProductDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dto.ProductDto;
import com.itbulls.learnit.javacore.dao.hw.solution.dto.converter.ProductDtoToProductConverter;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Product;
import com.itbulls.learnit.javacore.dao.hw.solution.services.ProductManagementService;

public class MySqlProductManagementService implements ProductManagementService {

	private ProductDao productDao;
	private ProductDtoToProductConverter productConverter;
	
	{
		productDao = new MySqlJdbcProductDao();
		productConverter = new ProductDtoToProductConverter();
	}
	
	@Override
	public List<Product> getProducts() {
		List<ProductDto> productDtos = productDao.getProducts();
		return productConverter.convertProductDtosToProducts(productDtos);
	}

	@Override
	public Product getProductById(int id) {
		ProductDto productDto = productDao.getProductById(id);
		return productConverter.convertProductDtoToProduct(productDto);
	}

}
