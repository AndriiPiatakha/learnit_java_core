package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example2;

import java.util.List;

public class DatabaseSalesDataSource implements SalesDataSource {

    private final FakeDatabaseConnection db;
    private final String connectionString;

    public DatabaseSalesDataSource(FakeDatabaseConnection db, String connectionString) {
        this.db = db;
        this.connectionString = connectionString;
    }

    @Override
    public List<SalesRecord> loadTodaySales() {
        db.connect(connectionString);

        String sql = "SELECT order_id, product_id, quantity, total_amount " +
                "FROM sales WHERE sale_date = CURRENT_DATE";
        List<SalesRecord> records = db.executeSalesQuery(sql);

        db.close();
        return records;
    }
}
