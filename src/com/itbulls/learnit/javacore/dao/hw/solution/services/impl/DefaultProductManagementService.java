package com.itbulls.learnit.javacore.dao.hw.solution.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Product;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.impl.DefaultProduct;
import com.itbulls.learnit.javacore.dao.hw.solution.services.ProductManagementService;


public class DefaultProductManagementService implements ProductManagementService {
	
	private static final String PRODUCTS_INFO_STORAGE = "products.csv";
	private static final String CURRENT_TASK_RESOURCE_FOLDER = "finaltask";
	private static final String RESOURCES_FOLDER = "resources";
	private static final int PRODUCT_PRICE_INDEX = 3;
	private static final int PRODUCT_CATEGORY_INDEX = 2;
	private static final int PRODUCT_NAME_INDEX = 1;
	private static final int PRODUCT_ID_INDEX = 0;
	
	private static DefaultProductManagementService instance;
	
	private static List<Product> products;
	

	{
		loadProductsFromStorage();
	}

	public void loadProductsFromStorage() {
		products = loadProducts();
	}
	
	/**
	 * @deprecated use loadProductsFromStorage instead
	 */
	private static void initProducts() {
		products = new ArrayList<>(Arrays.asList(
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
		));
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
	public List<Product> getProducts() {
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
	
	private List<Product> loadProducts() {
		try (var stream = Files.lines(Paths.get(RESOURCES_FOLDER, CURRENT_TASK_RESOURCE_FOLDER, 
										PRODUCTS_INFO_STORAGE))) {
			return stream
					.filter(Objects::nonNull)
					.filter(line -> !line.isEmpty())
					.map(line -> {
				String[] productElements = line.split(",");
				return new DefaultProduct(Integer.valueOf(productElements[PRODUCT_ID_INDEX]), 
											productElements[PRODUCT_NAME_INDEX], 
											productElements[PRODUCT_CATEGORY_INDEX], 
											Double.valueOf(productElements[PRODUCT_PRICE_INDEX]));
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}

}
