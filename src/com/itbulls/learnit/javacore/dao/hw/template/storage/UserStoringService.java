package com.itbulls.learnit.javacore.dao.hw.template.storage;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.template.enteties.User;

public interface UserStoringService {
	
	void saveUser(User user);
	
	List<User> loadUsers();
	
}
