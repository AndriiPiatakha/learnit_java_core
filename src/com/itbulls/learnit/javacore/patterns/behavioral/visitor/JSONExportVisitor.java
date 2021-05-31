package com.itbulls.learnit.javacore.patterns.behavioral.visitor;

public class JSONExportVisitor implements ExportVisitor {
	
	@Override
	public void doForIndustrialBuidling(IndustrialBuilding ib) {
		System.out.println("JSON Export for industrial building");
	}

	@Override
	public void doForPark(Park park) {
		System.out.println("JSON Export for park");		
	}

	@Override
	public void doForPrivateBuilding(PrivateBuilding pb) {
		System.out.println("JSON Export for private building");		
	}

	@Override
	public void doForShoppingCenter(ShoppingCenter sc) {
		System.out.println("JSON Export for shopping center");		
	}

}
