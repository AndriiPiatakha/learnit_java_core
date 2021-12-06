package com.itbulls.learnit.javacore.exam.template.services;

import java.util.List;

import com.itbulls.learnit.javacore.exam.template.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	List<User> getUsers();

	User getUserByEmail(String userEmail);

}
