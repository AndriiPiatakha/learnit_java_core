package com.itbulls.learnit.javacore.dao.hw.solution.services.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.User;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.impl.DefaultUser;
import com.itbulls.learnit.javacore.dao.hw.solution.services.UserManagementService;
import com.itbulls.learnit.javacore.dao.hw.solution.utils.mail.MailSender;
import com.itbulls.learnit.javacore.dao.hw.solution.utils.mail.impl.DefaultMailSender;

public class DefaultUserManagementService implements UserManagementService {

	private static final String USER_INFO_STORAGE = "users.csv";
	private static final String CURRENT_TASK_RESOURCE_FOLDER = "finaltask";
	private static final String RESOURCES_FOLDER = "resources";
	private static final int USER_EMAIL_INDEX = 4;
	private static final int USER_PASSWORD_INDEX = 3;
	private static final int USER_LASTNAME_INDEX = 2;
	private static final int USER_FIRSTNAME_INDEX = 1;
	private static final int USER_ID_INDEX = 0;
	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";

	private static DefaultUserManagementService instance;

	private MailSender mailSender;

	{
		mailSender = DefaultMailSender.getInstance();
	}

	private DefaultUserManagementService() {
	}

	@Override
	public String registerUser(User user) {
		if (user == null) {
			return NO_ERROR_MESSAGE;
		}

		String errorMessage = checkUniqueEmail(user.getEmail());
		if (errorMessage != null && !errorMessage.isEmpty()) {
			return errorMessage;
		}

		saveUser(user);
		return NO_ERROR_MESSAGE;
	}

	private String checkUniqueEmail(String email) {
		List<User> users = loadUsers();
		if (email == null || email.isEmpty()) {
			return EMPTY_EMAIL_ERROR_MESSAGE;
		}
		for (User user : users) {
			if (user != null && user.getEmail() != null && user.getEmail().equalsIgnoreCase(email)) {
				return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
			}
		}
		return NO_ERROR_MESSAGE;
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = loadUsers();
		DefaultUser.setCounter(users.stream().mapToInt(user -> user.getId()).max().getAsInt());
		return users;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		for (User user : loadUsers()) {
			if (user != null && user.getEmail().equalsIgnoreCase(userEmail)) {
				return user;
			}
		}
		return null;
	}

	private void saveUser(User user) {
		try {
			Files.writeString(Paths.get(RESOURCES_FOLDER, CURRENT_TASK_RESOURCE_FOLDER, USER_INFO_STORAGE),
					System.lineSeparator() + convertToStorableString(user), StandardCharsets.UTF_8,
					StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String convertToStorableString(User user) {
		return user.getId() + "," + user.getFirstName() + "," + user.getLastName() + "," + user.getPassword() + ","
				+ user.getEmail();
	}

	private List<User> loadUsers() {
		try (var stream = Files.lines(Paths.get(RESOURCES_FOLDER, CURRENT_TASK_RESOURCE_FOLDER, USER_INFO_STORAGE))) {
			return stream.filter(Objects::nonNull).filter(line -> !line.isEmpty()).map(line -> {
				String[] userElements = line.split(",");
				return new DefaultUser(Integer.valueOf(userElements[USER_ID_INDEX]), userElements[USER_FIRSTNAME_INDEX],
						userElements[USER_LASTNAME_INDEX], userElements[USER_PASSWORD_INDEX],
						userElements[USER_EMAIL_INDEX]);
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}

	@Override
	public void resetPasswordForUser(User user) {
		mailSender.sendEmail(user.getEmail(), "Please, use this password to login: " + user.getPassword());
	}

//	// Stream API version of the method
//	@Override
//	public User[] getUsers() {
//		return Arrays.stream(users)
//				.filter(Objects::nonNull)
//				.toArray(User[]::new);
//	}

}
