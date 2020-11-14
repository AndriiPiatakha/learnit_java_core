package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.services.impl;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.enteties.Product;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.enteties.impl.DefaultProduct;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.services.ProductManagementService;

public class DefaultProductManagementService implements ProductManagementService {
	
	private static DefaultProductManagementService instance;
	
	private static Product[] products;
	
	static {
		initProducts();
	}

	private static void initProducts() {
		products = new Product[] {
				new DefaultProduct(1, "Hardwood Oak Suffolk Internal Door", "Doors", 109.99),
				new DefaultProduct(2, "Oregon Cottage Interior Oak Door", "Doors", 179.99),
				new DefaultProduct(3, "Oregon Cottage Horizontal Interior White Oak Door", "Doors", 189.99),
				new DefaultProduct(4, "4 Panel Oak Deco Interior Door", "Doors", 209.09),
				new DefaultProduct(5, "Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller", "Boilers", 989.99),
				new DefaultProduct(6, "Glow-worm Betacom 4 30kW Combi Gas Boiler ERP", "Boilers", 787.99),
				new DefaultProduct(7, "Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller", "Boilers", 859.99),
				new DefaultProduct(8, "Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)", "Bricks", 402.99),
				new DefaultProduct(9, "Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)", "Bricks", 659.99),
				new DefaultProduct(10, "Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368", "Bricks", 523.99)
		};
	}
	
	private DefaultProductManagementService() {
		
	}

	public static ProductManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultProductManagementService();
		}
		return instance;
	}

	@Override
	public Product[] getProducts() {
		return products;
	}

	@Override
	public Product getProductById(int productIdToAddToCart) {
		for (Product product : products) {
			if (product != null && product.getId() == productIdToAddToCart) {
				return product;
			}
		}
		return null;
	}

}
