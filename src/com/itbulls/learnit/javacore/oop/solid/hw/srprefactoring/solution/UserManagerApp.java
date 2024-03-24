package com.itbulls.learnit.javacore.oop.solid.hw.srprefactoring.solution;

/*

UserValidator Class:
This class is responsible for validating user input, specifically the username and password.
It contains two static methods, validateUsername and validatePassword, which check if the provided username and password meet certain criteria, such as length and character requirements.
Separating the validation logic into its own class promotes reusability and ensures that validation rules are applied consistently throughout the application.

UserRegistration Class:
This class handles the responsibility of registering users.
The registerUser method takes a username and password as input, validates them using the UserValidator class, and registers the user if the input passes validation.
If the input fails validation, the method returns false, indicating that the registration process failed.
By separating user registration logic into its own class, we isolate this functionality and make it easier to understand and maintain.

UserAuthenticator Class:
This class is responsible for authenticating users.
The authenticateUser method takes a username and password as input and verifies them against predefined credentials (simulated in this example).
If the provided username and password match the predefined credentials, the method returns true, indicating successful authentication.
Otherwise, it returns false, indicating that the authentication process failed.
Separating authentication logic into its own class allows for better organization and encapsulation of this functionality.

UserManagerApp Class (Main Class):
This class contains the main method and serves as the entry point for the application.
It demonstrates how to use the UserRegistration and UserAuthenticator classes to register and authenticate users.
In the main method, a username and password are provided, and the registerUser method is called to register the user.
Subsequently, the authenticateUser method is called to authenticate the user based on the provided credentials.

By separating the application logic from the core functionalities of user registration and authentication, this class promotes a modular and maintainable codebase.
Overall, by adhering to the Single Responsibility Principle (SRP) and separating distinct responsibilities into separate classes, the solution enhances modularity, readability, and maintainability of the code. Each class has a clear and single purpose, making the codebase easier to understand, test, and extend.

*/

public class UserManagerApp {
    public static void main(String[] args) {
        String username = "john_doe";
        String password = "Password123";

        if (UserRegistration.registerUser(username, password)) {
            System.out.println("User registered successfully.");
        } else {
            System.out.println("User registration failed.");
        }

        // Separate login functionality
        if (UserAuthenticator.authenticateUser(username, password)) {
            System.out.println("User logged in successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}