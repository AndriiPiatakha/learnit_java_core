package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example2;

import java.util.List;

public class HttpSalesAnalyticsPublisher implements SalesAnalyticsPublisher {

    private final HttpAnalyticsClient client;

    public HttpSalesAnalyticsPublisher(HttpAnalyticsClient client) {
        this.client = client;
    }

    @Override
    public void publish(List<SalesRecord> records) {
        client.sendSalesData(records);
    }
}
