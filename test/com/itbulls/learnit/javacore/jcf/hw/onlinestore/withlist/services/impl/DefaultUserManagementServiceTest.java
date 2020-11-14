package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.User;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.impl.DefaultUser;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.services.UserManagementService;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.services.impl.DefaultUserManagementService;


public class DefaultUserManagementServiceTest {

	private static final String EMPTY_EMAIL = "";
	private static final String TEST_EMAIL = "test@email.com";
	private static final int MORE_THAN_TEN = 20;
	private UserManagementService testInstance;
	
	@Before
	public void setUp() {
		testInstance = DefaultUserManagementService.getInstance();
		((DefaultUserManagementService)testInstance).clearServiceState();
	}
	
	@Test
	public void shouldRegisterUser() {
		User user = new DefaultUser();
		user.setEmail(TEST_EMAIL);
		
		testInstance.registerUser(user);
		
		assertEquals(1, testInstance.getUsers().size());
	}
	
	@Test
	public void shouldNotRegisterIfEmailIsEmpty() {
		User user = new DefaultUser();
		user.setEmail(EMPTY_EMAIL);
		
		testInstance.registerUser(user);
		
		assertEquals(0, testInstance.getUsers().size());
	}
	
	@Test
	public void shouldNotRegisterIfEmailIsNull() {
		User user = new DefaultUser();
		
		testInstance.registerUser(user);
		
		assertEquals(0, testInstance.getUsers().size());
	}
	
	@Test
	public void shouldNotRegisterUserWithNonUniqueEmail() {
		User user1 = new DefaultUser();
		User user2WithTheSameEmail = new DefaultUser();
		
		user1.setEmail(TEST_EMAIL);
		user2WithTheSameEmail.setEmail(TEST_EMAIL);
		
		testInstance.registerUser(user1);
		testInstance.registerUser(user2WithTheSameEmail);
		
		assertEquals(1, testInstance.getUsers().size());
	}
	
	@Test
	public void shouldNotRegisterUserIfUserIsNull() {
		testInstance.registerUser(null);
		
		assertEquals(0, testInstance.getUsers().size());
	}
	
	@Test
	public void shouldRegisterMoreThanTenUsers() {
		for (int i = 0; i < MORE_THAN_TEN; i++) {
			User user = new DefaultUser();
			user.setEmail(TEST_EMAIL + i);
			testInstance.registerUser(user);
		}
		
		assertEquals(MORE_THAN_TEN, testInstance.getUsers().size());
	}
	
	@Test
	public void getUserByEmail() {
		User user = new DefaultUser();
		user.setEmail(TEST_EMAIL);
		
		testInstance.registerUser(user);
		
		assertSame(user, testInstance.getUserByEmail(TEST_EMAIL));
	}
	
}
