package com.itbulls.learnit.javacore.oop.grasp.highcohesion.problem.example1;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

// Problem example:
// "Swiss army knife" class with low cohesion.
// It calculates totals, applies discounts, sends emails,
// persists orders, and generates monthly reports.

public class OrderSwissArmyService {

    private final OrderRepository orderRepository = new OrderRepository();
    private final DiscountCalculator discountCalculator = new DiscountCalculator();
    private final EmailSender emailSender = new EmailSender();
    private final MonthlyReportExporter reportExporter = new MonthlyReportExporter();

    // Business calculation responsibility
    public double calculateTotal(Order order) {
        double total = 0.0;
        for (OrderLine line : order.getLines()) {
            total += line.getUnitPrice() * line.getQuantity();
        }
        return total;
    }

    // Discount responsibility
    public double calculateFinalPriceWithDiscount(Order order) {
        double total = calculateTotal(order);
        double discount = discountCalculator.calculateDiscountForCustomer(
                order.getCustomer().getId(), total);
        return total - discount;
    }

    // Persistence responsibility
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    // Notification responsibility
    public void sendOrderConfirmationEmail(Order order) {
        double finalPrice = calculateFinalPriceWithDiscount(order);
        String subject = "Order " + order.getId() + " confirmation";
        String body = "Dear " + order.getCustomer().getName() +
                ", your order total is " + finalPrice;
        emailSender.send(order.getCustomer().getEmail(), subject, body);
    }

    // Reporting responsibility
    public void generateMonthlyReport(YearMonth month) {
        List<Order> orders = orderRepository.findAll();
        List<Order> filtered = orders.stream()
                .filter(o -> YearMonth.from(o.getCreatedAt()).equals(month))
                .toList();

        String filePath = "/tmp/orders-" + month + ".csv";
        reportExporter.exportToCsv(filtered, filePath);
    }

    // Random formatting responsibility
    public String formatOrderSummary(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Order: ").append(order.getId()).append("\n");
        sb.append("Customer: ").append(order.getCustomer().getName()).append("\n");
        sb.append("Lines:\n");
        for (OrderLine line : order.getLines()) {
            sb.append("- ")
              .append(line.getProductName())
              .append(" x")
              .append(line.getQuantity())
              .append(" = ")
              .append(line.getUnitPrice() * line.getQuantity())
              .append("\n");
        }
        sb.append("Created at: ").append(order.getCreatedAt());
        return sb.toString();
    }
}
