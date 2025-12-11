package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example1;

import java.util.UUID;

public class UserFactory {

    private final PasswordHasher passwordHasher;

    public UserFactory(PasswordHasher passwordHasher) {
        this.passwordHasher = passwordHasher;
    }

    public User createNewUser(String email, String rawPassword) {
        String id = UUID.randomUUID().toString();
        String hashed = passwordHasher.hash(rawPassword);
        return new User(id, email, hashed);
    }
}