package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example1;

public class OrderPersistenceService {

    private final OrderRepository orderRepository;

    public OrderPersistenceService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order) {
        orderRepository.save(order);
    }
}
