package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example2;

public interface ChatParticipant {
    String name();
    void receive(String from, String message);
}