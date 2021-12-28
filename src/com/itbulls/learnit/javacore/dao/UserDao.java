package com.itbulls.learnit.javacore.dao;

import com.itbulls.learnit.javacore.dao.dto.UserDto;

public interface UserDao {
	
	UserDto getUserById(int id); 
	UserDto getUserByEmail(String email);
	void saveUser(UserDto user);

}
