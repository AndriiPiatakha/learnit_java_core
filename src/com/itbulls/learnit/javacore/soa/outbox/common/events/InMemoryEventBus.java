package com.itbulls.learnit.javacore.soa.outbox.common.events;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public final class InMemoryEventBus implements EventBus {

    private final Map<Class<?>, List<Consumer<?>>> handlers = new ConcurrentHashMap<>();

    @Override
    public <T extends Event> void publish(T event) {
        List<Consumer<?>> consumers = handlers.getOrDefault(event.getClass(), List.of());
        for (Consumer<?> consumer : consumers) {
            @SuppressWarnings("unchecked")
            Consumer<T> typed = (Consumer<T>) consumer;
            typed.accept(event);
        }
    }

    @Override
    public <T extends Event> void subscribe(Class<T> eventType, Consumer<T> handler) {
        handlers.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>()).add(handler);
    }
}
