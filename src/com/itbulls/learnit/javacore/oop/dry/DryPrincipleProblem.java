package com.itbulls.learnit.javacore.oop.dry;


// UserValidator class
public class DryPrincipleProblem {
	public boolean validateEmail(String email) {
		if (email == null || email.isEmpty()) {
			return false;
		}
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		return email.matches(emailRegex);
	}

	public boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.isEmpty()) {
			return false;
		}
		String phoneRegex = "^\\+?[0-9. ()-]{7,25}$";
		return phoneNumber.matches(phoneRegex);
	}

	public boolean validateUsername(String username) {
		if (username == null || username.isEmpty()) {
			return false;
		}
		String usernameRegex = "^[a-zA-Z0-9._-]{3,}$";
		return username.matches(usernameRegex);
	}

	public static void main(String[] args) {
		// UserValidator Instance
		var validator = new DryPrincipleProblem();

		System.out.println("Email validation: " + validator.validateEmail("user@example.com"));
		System.out.println("Phone validation: " + validator.validatePhoneNumber("+1234567890"));
		System.out.println("Username validation: " + validator.validateUsername("user_123"));
	}
}
