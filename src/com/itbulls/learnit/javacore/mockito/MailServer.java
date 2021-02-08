package com.itbulls.learnit.javacore.mockito;

public class MailServer {
	
	private Validator emailValidator;

	public void send(Email email) {
		emailValidator.validate(email);
		// sending an email to an addressee
	}

	public Validator getValidator() {
		return this.emailValidator;
	}

}
