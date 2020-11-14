package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.services;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	User[] getUsers();

	User getUserByEmail(String userEmail);

}
