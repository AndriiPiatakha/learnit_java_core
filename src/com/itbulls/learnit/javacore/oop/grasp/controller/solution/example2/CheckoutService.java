package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example2;

public class CheckoutService {

    private final OrderRepository orderRepository;
    private final OrderFactory orderFactory;

    public CheckoutService(OrderRepository orderRepository,
                           OrderFactory orderFactory) {
        this.orderRepository = orderRepository;
        this.orderFactory = orderFactory;
    }

    public Order checkout(ShoppingCart cart) {
        Order order = orderFactory.createOrder(cart);
        orderRepository.save(order);
        return order;
    }
}
