package com.itbulls.learnit.javacore.dao.hw.solution.services.impl;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.dao.UserDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dao.impl.MySqlJdbcUserDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dto.UserDto;
import com.itbulls.learnit.javacore.dao.hw.solution.dto.converter.UserDtoToUserConverter;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.User;
import com.itbulls.learnit.javacore.dao.hw.solution.services.UserManagementService;
import com.itbulls.learnit.javacore.dao.hw.solution.utils.mail.MailSender;
import com.itbulls.learnit.javacore.dao.hw.solution.utils.mail.impl.DefaultMailSender;

public class MySqlUserManagementService implements UserManagementService {

	public static final String SUCCESSFULL_REGISTRATION_MESSAGE = "User is registered!";
	private static final String REGISTRATION_ERROR_MESSAGE = "The email is already in use by other user.";
	
	private UserDao userDao;
	private UserDtoToUserConverter userConverter;
	
	private MailSender mailSender;

	{
		userDao = new MySqlJdbcUserDao();
		userConverter = new UserDtoToUserConverter();
		mailSender = DefaultMailSender.getInstance();
	}
	
	@Override
	public String registerUser(User user) {
		boolean isCreated = userDao.saveUser(userConverter.convertUserToUserDto(user));
		
		if (isCreated) {
			return SUCCESSFULL_REGISTRATION_MESSAGE;
		} else {
			return REGISTRATION_ERROR_MESSAGE;
		}
	}

	@Override
	public List<User> getUsers() {
		List<UserDto> userDtos = userDao.getUsers();
		return userConverter.convertUserDtosToUsers(userDtos);
	}

	@Override
	public User getUserByEmail(String userEmail) {
		UserDto userDto = userDao.getUserByEmail(userEmail);
		return userConverter.convertUserDtoToUser(userDto);
	}

	@Override
	public void resetPasswordForUser(User user) {
		mailSender.sendEmail(user.getEmail(), "Please, use this password to login: " + user.getPassword());
	}

}
