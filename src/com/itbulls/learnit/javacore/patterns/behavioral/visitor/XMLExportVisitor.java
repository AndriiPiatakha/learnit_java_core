package com.itbulls.learnit.javacore.patterns.behavioral.visitor;

public class XMLExportVisitor implements ExportVisitor {
	
	/*
	 * Currently we have duplication of this method in this class and in JSONExportVisitor.
	 * The solution might be to introduce abstract class above this one and that one, but below 
	 * Visitor interface. 
	 * 
	 * Didn't want to confuse you more in this example that's why kept this duplication 
	 * on purpose.
	 */
	public void export(GeoElement... elements) {
		for (GeoElement geoElement : elements) {
			geoElement.accept(this);
		}
	}

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
