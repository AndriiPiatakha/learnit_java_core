package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example1;

import java.time.YearMonth;
import java.util.List;

public class MonthlyOrderReportService {

    private final OrderRepository orderRepository;
    private final MonthlyReportExporter reportExporter;

    public MonthlyOrderReportService(OrderRepository orderRepository,
                                     MonthlyReportExporter reportExporter) {
        this.orderRepository = orderRepository;
        this.reportExporter = reportExporter;
    }

    public void generateMonthlyReport(YearMonth month) {
        List<Order> orders = orderRepository.findAll();

        List<Order> filtered = orders.stream()
                .filter(o -> YearMonth.from(o.getCreatedAt()).equals(month))
                .toList();

        String filePath = "/tmp/orders-" + month + ".csv";
        reportExporter.exportToCsv(filtered, filePath);
    }
}
