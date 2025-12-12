package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example2;

import java.util.List;

public class CsvFileSalesReportExporter implements SalesReportExporter {

    private final CsvExporter csvExporter;
    private final String filePath;

    public CsvFileSalesReportExporter(CsvExporter csvExporter, String filePath) {
        this.csvExporter = csvExporter;
        this.filePath = filePath;
    }

    @Override
    public void export(List<SalesRecord> records) {
        csvExporter.exportToCsv(records, filePath);
    }
}

