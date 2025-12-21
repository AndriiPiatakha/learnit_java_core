package com.itbulls.learnit.javacore.oop.grasp.polymorphism.problem.example2;

//Problem:
//Behavior changes based on order status with a switch.
//Adding a new status means modifying this class.

public class OrderStatusHandlerConditional {

 public void handle(Order order) {

     switch (order.getStatus()) {
         case NEW -> System.out.println("Order " + order.getId() + " is NEW: waiting for payment");
         case PAID -> System.out.println("Order " + order.getId() + " is PAID: preparing shipment");
         case SHIPPED -> System.out.println("Order " + order.getId() + " is SHIPPED: tracking enabled");
         case CANCELLED -> System.out.println("Order " + order.getId() + " is CANCELLED: refund process");
         default -> throw new IllegalStateException("Unexpected status: " + order.getStatus());
     }
 }
}
