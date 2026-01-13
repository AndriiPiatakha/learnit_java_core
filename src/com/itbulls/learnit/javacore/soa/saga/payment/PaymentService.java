package com.itbulls.learnit.javacore.soa.saga.payment;


import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.EventBus;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.PaymentFailedEvent;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.PaymentProcessedEvent;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.PaymentRefundedEvent;

public final class PaymentService {

    private final EventBus bus;

    // Demo switches
    private final boolean failCharge;
    private final boolean failRefund;

    public PaymentService(EventBus bus, boolean failCharge, boolean failRefund) {
        this.bus = bus;
        this.failCharge = failCharge;
        this.failRefund = failRefund;
    }

    public void charge(String sagaId, String orderId, double amount) {
        if (failCharge) {
            bus.publish(PaymentFailedEvent.now(sagaId, orderId, "payment declined"));
            return;
        }
        String paymentId = "P-" + UUID.randomUUID();
        bus.publish(PaymentProcessedEvent.now(sagaId, orderId, paymentId));
    }

    public void refund(String sagaId, String orderId) {
        if (failRefund) {
            // For demo: if refund fails, we still emit failed event using PaymentFailedEvent
            bus.publish(PaymentFailedEvent.now(sagaId, orderId, "refund failed"));
            return;
        }
        String refundId = "R-" + UUID.randomUUID();
        bus.publish(PaymentRefundedEvent.now(sagaId, orderId, refundId));
    }
}