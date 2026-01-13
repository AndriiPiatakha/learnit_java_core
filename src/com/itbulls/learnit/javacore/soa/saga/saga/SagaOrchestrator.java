package com.itbulls.learnit.javacore.soa.saga.saga;

import java.util.Objects;

import com.itbulls.learnit.javacore.soa.saga.common.events.Event;
import com.itbulls.learnit.javacore.soa.saga.common.events.EventBus;
import com.itbulls.learnit.javacore.soa.saga.common.idempotency.ProcessedEventStore;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.OrderCreatedEvent;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.PaymentFailedEvent;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.PaymentProcessedEvent;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.PaymentRefundedEvent;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.ShipmentArrangedEvent;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.ShipmentFailedEvent;
import com.itbulls.learnit.javacore.soa.saga.order.OrderService;
import com.itbulls.learnit.javacore.soa.saga.payment.PaymentService;
import com.itbulls.learnit.javacore.soa.saga.shipping.ShippingService;

public final class SagaOrchestrator {

    private final EventBus bus;
    private final ProcessedEventStore processed;
    private final SagaRepository sagaRepo;

    private final PaymentService payment;
    private final ShippingService shipping;
    private final OrderService orders;

    public SagaOrchestrator(
            EventBus bus,
            ProcessedEventStore processed,
            SagaRepository sagaRepo,
            PaymentService payment,
            ShippingService shipping,
            OrderService orders
    ) {
        this.bus = Objects.requireNonNull(bus);
        this.processed = Objects.requireNonNull(processed);
        this.sagaRepo = Objects.requireNonNull(sagaRepo);
        this.payment = Objects.requireNonNull(payment);
        this.shipping = Objects.requireNonNull(shipping);
        this.orders = Objects.requireNonNull(orders);

        bus.subscribe(OrderCreatedEvent.class, this::onOrderCreated);
        bus.subscribe(PaymentProcessedEvent.class, this::onPaymentProcessed);
        bus.subscribe(PaymentFailedEvent.class, this::onPaymentFailed);
        bus.subscribe(ShipmentArrangedEvent.class, this::onShipmentArranged);
        bus.subscribe(ShipmentFailedEvent.class, this::onShipmentFailed);
        bus.subscribe(PaymentRefundedEvent.class, this::onPaymentRefunded);
    }

    private boolean firstTime(Event e) {
        return processed.markIfFirstTime(e.eventId());
    }

    private void onOrderCreated(OrderCreatedEvent e) {
        if (!firstTime(e)) return;

        SagaState saga = new SagaState(e.sagaId(), e.orderId());
        sagaRepo.save(saga);

        System.out.println("[Saga] START sagaId=" + e.sagaId() + " orderId=" + e.orderId());

        payment.charge(e.sagaId(), e.orderId(), e.amount());
    }

    private void onPaymentProcessed(PaymentProcessedEvent e) {
        if (!firstTime(e)) return;

        SagaState saga = sagaRepo.findBySagaId(e.sagaId()).orElseThrow();
        saga.status(SagaState.Status.PAYMENT_OK);
        sagaRepo.save(saga);

        System.out.println("[Saga] PAYMENT_OK sagaId=" + e.sagaId() + " paymentId=" + e.paymentId());

        shipping.arrange(e.sagaId(), e.orderId());
    }

    private void onPaymentFailed(PaymentFailedEvent e) {
        if (!firstTime(e)) return;

        SagaState saga = sagaRepo.findBySagaId(e.sagaId()).orElseThrow();
        saga.status(SagaState.Status.CANCELLED);
        sagaRepo.save(saga);

        System.out.println("[Saga] PAYMENT_FAILED sagaId=" + e.sagaId() + " reason=" + e.reason());

        orders.cancelOrder(e.sagaId(), e.orderId(), "payment failed");
    }

    private void onShipmentArranged(ShipmentArrangedEvent e) {
        if (!firstTime(e)) return;

        SagaState saga = sagaRepo.findBySagaId(e.sagaId()).orElseThrow();
        saga.status(SagaState.Status.COMPLETED);
        sagaRepo.save(saga);

        System.out.println("[Saga] SHIPPING_OK sagaId=" + e.sagaId() + " shipmentId=" + e.shipmentId());

        orders.completeOrder(e.orderId());
        System.out.println("[Saga] COMPLETED sagaId=" + e.sagaId());
    }

    private void onShipmentFailed(ShipmentFailedEvent e) {
        if (!firstTime(e)) return;

        SagaState saga = sagaRepo.findBySagaId(e.sagaId()).orElseThrow();
        saga.status(SagaState.Status.COMPENSATING);
        sagaRepo.save(saga);

        System.out.println("[Saga] SHIPPING_FAILED sagaId=" + e.sagaId() + " reason=" + e.reason());

        shipping.abort(e.sagaId(), e.orderId(), "shipping failed");
        payment.refund(e.sagaId(), e.orderId());
    }

    private void onPaymentRefunded(PaymentRefundedEvent e) {
        if (!firstTime(e)) return;

        SagaState saga = sagaRepo.findBySagaId(e.sagaId()).orElseThrow();
        saga.status(SagaState.Status.CANCELLED);
        sagaRepo.save(saga);

        System.out.println("[Saga] REFUNDED sagaId=" + e.sagaId() + " refundId=" + e.refundId());

        orders.cancelOrder(e.sagaId(), e.orderId(), "refunded after shipping failure");
    }
}
