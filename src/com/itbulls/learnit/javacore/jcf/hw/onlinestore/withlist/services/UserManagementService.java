package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.services;

import java.util.List;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	List<User> getUsers();

	User getUserByEmail(String userEmail);

}
