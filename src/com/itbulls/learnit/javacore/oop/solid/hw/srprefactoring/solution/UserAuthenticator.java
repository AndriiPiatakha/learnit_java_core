package com.itbulls.learnit.javacore.oop.solid.hw.srprefactoring.solution;

public class UserAuthenticator {
    public static boolean authenticateUser(String username, String password) {
        return UserValidator.validateUsername(username) && UserValidator.validatePassword(password);
    }
}