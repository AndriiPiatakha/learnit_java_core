package com.itbulls.learnit.javacore.oop.grasp.creator.solution.example2;

//Simple factory to build the service with proper infrastructure dependencies.

public class OrderServiceFactory {

 public static OrderCompletionService createDefaultOrderCompletionService() {
     PaymentGatewayClient paymentClient =
             new PaymentGatewayClient("https://payments.example.com/api");

     EmailSender emailSender =
             new EmailSender("smtp.example.com");

     return new OrderCompletionService(paymentClient, emailSender);
 }
}
