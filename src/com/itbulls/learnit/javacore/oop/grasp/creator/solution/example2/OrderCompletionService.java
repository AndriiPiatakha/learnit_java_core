package com.itbulls.learnit.javacore.oop.grasp.creator.solution.example2;

//Application/service layer coordinates infra objects and domain.
//Here we apply "avoid Creator in domain" and centralize creation or injection.

public class OrderCompletionService {

 private final PaymentGatewayClient paymentClient;
 private final EmailSender emailSender;

 public OrderCompletionService(PaymentGatewayClient paymentClient,
                               EmailSender emailSender) {
     this.paymentClient = paymentClient;
     this.emailSender = emailSender;
 }

 public void completeOrder(Order order) {
     // Domain does not create infrastructure,
     // it only uses what it gets.
     order.complete(paymentClient, emailSender);
 }
}