package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    private final Map<String, User> storage = new HashMap<>();

    public Optional<User> findByEmail(String email) {
        return storage.values()
                .stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public void save(User user) {
        storage.put(user.getId(), user);
    }
}