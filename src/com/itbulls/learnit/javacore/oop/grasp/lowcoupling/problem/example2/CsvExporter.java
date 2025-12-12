package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.problem.example2;

import java.util.List;

//Simulated CSV exporter

public class CsvExporter {

 public void exportToCsv(List<SalesRecord> records, String filePath) {
     System.out.println("Exporting " + records.size() + " records to CSV: " + filePath);
 }
}

