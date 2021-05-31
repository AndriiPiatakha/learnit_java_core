package com.itbulls.learnit.javacore.patterns.behavioral.visitor;

public class XMLExportVisitor implements ExportVisitor {
	
	@Override
	public void doForIndustrialBuidling(IndustrialBuilding ib) {
		System.out.println("XML Export for industrial building");
	}

	@Override
	public void doForPark(Park park) {
		System.out.println("XML Export for park");		
	}

	@Override
	public void doForPrivateBuilding(PrivateBuilding pb) {
		System.out.println("XML Export for private building");		
	}

	@Override
	public void doForShoppingCenter(ShoppingCenter sc) {
		System.out.println("XML Export for shopping center");		
	}

}
