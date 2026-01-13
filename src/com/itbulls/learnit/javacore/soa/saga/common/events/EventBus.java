package com.itbulls.learnit.javacore.soa.saga.common.events;

import java.util.function.Consumer;

public interface EventBus {
    <T extends Event> void publish(T event);
    <T extends Event> void subscribe(Class<T> eventType, Consumer<T> handler);
}
