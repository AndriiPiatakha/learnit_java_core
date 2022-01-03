package com.itbulls.learnit.javacore.dao.hw.solution.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.dao.CategoryDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dao.ProductDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dto.ProductDto;
import com.itbulls.learnit.javacore.dao.hw.solution.utils.db.DBUtils;

public class MySqlJdbcProductDao implements ProductDao {
	
	private CategoryDao categoryDao;
	
	{
		categoryDao = new MySqlJdbcCategoryDao();
	}

	@Override
	public List<ProductDto> getProducts() {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM product");
				var rs = ps.executeQuery()) {
			List<ProductDto> products = new ArrayList<>();
			
			while (rs.next()) {
				ProductDto product = new ProductDto();
				product.setId(rs.getInt("id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setCategoryDto(categoryDao.getCategoryByCategoryId(rs.getInt("category_id")));
				products.add(product);
			}
			
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductDto getProductById(int productId) {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM product WHERE id = ?")) {
			
			ps.setInt(1, productId);
			try (var rs = ps.executeQuery()) {
				
				if (rs.next()) {
					ProductDto product = new ProductDto();
					product.setId(rs.getInt("id"));
					product.setProductName(rs.getString("product_name"));
					product.setPrice(rs.getBigDecimal("price"));
					product.setCategoryDto(categoryDao.getCategoryByCategoryId(rs.getInt("category_id")));
					return product;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	
}
