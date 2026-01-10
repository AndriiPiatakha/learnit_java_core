package com.itbulls.learnit.javacore.soa.coreprinciples.app;

import com.itbulls.learnit.javacore.soa.coreprinciples.common.events.InMemoryEventBus;
import com.itbulls.learnit.javacore.soa.coreprinciples.contracts.events.OrderPlacedEvent;
import com.itbulls.learnit.javacore.soa.coreprinciples.customer.CustomerService;
import com.itbulls.learnit.javacore.soa.coreprinciples.customer.internal.Customer;
import com.itbulls.learnit.javacore.soa.coreprinciples.customer.internal.CustomerRepository;
import com.itbulls.learnit.javacore.soa.coreprinciples.order.OrderService;
import com.itbulls.learnit.javacore.soa.coreprinciples.order.internal.OrderRepository;
import com.itbulls.learnit.javacore.soa.coreprinciples.product.ProductService;
import com.itbulls.learnit.javacore.soa.coreprinciples.product.internal.Product;
import com.itbulls.learnit.javacore.soa.coreprinciples.product.internal.ProductRepository;

public final class DemoApp {

    public static void main(String[] args) {
        var eventBus = new InMemoryEventBus();

        var customerRepo = new CustomerRepository();
        customerRepo.save(new Customer("C-1", "Alice Johnson", true));

        var productRepo = new ProductRepository();
        productRepo.save(new Product("SKU-BOOK-1", "Clean Architecture Book", 10));

        var customerService = new CustomerService(customerRepo);
        var productService = new ProductService(productRepo, eventBus);
        var orderRepo = new OrderRepository();
        var orderService = new OrderService(customerService, productService, orderRepo, eventBus);

        eventBus.subscribe(OrderPlacedEvent.class, e ->
                System.out.println("[NotificationService] Order placed: orderId=" + e.orderId()
                        + ", customerId=" + e.customerId()
                        + ", sku=" + e.sku()
                        + ", qty=" + e.quantity())
        );

        String orderId = orderService.placeOrder("C-1", "SKU-BOOK-1", 2);
        System.out.println("Order successfully placed. orderId=" + orderId);

        var productAfter = productService.findProductBySku("SKU-BOOK-1").orElseThrow();
        System.out.println("Stock after reservation: sku=" + productAfter.sku()
                + ", availableStock=" + productAfter.availableStock());
    }
}
