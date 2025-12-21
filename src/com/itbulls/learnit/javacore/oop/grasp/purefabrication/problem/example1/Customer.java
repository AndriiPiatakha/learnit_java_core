package com.itbulls.learnit.javacore.oop.grasp.purefabrication.problem.example1;

public class Customer {

    private final String id;
    private final String email;

    public Customer(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}