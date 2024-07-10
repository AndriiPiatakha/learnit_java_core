package com.itbulls.learnit.javacore.oop.dry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

// UserValidator class
public class DryPrincipleSolution {

	private static final Map<String, Predicate<String>> VALIDATION_RULES = new HashMap<>();

	static {
		VALIDATION_RULES.put("email", input -> {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			return input.matches(emailRegex);
		});
		VALIDATION_RULES.put("phoneNumber", input -> {
			String phoneRegex = "^\\+?[0-9. ()-]{7,25}$";
			return input.matches(phoneRegex);
		});
		VALIDATION_RULES.put("username", input -> {
			String usernameRegex = "^[a-zA-Z0-9._-]{3,}$";
			return input.matches(usernameRegex);
		});
	}

	public boolean validate(String type, String input) {
		if (input == null || input.isEmpty())
			return false;
		Predicate<String> validationRule = VALIDATION_RULES.get(type);
		if (validationRule != null) {
			return validationRule.test(input);
		}
		throw new IllegalArgumentException("Unknown validation type: " + type);
	}

	public static void main(String[] args) {
		// UserValidator Instance
		var validator = new DryPrincipleSolution();

		System.out.println("Email validation: " + validator.validate("email", "user@example.com"));
		System.out.println("Phone validation: " + validator.validate("phoneNumber", "+1234567890"));
		System.out.println("Username validation: " + validator.validate("username", "user_123"));
	}

}
