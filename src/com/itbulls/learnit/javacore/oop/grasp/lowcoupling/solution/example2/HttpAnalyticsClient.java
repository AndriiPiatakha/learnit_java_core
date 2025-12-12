package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example2;

import java.util.List;

//Simulated remote analytics API client

public class HttpAnalyticsClient {

 public void sendSalesData(List<SalesRecord> records) {
     System.out.println("Sending " + records.size() + " records to remote analytics service");
 }
}
