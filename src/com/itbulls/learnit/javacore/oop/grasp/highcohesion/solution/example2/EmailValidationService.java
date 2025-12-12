package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example2;

public class EmailValidationService {

    public boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}
