package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example1;

public class UserController {

    private final InputValidator validator = new InputValidator();
    private final UserRegistrationService registrationService;

    public UserController() {
        UserRepository repo = new UserRepository();
        PasswordHasher hasher = new PasswordHasher();
        UserFactory factory = new UserFactory(hasher);
        EmailService emailService = new EmailService();

        this.registrationService =
                new UserRegistrationService(repo, factory, emailService);
    }

    public void registerUser(String email, String rawPassword, String confirmPassword) {

        validator.validateRegistration(email, rawPassword, confirmPassword);

        User user = registrationService.register(email, rawPassword);

        System.out.println("User registered: " + user.getId() +
                " active=" + user.isActive());
    }
}
