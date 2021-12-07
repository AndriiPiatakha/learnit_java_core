package com.itbulls.learnit.javacore.exam.solution.utils.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.itbulls.learnit.javacore.exam.solution.enteties.User;
import com.itbulls.learnit.javacore.exam.solution.enteties.impl.DefaultUser;
import com.itbulls.learnit.javacore.exam.solution.utils.validation.impl.DefaultValidator;

public class ValidatorTest {
	
	private Validator testInstance;
	private User user;
	
	@BeforeEach
	void setUp() {
		testInstance = new DefaultValidator();
	}
	
	@Test
	void shouldValidateFirstNameWithoutAnyNumbersWithLatinCharsOnly() {
		user = new DefaultUser("Sergey", "Ivanov", "password", "email@email.com");
		
		assertTrue(testInstance.isValid(user));
	}
	
	@Test
	void shouldFailValidationFirstNameWithDigits() {
		user = new DefaultUser("Sergey1", "Ivanov", "password", "email@email.com");
		assertFalse(testInstance.isValid(user));
	}
	
	@Test
	void shouldValidateLastNameWithoutAnyNumbersWithLatinCharsOnly() {
		user = new DefaultUser("Sergey", "Ivanov", "password", "email@email.com");
		
		assertTrue(testInstance.isValid(user));
	}
	
	@Test
	void shouldFailValidationLastNameWithDigits() {
		user = new DefaultUser("Sergey", "Ivanov1", "password", "email@email.com");
		assertFalse(testInstance.isValid(user));
	}
	
	@Test
	void shouldValidateEmailWithAtCharacter() {
		user = new DefaultUser("Sergey", "Ivanov", "password", "email@email.com");
		
		assertTrue(testInstance.isValid(user));
	}
	
	@Test
	void shouldFailValidationEmailWithoutAtCharacter() {
		user = new DefaultUser("Sergey", "Ivanov", "password", "email-email.com");

		assertFalse(testInstance.isValid(user));
	}

}
