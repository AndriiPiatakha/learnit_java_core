package com.itbulls.learnit.javacore.oop.grasp.controller.problem.example1;

public class EmailService {

    public void send(String to, String subject, String body) {
        System.out.println("Sending email to " + to +
                " with subject: " + subject +
                " and body: " + body);
    }
}
