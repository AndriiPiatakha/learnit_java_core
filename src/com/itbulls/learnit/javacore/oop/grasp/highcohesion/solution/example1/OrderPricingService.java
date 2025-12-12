package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example1;

public class OrderPricingService {

    private final DiscountCalculator discountCalculator;

    public OrderPricingService(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public double calculateTotal(Order order) {
        double total = 0.0;
        for (OrderLine line : order.getLines()) {
            total += line.getUnitPrice() * line.getQuantity();
        }
        return total;
    }

    public double calculateFinalPriceWithDiscount(Order order) {
        double total = calculateTotal(order);
        double discount = discountCalculator.calculateDiscountForCustomer(
                order.getCustomer().getId(), total);
        return total - discount;
    }
}