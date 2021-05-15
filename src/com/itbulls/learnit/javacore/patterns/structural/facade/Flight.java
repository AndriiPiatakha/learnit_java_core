package com.itbulls.learnit.javacore.patterns.structural.facade;

import java.util.Date;

public class Flight {
	
	private String flightNumber;
	private String airportFrom;
	private String airpotrTo;
	private Date departureDateTime;
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirportFrom() {
		return airportFrom;
	}
	public void setAirportFrom(String airportFrom) {
		this.airportFrom = airportFrom;
	}
	public String getAirpotrTo() {
		return airpotrTo;
	}
	public void setAirpotrTo(String airpotrTo) {
		this.airpotrTo = airpotrTo;
	}
	public Date getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

}
