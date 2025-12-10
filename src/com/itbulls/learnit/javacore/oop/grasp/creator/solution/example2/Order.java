package com.itbulls.learnit.javacore.oop.grasp.creator.solution.example2;

//Clean domain object: no infrastructure creation inside.

public class Order {

 private final String orderId;
 private final Customer customer;
 private final double totalAmount;

 public Order(String orderId, Customer customer, double totalAmount) {
     this.orderId = orderId;
     this.customer = customer;
     this.totalAmount = totalAmount;
 }

 public String getOrderId() {
     return orderId;
 }

 public Customer getCustomer() {
     return customer;
 }

 public double getTotalAmount() {
     return totalAmount;
 }

 // Domain describes what should happen conceptually,
 // but delegates concrete work to collaborators.
 public void complete(PaymentGatewayClient paymentClient, EmailSender emailSender) {
     paymentClient.charge(customer.getId(), totalAmount);

     emailSender.send(
             customer.getEmail(),
             "Your order " + orderId + " is confirmed",
             "Thank you for your purchase. Total: " + totalAmount
     );
 }
}
