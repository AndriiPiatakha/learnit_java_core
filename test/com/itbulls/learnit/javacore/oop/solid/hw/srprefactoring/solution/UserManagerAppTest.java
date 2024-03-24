package com.itbulls.learnit.javacore.oop.solid.hw.srprefactoring.solution;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserManagerAppTest {

	@Test
	public void shouldRegisterUserSuccessfully() {
		assertTrue(UserRegistration.registerUser("john_doe", "Password123"));
	}

	@Test
	public void shouldFailRegistrationForInvalidUsername() {
		assertFalse(UserRegistration.registerUser("joe", "Password123")); // Invalid username
	}

	@Test
	public void shouldFailRegistrationForInvalidPassword() {
		assertFalse(UserRegistration.registerUser("john_doe", "pass")); // Invalid password
	}

	@Test
	public void shouldAuthenticateUserSuccessfully() {
		assertTrue(UserAuthenticator.authenticateUser("john_doe", "Password123"));
	}

	@Test
	public void shouldFailAuthenticationForIncorrectPassword() {
		assertFalse(UserAuthenticator.authenticateUser("john_doe", "password")); // Incorrect password
	}

	@Test
	public void shouldFailAuthenticationForNonExistentUser() {
		assertFalse(UserAuthenticator.authenticateUser("joe", "Password123")); // Non-existent user
	}

}
