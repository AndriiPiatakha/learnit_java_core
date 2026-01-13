package com.itbulls.learnit.javacore.soa.saga.app;

import com.itbulls.learnit.javacore.soa.saga.common.events.InMemoryEventBus;
import com.itbulls.learnit.javacore.soa.saga.common.idempotency.InMemoryProcessedEventStore;
import com.itbulls.learnit.javacore.soa.saga.order.OrderService;
import com.itbulls.learnit.javacore.soa.saga.order.internal.OrderRepository;
import com.itbulls.learnit.javacore.soa.saga.payment.PaymentService;
import com.itbulls.learnit.javacore.soa.saga.saga.SagaOrchestrator;
import com.itbulls.learnit.javacore.soa.saga.saga.SagaRepository;
import com.itbulls.learnit.javacore.soa.saga.shipping.ShippingService;

public final class DemoApp {

    public static void main(String[] args) {
        var bus = new InMemoryEventBus();
        var processed = new InMemoryProcessedEventStore();

        var orderRepo = new OrderRepository();
        var orders = new OrderService(orderRepo, bus);

        // Toggle failures here:
        boolean failPaymentCharge = false;
        boolean failRefund = false;
        boolean failShippingArrange = true; // set true to trigger compensation

        var payment = new PaymentService(bus, failPaymentCharge, failRefund);
        var shipping = new ShippingService(bus, failShippingArrange);

        var sagaRepo = new SagaRepository();
        new SagaOrchestrator(bus, processed, sagaRepo, payment, shipping, orders);

        System.out.println("=== Start Saga Demo ===");
        String sagaId = orders.createOrder("C-1", 100.0);
        System.out.println("Saga started: " + sagaId);
        System.out.println("=== End ===");
    }
}
