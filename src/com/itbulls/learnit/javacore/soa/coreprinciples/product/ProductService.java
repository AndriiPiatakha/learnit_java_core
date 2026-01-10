package com.itbulls.learnit.javacore.soa.coreprinciples.product;


import java.util.Optional;

import com.itbulls.learnit.javacore.soa.coreprinciples.common.events.EventBus;
import com.itbulls.learnit.javacore.soa.coreprinciples.contracts.events.StockReservedEvent;
import com.itbulls.learnit.javacore.soa.coreprinciples.contracts.product.ProductServiceContract;
import com.itbulls.learnit.javacore.soa.coreprinciples.contracts.product.ProductView;
import com.itbulls.learnit.javacore.soa.coreprinciples.product.internal.ProductRepository;

public final class ProductService implements ProductServiceContract {

    private final ProductRepository repository;
    private final EventBus eventBus;

    public ProductService(ProductRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    @Override
    public Optional<ProductView> findProductBySku(String sku) {
        return repository.findBySku(sku)
                .map(p -> new ProductView(p.sku(), p.title(), p.availableStock()));
    }

    @Override
    public void reserveStock(String sku, int quantity, String orderId) {
        var product = repository.findBySku(sku)
                .orElseThrow(() -> new IllegalArgumentException("unknown sku=" + sku));

        product.reserve(quantity);

        eventBus.publish(StockReservedEvent.now(orderId, sku, quantity));
    }
}

