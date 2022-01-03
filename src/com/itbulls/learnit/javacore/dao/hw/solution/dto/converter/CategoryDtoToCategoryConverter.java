package com.itbulls.learnit.javacore.dao.hw.solution.dto.converter;

import com.itbulls.learnit.javacore.dao.hw.solution.dto.CategoryDto;

public class CategoryDtoToCategoryConverter {

	public CategoryDto convertCategoryNameToCategoryDtoWithOnlyName(String categoryName) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryName(categoryName);
		return categoryDto;
	}

}
