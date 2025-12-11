package com.itbulls.learnit.javacore.oop.grasp.controller.problem.example1;

import java.util.UUID;

//Problem example 1:
//Bloated controller / God class that does far more than it should.

public class UserController {

	private final UserRepository userRepository = new UserRepository();
	private final EmailService emailService = new EmailService();
	private final PasswordHasher passwordHasher = new PasswordHasher();

	// This method simulates an HTTP endpoint: registerUser(request...)
	public void registerUser(String email, String rawPassword, String confirmPassword) {

		// Input validation inside controller
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("Email is required");
		}
		if (!email.contains("@")) {
			throw new IllegalArgumentException("Email is invalid");
		}
		if (rawPassword == null || rawPassword.length() < 8) {
			throw new IllegalArgumentException("Password must be at least 8 characters");
		}
		if (!rawPassword.equals(confirmPassword)) {
			throw new IllegalArgumentException("Passwords do not match");
		}

		// Controller talks directly to repository and applies business rules
		userRepository.findByEmail(email).ifPresent(existing -> {
			throw new IllegalStateException("User with this email already exists");
		});

		String id = UUID.randomUUID().toString();

		// Controller handles hashing logic
		String hashed = passwordHasher.hash(rawPassword);

		User user = new User(id, email, hashed);

		// Controller decides activation rules
		if (email.endsWith("@example.com")) {
			user.activate();
		}

		// Controller persists the user
		userRepository.save(user);

		// Controller sends emails directly
		String subject = "Welcome, " + email;
		String body = "Your account has been created. Your id: " + id;
		emailService.send(email, subject, body);

		// Controller logs / prints outcome
		System.out.println("User registered: " + user.getId() + " active=" + user.isActive());
	}
}
