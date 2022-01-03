package com.itbulls.learnit.javacore.dao.hw.solution.storage;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.User;

public interface UserStoringService {
	
	void saveUser(User user);
	
	List<User> loadUsers();
	
}
