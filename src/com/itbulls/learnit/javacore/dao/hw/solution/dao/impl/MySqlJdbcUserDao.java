package com.itbulls.learnit.javacore.dao.hw.solution.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.dao.RoleDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dao.UserDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dto.UserDto;
import com.itbulls.learnit.javacore.dao.hw.solution.utils.db.DBUtils;

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
					user.setRoleDto(roleDao.getRoleById(rs.getInt("fk_user_role")));
					user.setMoney(rs.getBigDecimal("money"));
					user.setCreditCard(rs.getString("credit_card"));
					user.setPassword(rs.getString("password"));
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
					user.setRoleDto(roleDao.getRoleById(rs.getInt("fk_user_role")));
					user.setMoney(rs.getBigDecimal("money"));
					user.setCreditCard(rs.getString("credit_card"));
					user.setPassword(rs.getString("password"));
					return user;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean saveUser(UserDto user) {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("INSERT INTO user (first_name, last_name, email, fk_user_role, "
						+ "money, credit_card, password) VALUES (?, ?, ?, ?, ?, ?, ?);")) {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			if (user.getRoleDto() != null && user.getRoleDto().getId() != null) {
				ps.setInt(4, user.getRoleDto().getId());
			} else {
				ps.setNull(4, java.sql.Types.NULL);
			}
			ps.setBigDecimal(5, user.getMoney());
			ps.setString(6, user.getCreditCard());
			ps.setString(7, user.getPassword());
			
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}



	@Override
	public List<UserDto> getUsers() {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM user");
				var rs = ps.executeQuery()) {
			List<UserDto> users = new ArrayList<>();
			
			while (rs.next()) {
				UserDto user = new UserDto();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setRoleDto(roleDao.getRoleById(rs.getInt("fk_user_role")));
				user.setMoney(rs.getBigDecimal("money"));
				user.setCreditCard(rs.getString("credit_card"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
