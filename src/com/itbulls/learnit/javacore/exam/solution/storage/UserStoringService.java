package com.itbulls.learnit.javacore.exam.solution.storage;

import java.util.List;

import com.itbulls.learnit.javacore.exam.solution.enteties.User;

public interface UserStoringService {
	
	void saveUser(User user);
	
	List<User> loadUsers();
	
}
