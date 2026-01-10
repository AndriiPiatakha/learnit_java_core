package com.itbulls.learnit.javacore.soa.coreprinciples.product.internal;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class ProductRepository {

    private final Map<String, Product> products = new ConcurrentHashMap<>();

    public void save(Product product) {
        products.put(product.sku(), product);
    }

    public Optional<Product> findBySku(String sku) {
        return Optional.ofNullable(products.get(sku));
    }
}
