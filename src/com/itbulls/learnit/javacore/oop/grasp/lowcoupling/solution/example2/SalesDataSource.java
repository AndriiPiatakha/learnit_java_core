package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example2;

import java.util.List;

public interface SalesDataSource {

    List<SalesRecord> loadTodaySales();
}