package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public class EmailAndSmsNotificationService implements NotificationService {

    private final EmailService emailService;
    private final SmsService smsService;

    public EmailAndSmsNotificationService(EmailService emailService, SmsService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @Override
    public void notifyCustomer(Customer customer, String message) {
        emailService.sendEmail(
                customer.getEmail(),
                "Order notification",
                message
        );
        smsService.sendSms(customer.getPhone(), message);
    }
}
