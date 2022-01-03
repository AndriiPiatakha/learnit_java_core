package com.itbulls.learnit.javacore.dao.hw.solution.dto.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.dto.ProductDto;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Product;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.impl.DefaultProduct;

public class ProductDtoToProductConverter {
	
	private CategoryDtoToCategoryConverter categoryConverter;
	
	{
		categoryConverter = new CategoryDtoToCategoryConverter();
	}
	

	public List<Product> convertProductDtosToProducts(List<ProductDto> productDtos) {
		List<Product> products = new ArrayList<>();
		
		for (ProductDto productDto : productDtos) {
			products.add(convertProductDtoToProduct(productDto));
		}
		
		return products;
	}

	public Product convertProductDtoToProduct(ProductDto productDto) {
		Product product = new DefaultProduct();
		product.setId(productDto.getId());
		product.setPrice(productDto.getPrice().doubleValue());
		product.setProductName(productDto.getProductName());
		if (productDto.getCategoryDto() != null)
			product.setCategoryName(productDto.getCategoryDto().getCategoryName());
		
		return product;
	}

	public List<ProductDto> convertProductsToProductDtos(List<Product> products) {
		List<ProductDto> productDtos = new ArrayList<>();
		
		for (Product product : products) {
			productDtos.add(convertProductToProductDto(product));
		}
		
		return productDtos;
	}

	private ProductDto convertProductToProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setPrice(BigDecimal.valueOf(product.getPrice()));
		productDto.setCategoryDto(categoryConverter.convertCategoryNameToCategoryDtoWithOnlyName(product.getCategoryName()));
		productDto.setProductName(product.getProductName());
		return productDto;
	}

}
