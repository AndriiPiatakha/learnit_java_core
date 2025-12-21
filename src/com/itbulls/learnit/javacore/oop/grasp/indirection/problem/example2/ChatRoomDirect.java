package com.itbulls.learnit.javacore.oop.grasp.indirection.problem.example2;

//Problem: chat room directly references concrete participants and calls them directly.
//Adding/removing participants forces modifications here. No mediator/event bus abstraction.

public class ChatRoomDirect {

 private final UserAlice alice = new UserAlice();
 private final UserBob bob = new UserBob();
 private final UserCharlie charlie = new UserCharlie();

 public void sendMessage(String fromUser, String message) {
     if ("Alice".equals(fromUser)) {
         bob.receive("Alice", message);
         charlie.receive("Alice", message);
     } else if ("Bob".equals(fromUser)) {
         alice.receive("Bob", message);
         charlie.receive("Bob", message);
     } else if ("Charlie".equals(fromUser)) {
         alice.receive("Charlie", message);
         bob.receive("Charlie", message);
     } else {
         throw new IllegalArgumentException("Unknown user: " + fromUser);
     }
 }
}
