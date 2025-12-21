package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example2;

public class ChatDemo {

    public static void main(String[] args) {
        ChatMediator mediator = new ChatRoomMediator();

        ChatUser alice = new ChatUser("Alice", mediator);
        ChatUser bob = new ChatUser("Bob", mediator);
        ChatUser charlie = new ChatUser("Charlie", mediator);

        alice.send("Hi everyone!");
        bob.send("Hello Alice!");
        charlie.send("Welcome!");
    }
}
