package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.problem.example1;

public class EmailService {

    public void sendEmail(String to, String subject, String body) {
        System.out.println("EMAIL to " + to + " subject=" + subject);
    }
}
