package com.itbulls.learnit.javacore.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.itbulls.learnit.javacore.dao.RoleDao;
import com.itbulls.learnit.javacore.dao.UserDao;
import com.itbulls.learnit.javacore.dao.dto.UserDto;
import com.itbulls.learnit.javacore.jdbc.DBUtils;

public class MySqlJdbcUserDao implements UserDao {
	
	private RoleDao roleDao;
	
	{
		roleDao = new MySqlJdbcRoleDao();
	}

	@Override
	public UserDto getUserById(int id) {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM user WHERE id = ?")) {
			
			ps.setInt(1, id);
			try (var rs = ps.executeQuery()) {
				if (rs.next()) {
					UserDto user = new UserDto();
					user.setId(rs.getInt("id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setRole(roleDao.getRoleById(rs.getInt("fk_user_role")));
					user.setMoney(rs.getBigDecimal("money"));
					user.setCreditCard(rs.getString("credit_card"));
					return user;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getUserByEmail(String email) {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM user WHERE email = ?")) {
			
			ps.setString(1, email);
			try (var rs = ps.executeQuery()) {
				if (rs.next()) {
					UserDto user = new UserDto();
					user.setId(rs.getInt("id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setRole(roleDao.getRoleById(rs.getInt("fk_user_role")));
					user.setMoney(rs.getBigDecimal("money"));
					user.setCreditCard(rs.getString("credit_card"));
					return user;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveUser(UserDto user) {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("INSERT INTO user (first_name, last_name, email, fk_user_role, "
						+ "money, credit_card) VALUES (?, ?, ?, ?, ?, ?);")) {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			if (user.getRole() != null) {
				ps.setInt(4, user.getRole().getId());
			} else {
				ps.setNull(4, java.sql.Types.NULL);
			}
			ps.setBigDecimal(5, user.getMoney());
			ps.setString(6, user.getCreditCard());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
