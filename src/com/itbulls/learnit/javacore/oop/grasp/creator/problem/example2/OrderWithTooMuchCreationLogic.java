package com.itbulls.learnit.javacore.oop.grasp.creator.problem.example2;

//Anti pattern:
//Domain object creates infrastructure services directly,
//mixes business rules with technical construction,
//and violates separation of concerns.

public class OrderWithTooMuchCreationLogic {

 private final String orderId;
 private final Customer customer;
 private final double totalAmount;

 public OrderWithTooMuchCreationLogic(String orderId, Customer customer, double totalAmount) {
     this.orderId = orderId;
     this.customer = customer;
     this.totalAmount = totalAmount;
 }

 public void completeOrder() {
     // BAD: Domain object decides how to instantiate infra clients.
     PaymentGatewayClient paymentClient =
             new PaymentGatewayClient("https://payments.example.com/api");

     EmailSender emailSender =
             new EmailSender("smtp.example.com");

     // Business logic mixed with creation of external dependencies.
     paymentClient.charge(customer.getId(), totalAmount);

     emailSender.send(
             customer.getEmail(),
             "Your order " + orderId + " is confirmed",
             "Thank you for your purchase. Total: " + totalAmount
     );
 }
}
