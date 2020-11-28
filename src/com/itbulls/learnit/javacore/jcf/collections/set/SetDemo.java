package com.itbulls.learnit.javacore.jcf.collections.set;

import java.util.HashSet;
import java.util.Set;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.User;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.impl.DefaultUser;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.impl.UserForHashTables;

public class SetDemo {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		System.out.println("Add 1: " + set.add(1));
		System.out.println("Add 1: " + set.add(1));
		System.out.println("Add 2: " + set.add(2));
		System.out.println("Add 3: " + set.add(3));
		System.out.println(set);
		
		System.out.println("============ DEMO - objects without hashCode and equals overriden are added to the Set");
		Set<User> users = new HashSet<>();
		User user1 = 
				new DefaultUser(1, "John", "Smith", "password", "john@email.com");
		
		User user2 = 
				new DefaultUser(1, "John", "Smith", "password", "john@email.com");
		
		users.add(user1);
		users.add(user2);
		for (User user : users) {
			System.out.println(user);
		}
		
		System.out.println("============ DEMO - objects with hashCode and equals overriden aren't added to the Set");
		User user3 = 
				new UserForHashTables(2, "William", "Smith", 
						"password", "john@email.com");
		
		User user4 = 
				new UserForHashTables(2, "William", "Smith", 
						"password", "john@email.com");
		
		users.add(user3);
		users.add(user4);
		for (User user : users) {
			System.out.println(user);
		}
		
		
		
	}

}
