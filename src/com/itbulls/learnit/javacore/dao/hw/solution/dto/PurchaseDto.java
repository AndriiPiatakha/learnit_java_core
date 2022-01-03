package com.itbulls.learnit.javacore.dao.hw.solution.dto;

import java.util.List;

public class PurchaseDto {
	
	private Integer id;
	private UserDto userDto;
	private List<ProductDto> productDtos;
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public List<ProductDto> getProductDtos() {
		return productDtos;
	}
	public void setProductDtos(List<ProductDto> productDtos) {
		this.productDtos = productDtos;
	}

	

}
