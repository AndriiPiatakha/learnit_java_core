package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example2;

//Composition root for wiring the reporting subsystem.

public class SalesReportingFactory {

	 public static SalesReportJobLowCoupling createDailyJob() {
	
	     FakeDatabaseConnection db = new FakeDatabaseConnection();
	     SalesDataSource dataSource =
	             new DatabaseSalesDataSource(db, "jdbc:fake://localhost:5432/salesdb");
	
	     CsvExporter csvExporter = new CsvExporter();
	     SalesReportExporter exporter =
	             new CsvFileSalesReportExporter(csvExporter, "/tmp/daily-sales-report.csv");
	
	     HttpAnalyticsClient analyticsClient = new HttpAnalyticsClient();
	     SalesAnalyticsPublisher publisher =
	             new HttpSalesAnalyticsPublisher(analyticsClient);
	
	     SalesReportingFacade facade =
	             new SalesReportingFacade(dataSource, exporter, publisher);
	
	     return new SalesReportJobLowCoupling(facade);
	 }
}