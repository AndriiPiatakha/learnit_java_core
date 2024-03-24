package com.itbulls.learnit.javacore.oop.solid.hw.srprefactoring.solution;

public class UserValidator {
    public static boolean validateUsername(String username) {
        // Validate username (e.g., length, characters allowed)
        return username.length() >= 5 && username.matches("[a-zA-Z_0-9]+");
    }

    public static boolean validatePassword(String password) {
        // Validate password (e.g., length, complexity)
        return password.length() >= 8 && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    }
}
