package com.itbulls.learnit.javacore.patterns.behavioral.visitor;

public class Demo {

	public static void main(String[] args) {
		var industrialBuidling = new IndustrialBuilding();
		var park = new Park();
		var privateBuilding = new PrivateBuilding();
		var shoppingCenter = new ShoppingCenter();
		
		ExportVisitor visitor = new XMLExportVisitor();
		visitor.export(industrialBuidling, 
					park,
					privateBuilding,
					shoppingCenter);
		
		System.out.println("=======================================");
		
		visitor = new JSONExportVisitor();
		visitor.export(industrialBuidling, 
				park,
				privateBuilding,
				shoppingCenter);
		
		
		
	}
	
}
