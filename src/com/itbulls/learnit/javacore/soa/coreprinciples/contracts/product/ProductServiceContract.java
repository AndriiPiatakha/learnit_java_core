package com.itbulls.learnit.javacore.soa.coreprinciples.contracts.product;

import java.util.Optional;

public interface ProductServiceContract {

    Optional<ProductView> findProductBySku(String sku);

    void reserveStock(String sku, int quantity, String orderId);
}
