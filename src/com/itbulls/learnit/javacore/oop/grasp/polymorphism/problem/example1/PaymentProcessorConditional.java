package com.itbulls.learnit.javacore.oop.grasp.polymorphism.problem.example1;

//Problem:
//Conditional logic based on payment method type.
//Every time you add a new method, you modify this class.

public class PaymentProcessorConditional {

 public void pay(PaymentRequest request) {

     if (request.getMethodType() == PaymentMethodType.CARD) {
         System.out.println("Charging CARD for customer " + request.getCustomerId()
                 + " amount=" + request.getAmount());

     } else if (request.getMethodType() == PaymentMethodType.PAYPAL) {
         System.out.println("Charging PAYPAL for customer " + request.getCustomerId()
                 + " amount=" + request.getAmount());

     } else if (request.getMethodType() == PaymentMethodType.BANK_TRANSFER) {
         System.out.println("Charging BANK TRANSFER for customer " + request.getCustomerId()
                 + " amount=" + request.getAmount());

     } else {
         throw new IllegalArgumentException("Unsupported payment method: " + request.getMethodType());
     }
 }
}
