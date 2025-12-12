package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example2;

import java.util.ArrayList;
import java.util.List;

// Simulated "low level" database API

public class FakeDatabaseConnection {

    public void connect(String connectionString) {
        System.out.println("Connecting to DB: " + connectionString);
    }

    public List<SalesRecord> executeSalesQuery(String sql) {
        System.out.println("Executing SQL: " + sql);

        List<SalesRecord> results = new ArrayList<>();
        results.add(new SalesRecord("o1", "p1", 2, 50.0));
        results.add(new SalesRecord("o2", "p2", 1, 80.0));
        return results;
    }

    public void close() {
        System.out.println("Closing DB connection");
    }
}
