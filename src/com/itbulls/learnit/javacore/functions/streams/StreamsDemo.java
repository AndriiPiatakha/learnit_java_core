package com.itbulls.learnit.javacore.functions.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {
		System.out.println("========== filter() & map() & collect() demo ==========");
		List<Product> products = new ArrayList<>(Arrays.asList(
					new Product("iPhone", 1099.99, 1345),
					new Product("Boots", 49.99, 15200),
					new Product("HP Laptop", 2599.99, 876),
					new Product("SSD", 239.99, 900),
					new Product("Sony PlayStation", 2009.99, 1001)
				));
		
		List<Product> modifiedProducts = products.stream()
				.filter(product -> product.getItemsInWarehouse() > 1000)
				.map(product -> {
					product.setPrice(product.getPrice() - (product.getPrice() * 0.1));
					return product;
				})
				.collect(Collectors.toList());
		
		modifiedProducts.stream().forEach(System.out::println);
		
		System.out.println("========== flatMap() demo ==========");
		
		Warehouse warehouse1 = new Warehouse();
		Warehouse warehouse2 = new Warehouse();
		Warehouse warehouse3 = new Warehouse();
		
		warehouse1.setProducts(Arrays.asList(new Product("iPhone", 1099.99, 1345)));
		warehouse2.setProducts(Arrays.asList(new Product("Boots", 49.99, 15200), 
				new Product("HP Laptop", 2599.99, 876)));
		warehouse3.setProducts(Arrays.asList(new Product("SSD", 239.99, 900), 
				new Product("Sony PlayStation", 2009.99, 1001)));
		
		List<Warehouse> warehouses = new ArrayList<>(Arrays.asList(
					warehouse1,
					warehouse2,
					warehouse3
				));
		
		Product[] productsArray = warehouses.stream()
					.flatMap(warehouse -> warehouse.getProducts().stream())
					.filter(product -> product.getItemsInWarehouse() > 1000)
					.map(product -> {
						product.setPrice(product.getPrice() - (product.getPrice() * 0.1));
						return product;
					})
					.toArray(Product[]::new);
		
		Arrays.stream(productsArray).forEach(System.out::println);
		
		System.out.println("========== toMap() demo ==========");
		Map<String, Product> productMap = products.stream()
				.collect(Collectors.toMap(Product::getName, Function.identity()));
		
		System.out.println(productMap);
		
		System.out.println("========== mapToInt() & sum() demo ==========");
		
		int totalItemsAmount = products.stream()
				.mapToInt(product -> product.getItemsInWarehouse())
				.sum();
		System.out.println("Items in warehouse: " + totalItemsAmount);
		
	}
}

class Product {
	private String name;
	private double price;
	private int itemsInWarehouse;
	
	public Product(String name, double price, int itemsInWarehouse) {
		this.name = name;
		this.price = price;
		this.itemsInWarehouse = itemsInWarehouse;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getItemsInWarehouse() {
		return itemsInWarehouse;
	}
	public void setItemsInWarehouse(int itemsInWarehouse) {
		this.itemsInWarehouse = itemsInWarehouse;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", itemsInWarehouse="
				+ itemsInWarehouse + "]";
	}
	
}

class Warehouse {
	private List<Product> products;
	
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}