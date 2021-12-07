package com.itbulls.learnit.javacore.exam.solution.services;

import java.util.List;

import com.itbulls.learnit.javacore.exam.solution.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	List<User> getUsers();

	User getUserByEmail(String userEmail);

}
