package com.itbulls.learnit.javacore.dao.hw.template.services.impl;

import com.itbulls.learnit.javacore.dao.hw.template.enteties.User;
import com.itbulls.learnit.javacore.dao.hw.template.services.ResetPasswordService;
import com.itbulls.learnit.javacore.dao.hw.template.utils.mail.MailSender;

public class DefaultResetPasswordService implements ResetPasswordService {
	
	private MailSender mailSender;
	
	{
		mailSender = DefaultMailSender.getInstance();
	}

	@Override
	public void resetPasswordForUser(User user) {
		mailSender.sendEmail(user.getEmail(), "Please, use this password to login: " + user.getPassword());
	}

}
