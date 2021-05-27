package com.itbulls.learnit.javacore.patterns.behavioral.visitor;

public class PrivateBuilding implements GeoElement {
	
	private double x;
	private double y;
	private String address;
	
	private int numberOfAppartments;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumberOfAppartments() {
		return numberOfAppartments;
	}

	public void setNumberOfAppartments(int numberOfAppartments) {
		this.numberOfAppartments = numberOfAppartments;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.doForPrivateBuilding(this);
	}
	
}
