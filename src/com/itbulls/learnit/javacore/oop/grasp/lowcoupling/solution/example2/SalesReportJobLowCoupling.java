package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example2;

//Solution example 2:
//Job depends only on the SalesReportingFacade, not on DB, CSV, or HTTP details.

public class SalesReportJobLowCoupling {

	private final SalesReportingFacade reportingFacade;

	public SalesReportJobLowCoupling(SalesReportingFacade reportingFacade) {
		this.reportingFacade = reportingFacade;
	}

	public void runDailyReport() {
		reportingFacade.generateAndPublishDailyReport();
	}
}