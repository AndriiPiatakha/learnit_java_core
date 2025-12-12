package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example1;

public class OrderSummaryFormatter {

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
