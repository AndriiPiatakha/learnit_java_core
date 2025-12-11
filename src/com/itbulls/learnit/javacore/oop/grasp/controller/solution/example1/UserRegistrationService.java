package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example1;

public class UserRegistrationService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final EmailService emailService;

    public UserRegistrationService(UserRepository userRepository,
                                   UserFactory userFactory,
                                   EmailService emailService) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
        this.emailService = emailService;
    }

    public User register(String email, String rawPassword) {

        userRepository.findByEmail(email).ifPresent(u -> {
            throw new IllegalStateException("User with this email already exists");
        });

        User user = userFactory.createNewUser(email, rawPassword);

        if (email.endsWith("@example.com")) {
            user.activate();
        }

        userRepository.save(user);

        emailService.send(
                email,
                "Welcome, " + email,
                "Your account has been created. Your id: " + user.getId()
        );

        return user;
    }
}
