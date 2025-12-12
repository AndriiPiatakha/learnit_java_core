package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example1;

public class EmailSender {

    public void send(String to, String subject, String body) {
        System.out.println("EMAIL to " + to + " | " + subject + " | " + body);
    }
}
