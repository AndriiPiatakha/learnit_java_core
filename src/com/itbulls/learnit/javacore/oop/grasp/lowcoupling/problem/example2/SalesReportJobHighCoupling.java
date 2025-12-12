package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.problem.example2;

import java.util.List;

//Problem example 2:
//This job is tightly coupled to concrete DB API, CSV exporter, and HTTP analytics client.
//It knows connection strings, file paths, SQL queries, and remote API usage details.

public class SalesReportJobHighCoupling {

	public void runDailyReport() {

		FakeDatabaseConnection db = new FakeDatabaseConnection();
		db.connect("jdbc:fake://localhost:5432/salesdb");

		String sql = "SELECT order_id, product_id, quantity, total_amount FROM sales WHERE sale_date = CURRENT_DATE";
		List<SalesRecord> records = db.executeSalesQuery(sql);

		db.close();

		CsvExporter csvExporter = new CsvExporter();
		String filePath = "/tmp/daily-sales-report.csv";
		csvExporter.exportToCsv(records, filePath);

		HttpAnalyticsClient analyticsClient = new HttpAnalyticsClient();
		analyticsClient.sendSalesData(records);

		System.out.println("Daily sales report generated and sent");
	}
}
