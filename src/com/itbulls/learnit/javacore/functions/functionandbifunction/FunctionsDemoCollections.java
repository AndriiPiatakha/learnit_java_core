package com.itbulls.learnit.javacore.functions.functionandbifunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionsDemoCollections {
	
	private static final double DISCOUNT_RATE = 0.05;
	
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		
		System.out.println("========== Function type demo ==========");
		System.out.println("map.get(4): " + map.get(4));
		map.computeIfAbsent(4, key -> Integer.toString(key));
		System.out.println("map.get(4): " + map.get(4));
		
		map.computeIfAbsent(5, FunctionsDemoCollections::convertIntToString);
		System.out.println("map.get(5): " + map.get(5));
		
		System.out.println("========== BiFunction type demo ==========");
		map.computeIfPresent(3, (key, value) -> key + " : " + value);
		System.out.println("map.get(3): " + map.get(3));
		map.computeIfPresent(2, FunctionsDemoCollections::combineIntAndString);
		System.out.println("map.get(2): " + map.get(2));
		
		System.out.println("========== Compose Functions type demo ==========");
		Map<Product, Double> productDiscountMap = new HashMap<>();
		
		List<Product> products = new ArrayList<>(Arrays.asList(new Product(1, 199.99), 
				new Product(2, 79.99),
				new Product(3, 49.99)));
		
		for (Product product : products) {
			Function<Product, Double> getPriceFunction 
					= product2 -> product2.getPrice();
			Function<Double, Double> getDiscountFunction 
					= price -> price * DISCOUNT_RATE;
			Function<Product, Double> getPriceAndThenDiscountFunction 
					= getPriceFunction.andThen(getDiscountFunction);
			
			Function<Product, Double> getPriceAndThenDiscountFunction2 
					= getDiscountFunction.compose(getPriceFunction);
			
			productDiscountMap.computeIfAbsent(product, getPriceAndThenDiscountFunction);
		}
		System.out.println(productDiscountMap);
		
		System.out.println("========== Comparator.comparing() demo ==========");
		products.sort(Comparator.comparing(Product::getPrice));
		products.sort(Comparator.comparing(product -> product.getPrice()));
		System.out.println(products);
		
	}
	
	public static String convertIntToString(Integer integer) {
		return Integer.toString(integer);
	}
	
	public static String combineIntAndString(Integer integer, String string) {
		return integer + " : " + string;
	}

}

class Product {
	private int id;
	private double price;
	
	public Product(int id, double price) {
		this.id = id;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + "]";
	}
	
	
}
