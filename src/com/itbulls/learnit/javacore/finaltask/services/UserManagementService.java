package com.itbulls.learnit.javacore.finaltask.services;

import java.util.List;

import com.itbulls.learnit.javacore.finaltask.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	List<User> getUsers();

	User getUserByEmail(String userEmail);

}
