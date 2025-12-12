package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example2;

import java.util.List;

public interface SalesReportExporter {

    void export(List<SalesRecord> records);
}
