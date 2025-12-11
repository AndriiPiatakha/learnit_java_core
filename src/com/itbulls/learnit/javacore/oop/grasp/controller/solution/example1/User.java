package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example1;

public class User {

    private final String id;
    private final String email;
    private final String hashedPassword;
    private boolean active;

    public User(String id, String email, String hashedPassword) {
        this.id = id;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.active = false;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        this.active = true;
    }
}