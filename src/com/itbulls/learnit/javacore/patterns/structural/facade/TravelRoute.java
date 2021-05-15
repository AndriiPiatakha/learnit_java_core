package com.itbulls.learnit.javacore.patterns.structural.facade;

public class TravelRoute {
	
	private Hotel hotel;
	private Flight flight;
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
}
