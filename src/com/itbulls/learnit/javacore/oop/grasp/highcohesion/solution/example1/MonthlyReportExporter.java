package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example1;

import java.util.List;

public class MonthlyReportExporter {

    public void exportToCsv(List<Order> orders, String filePath) {
        System.out.println("Exporting " + orders.size() +
                " orders to CSV file: " + filePath);
    }
}