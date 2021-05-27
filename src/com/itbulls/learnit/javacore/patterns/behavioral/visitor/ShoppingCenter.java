package com.itbulls.learnit.javacore.patterns.behavioral.visitor;

import java.util.List;

public class ShoppingCenter implements GeoElement {
	
	private double x;
	private double y;
	private String address;
	
	private String name;
	private List<String> productsNameCatalog;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getProductsNameCatalog() {
		return productsNameCatalog;
	}
	public void setProductsNameCatalog(List<String> productsNameCatalog) {
		this.productsNameCatalog = productsNameCatalog;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.doForShoppingCenter(this);
	}
	

}
