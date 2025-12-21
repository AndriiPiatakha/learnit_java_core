package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example2;

public interface ChatMediator {
    void register(ChatParticipant participant);
    void send(String from, String message);
}
