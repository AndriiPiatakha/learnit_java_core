package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example1;

public class OrderNotificationService {

    private final EmailSender emailSender;
    private final OrderPricingService pricingService;

    public OrderNotificationService(EmailSender emailSender,
                                    OrderPricingService pricingService) {
        this.emailSender = emailSender;
        this.pricingService = pricingService;
    }

    public void sendOrderConfirmationEmail(Order order) {
        double finalPrice = pricingService.calculateFinalPriceWithDiscount(order);

        String subject = "Order " + order.getId() + " confirmation";
        String body = "Dear " + order.getCustomer().getName() +
                ", your order total is " + finalPrice;

        emailSender.send(order.getCustomer().getEmail(), subject, body);
    }
}
