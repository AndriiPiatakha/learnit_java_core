package com.itbulls.learnit.javacore.soa.saga.saga;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class SagaRepository {

    private final Map<String, SagaState> store = new ConcurrentHashMap<>();

    public void save(SagaState state) {
        store.put(state.sagaId(), state);
    }

    public Optional<SagaState> findBySagaId(String sagaId) {
        return Optional.ofNullable(store.get(sagaId));
    }
}
