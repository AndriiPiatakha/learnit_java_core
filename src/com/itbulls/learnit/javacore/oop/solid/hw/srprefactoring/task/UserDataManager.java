package com.itbulls.learnit.javacore.oop.solid.hw.srprefactoring.task;


/*

In this file you can find violation of Single Responsibility Principle. 
You should refactor this file. 
You can remove this file completely, because it will not be used during the evaluation of the solution.


Exercise Title: Single Responsibility Principle (SRP) Refactoring Exercise

Objective: In this exercise, you will practice applying the Single Responsibility Principle (SRP) to refactor a given codebase. SRP states that a class should have only one reason to change, meaning each class should have a single, well-defined responsibility. You will enhance the modularity, readability, and maintainability of the code by separating distinct responsibilities into separate classes.

Instructions:

Review the Provided Code: Start by examining the original code provided - UserDataManager Class. Identify areas where the code violates the Single Responsibility Principle by having classes responsible for multiple tasks.

Identify Responsibilities: Analyze the code to identify distinct responsibilities or functionalities that can be separated into individual classes. Focus on areas such as user registration, login, data manipulation, or any other distinct tasks.

Refactor the Code: Refactor the code to create separate classes for each identified responsibility (UserValidator, UserRegistration, UserAuthenticator). Ensure that each class has a clear and single purpose, such as user registration, authentication, or data manipulation.

Test Your Solution: There are tests for positive and negative scenarios that should pass. 

Verify Code Quality: Review your refactored code to ensure that it adheres to SRP principles. Verify that each class has a single responsibility and that the code is modular, readable, and maintainable.

Note: For the sake of login and registration we will not use any in-memory or external storage. Feel free to reuse business logic from UserDataManager class as much as possible. The main focus is not on the business logic but on refactoring. 

My solution of this exercise is located here - https://github.com/AndriiPiatakha/learnit_java_core/tree/master/src/com/itbulls/learnit/javacore/oop/solid/hw/srprefactoring

*/


public class UserDataManager {
    private String username;
    private String password;

    public UserDataManager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void registerUser() {
        // Validate username and password
        if (validateUsername(username) && validatePassword(password)) {
            // Register user in the database
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void loginUser() {
        // Validate username and password
        if (validateUsername(username) && validatePassword(password)) {
            // Authenticate user
            System.out.println("User logged in successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private boolean validateUsername(String username) {
        // Validate username (e.g., length, characters allowed)
        return username.length() >= 5 && username.matches("[a-zA-Z_0-9]+");
    }

    private boolean validatePassword(String password) {
        // Validate password (e.g., length, complexity)
        return password.length() >= 8 && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    }

    public static void main(String[] args) {
        UserDataManager userManager = new UserDataManager("john_doe", "Password123");
        userManager.registerUser();
        userManager.loginUser();
    }
}
