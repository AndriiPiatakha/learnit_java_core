package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public class Customer {

    private final String id;
    private final String email;
    private final String phone;

    public Customer(String id, String email, String phone) {
        this.id = id;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
