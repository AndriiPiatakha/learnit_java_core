package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example2;

import java.util.List;

//Facade for the sales reporting subsystem.
//Hides DB, CSV, and HTTP details behind a simple API.

public class SalesReportingFacade {

	private final SalesDataSource dataSource;
	private final SalesReportExporter reportExporter;
	private final SalesAnalyticsPublisher analyticsPublisher;

	public SalesReportingFacade(SalesDataSource dataSource, SalesReportExporter reportExporter,
			SalesAnalyticsPublisher analyticsPublisher) {
		this.dataSource = dataSource;
		this.reportExporter = reportExporter;
		this.analyticsPublisher = analyticsPublisher;
	}

	public void generateAndPublishDailyReport() {

		List<SalesRecord> records = dataSource.loadTodaySales();

		reportExporter.export(records);

		analyticsPublisher.publish(records);

		System.out.println("Daily sales report generated and sent (via facade)");
	}
}
