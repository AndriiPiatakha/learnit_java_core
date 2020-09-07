package com.itbulls.learnit.javacore.oop.solid.s.solution;

import com.itbulls.learnit.javacore.oop.solid.s.problem.Role;
import com.itbulls.learnit.javacore.oop.solid.s.problem.User;

public class SecurityService {
	
	public boolean hasAccess(User user) {
		if (user.getRole() == Role.ADMIN) {
			return true;
		} else {
			return false;
		}
	}

}
