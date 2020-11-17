package com.itbulls.learnit.javacore.jcf.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.Product;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.impl.ComparableProduct;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.services.impl.DefaultProductManagementService;

public class ComparisonDemo {

	public static void main(String[] args) {

		// === Demo - Sorting Integers (type that implements Comparable)
		System.out.println("===== Integers =====");

		List<Integer> integers = new ArrayList<>(Arrays.asList(1, 15, 2, 37, 100));
		System.out.println("Original list: " + integers);

		integers.sort(Comparator.reverseOrder());

		System.out.println("Reversed order: " + integers);

		integers.sort(Comparator.naturalOrder());

		System.out.println("Natural order: " + integers);

		// === Demo - Sorting Products (type that doesn't implement Comparable)

		System.out.println("===== Products =====");

		List<Product> products = DefaultProductManagementService.getInstance()
				.getProducts();

		printProductsInNewLine(products);

//		products.sort(Comparator.naturalOrder()); // compilation error in case Product is not Comparable

		
		// === Demo - Sorting Products (type that implements Comparable)
		
		ComparableProduct cp1 = new ComparableProduct(1, "Product 1", "Category 2", 310);
		ComparableProduct cp2 = new ComparableProduct(2, "Product 2", "category 1", 200);
		ComparableProduct cp3 = new ComparableProduct(3, "Product 3", "category 2", 259);

		List<ComparableProduct> comparableProducts = new ArrayList<>(
				Arrays.asList(cp3, cp1, cp2));
		
		comparableProducts.sort(Comparator.naturalOrder());
		
		System.out.println("========== Comparable products - SORTED");
		printProductsInNewLine(comparableProducts);
		
		// === Demo - Comparator implementation
		
		/*
		 * We can implement comparator in four ways:
		 * 
		 * 1. Anonymous class
		 * 2. Separate class
		 * 3. Lambda expression
		 * 4. Method reference
		 * 
		 */

		products.sort(new Comparator<Product>() {
			@Override
			public int compare(Product product1, Product product2) {
				return product1.getProductName().compareTo(product2.getProductName());
			}
		});
		
		products.sort(new ProductNameComparator());
		
		System.out.println("============== Comparator demo - Sorted Products");
		printProductsInNewLine(products);
	}

	public static void printProductsInNewLine(List<? extends Product> products) {
		for (Product product : products) {
			System.out.println(product);
		}
	}

}

class ProductNameComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		return product1.getProductName().compareTo(product2.getProductName());
	}
	
}
