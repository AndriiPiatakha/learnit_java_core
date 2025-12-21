package com.itbulls.learnit.javacore.oop.grasp.purefabrication.solution.example1;

//Application service: coordinates multiple fabrications + domain behavior
public class OrderConfirmationService {

 private final OrderRepository orderRepository;
 private final EmailSender emailSender;

 public OrderConfirmationService(OrderRepository orderRepository, EmailSender emailSender) {
     this.orderRepository = orderRepository;
     this.emailSender = emailSender;
 }

 public void confirm(Order order) {
     orderRepository.save(order);

     String subject = "Order " + order.getId() + " confirmation";
     String body = "Thank you for your purchase. Total: " + order.totalAmount();
     emailSender.send(order.getCustomer().getEmail(), subject, body);
 }
}