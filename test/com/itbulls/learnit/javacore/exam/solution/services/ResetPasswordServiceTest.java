package com.itbulls.learnit.javacore.exam.solution.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.itbulls.learnit.javacore.exam.solution.enteties.User;
import com.itbulls.learnit.javacore.exam.solution.enteties.impl.DefaultUser;
import com.itbulls.learnit.javacore.exam.solution.services.impl.DefaultResetPasswordService;
import com.itbulls.learnit.javacore.exam.solution.utils.mail.MailSender;

@ExtendWith(MockitoExtension.class)
public class ResetPasswordServiceTest {
	
	
	@InjectMocks
	private ResetPasswordService resetPasswordService = new DefaultResetPasswordService();
	
	@Mock
	private MailSender mailSenderMock;

	@Captor
	private ArgumentCaptor<String> captor;
	
	@Test
	void shouldSendToUserEmail() {
		User user = new DefaultUser();
		String userEmail = "testemail@email.com";
		user.setEmail(userEmail);
		
		resetPasswordService.resetPasswordForUser(user);
		
		verify(mailSenderMock).sendEmail(captor.capture(), anyString());
		assertEquals(captor.getValue(), userEmail);
	}
	
	@Test
	void shouldSendPasswordInfo() {
		User user = new DefaultUser();
		String userPass = "pass";
		user.setPassword(userPass);
		
		resetPasswordService.resetPasswordForUser(user);
		
		verify(mailSenderMock).sendEmail(any(), captor.capture());
		assertTrue(captor.getValue().split(":")[1].trim().equals(userPass));
	}

}
