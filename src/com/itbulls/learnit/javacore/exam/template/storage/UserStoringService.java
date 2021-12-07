package com.itbulls.learnit.javacore.exam.template.storage;

import java.util.List;

import com.itbulls.learnit.javacore.exam.template.enteties.User;

public interface UserStoringService {
	
	void saveUser(User user);
	
	List<User> loadUsers();
	
}
