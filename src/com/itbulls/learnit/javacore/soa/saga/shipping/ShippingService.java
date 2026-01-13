package com.itbulls.learnit.javacore.soa.saga.shipping;

import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.EventBus;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.ShipmentAbortedEvent;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.ShipmentArrangedEvent;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.ShipmentFailedEvent;

public final class ShippingService {

    private final EventBus bus;

    // Demo switch
    private final boolean failArrange;

    public ShippingService(EventBus bus, boolean failArrange) {
        this.bus = bus;
        this.failArrange = failArrange;
    }

    public void arrange(String sagaId, String orderId) {
        if (failArrange) {
            bus.publish(ShipmentFailedEvent.now(sagaId, orderId, "carrier unavailable"));
            return;
        }
        String shipmentId = "SH-" + UUID.randomUUID();
        bus.publish(ShipmentArrangedEvent.now(sagaId, orderId, shipmentId));
    }

    public void abort(String sagaId, String orderId, String reason) {
        bus.publish(ShipmentAbortedEvent.now(sagaId, orderId, reason));
    }
}
