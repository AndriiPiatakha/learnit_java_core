package com.itbulls.learnit.javacore.exam.solution.services.impl;

import com.itbulls.learnit.javacore.exam.solution.enteties.User;
import com.itbulls.learnit.javacore.exam.solution.services.ResetPasswordService;
import com.itbulls.learnit.javacore.exam.solution.utils.mail.MailSender;

public class DefaultResetPasswordService implements ResetPasswordService {
	
	private MailSender mailSender;

	@Override
	public void resetPasswordForUser(User user) {
		System.out.println("Your password has been sent to your email. Check your inbox.");
		mailSender.sendEmail(user.getEmail(), "Please, use this password to login: " + user.getPassword());
	}

}
