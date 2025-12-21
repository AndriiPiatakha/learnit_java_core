package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example2;

//Single user implementation for demo. Different users are just instances with different names.

public class ChatUser implements ChatParticipant {

 private final String name;
 private final ChatMediator mediator;

 public ChatUser(String name, ChatMediator mediator) {
     this.name = name;
     this.mediator = mediator;
     mediator.register(this);
 }

 @Override
 public String name() {
     return name;
 }

 public void send(String message) {
     mediator.send(name, message);
 }

 @Override
 public void receive(String from, String message) {
     System.out.println(name + " received from " + from + ": " + message);
 }
}