package com.itbulls.learnit.javacore.dao.hw.solution.dao.impl;

import java.sql.SQLException;

import com.itbulls.learnit.javacore.dao.hw.solution.dao.CategoryDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dto.CategoryDto;
import com.itbulls.learnit.javacore.dao.hw.solution.utils.db.DBUtils;

public class MySqlJdbcCategoryDao implements CategoryDao {

	@Override
	public CategoryDto getCategoryByCategoryId(int id) {
		try (var conn = DBUtils.getConnection(); 
				var ps = conn.prepareStatement("SELECT * FROM category WHERE id = ?")) {
			
			ps.setInt(1, id);
			
			try (var rs = ps.executeQuery()) {
				if (rs.next()) {
					CategoryDto category = new CategoryDto();
					category.setId(rs.getInt("id"));
					category.setCategoryName(rs.getString("category_name"));
					return category;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
