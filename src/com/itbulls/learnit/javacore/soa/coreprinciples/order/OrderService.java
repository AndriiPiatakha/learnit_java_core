package com.itbulls.learnit.javacore.soa.coreprinciples.order;


import java.util.Objects;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.coreprinciples.common.events.EventBus;
import com.itbulls.learnit.javacore.soa.coreprinciples.contracts.customer.CustomerServiceContract;
import com.itbulls.learnit.javacore.soa.coreprinciples.contracts.events.OrderPlacedEvent;
import com.itbulls.learnit.javacore.soa.coreprinciples.contracts.events.StockReservedEvent;
import com.itbulls.learnit.javacore.soa.coreprinciples.contracts.product.ProductServiceContract;
import com.itbulls.learnit.javacore.soa.coreprinciples.order.internal.Order;
import com.itbulls.learnit.javacore.soa.coreprinciples.order.internal.OrderRepository;

public final class OrderService {

    private final CustomerServiceContract customerService;
    private final ProductServiceContract productService;
    private final OrderRepository repository;
    private final EventBus eventBus;

    public OrderService(
            CustomerServiceContract customerService,
            ProductServiceContract productService,
            OrderRepository repository,
            EventBus eventBus
    ) {
        this.customerService = Objects.requireNonNull(customerService);
        this.productService = Objects.requireNonNull(productService);
        this.repository = Objects.requireNonNull(repository);
        this.eventBus = Objects.requireNonNull(eventBus);

        this.eventBus.subscribe(StockReservedEvent.class, this::onStockReserved);
    }

    public String placeOrder(String customerId, String sku, int quantity) {
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, customerId, sku, quantity);
        repository.save(order);

        var customer = customerService.findCustomerById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("unknown customerId=" + customerId));

        if (!customer.active()) {
            order.rejected();
            throw new IllegalStateException("customer is not active: " + customerId);
        }

        productService.findProductBySku(sku)
                .orElseThrow(() -> new IllegalArgumentException("unknown sku=" + sku));

        productService.reserveStock(sku, quantity, orderId);

        order.placed();
        eventBus.publish(OrderPlacedEvent.now(orderId, customerId, sku, quantity));

        return orderId;
    }

    private void onStockReserved(StockReservedEvent event) {
        System.out.println("[OrderService] observed StockReservedEvent: orderId=" + event.orderId()
                + ", sku=" + event.sku()
                + ", qty=" + event.quantity());
    }
}
