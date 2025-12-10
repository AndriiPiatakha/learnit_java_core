package com.itbulls.learnit.javacore.oop.grasp.creator.solution.example2;

public class EmailSender {

    private final String smtpServer;

    public EmailSender(String smtpServer) {
        this.smtpServer = smtpServer;
    }

    public void send(String email, String subject, String body) {
        // Imagine real email sending here.
        System.out.println("Sending email to " + email +
                " via " + smtpServer + " with subject: " + subject);
    }
}
