package com.itbulls.learnit.javacore.dao.hw.solution.dto;

public class CategoryDto {

	private Integer id;
	private String categoryName;
	
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
