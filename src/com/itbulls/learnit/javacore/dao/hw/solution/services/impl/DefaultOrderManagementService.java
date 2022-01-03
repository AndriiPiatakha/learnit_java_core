
package com.itbulls.learnit.javacore.dao.hw.solution.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Purchase;
import com.itbulls.learnit.javacore.dao.hw.solution.services.PurchaseManagementService;


public class DefaultOrderManagementService implements PurchaseManagementService {

	private static final String ORDERS_DATA_FILE_NAME = "orders.data";
	private static final String CURRENT_TASK_RESOURCE_FOLDER = "finaltask";
	private static final String RESOURCES_FOLDER = "resources";
	
	private static DefaultOrderManagementService instance;
	private List<Purchase> orders;
	
	{
		orders = loadOrders();
	}
	
	public static PurchaseManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addPurchase(Purchase order) {
		if (order == null) {
			return;
		}
		orders.add(order);
		saveOrders(orders);
	}

	@Override
	public List<Purchase> getPurchasesByUserId(int userId) {
		return loadOrders().stream()
				.filter(Objects::nonNull)
				.filter(order -> order.getCustomerId() == userId)
				.collect(Collectors.toList());
	}

	@Override
	public List<Purchase> getPurchases() {
		if (orders == null || orders.size() == 0) {
			orders = loadOrders();
		}
		return this.orders;
	}
	
	void clearServiceState() {
		orders.clear();
	}
	
	
	private void saveOrders(List<Purchase> orders) {
		try (var oos = new ObjectOutputStream(new FileOutputStream(
					RESOURCES_FOLDER + File.separator + CURRENT_TASK_RESOURCE_FOLDER
					+ File.separator + ORDERS_DATA_FILE_NAME
				))) {
			oos.writeObject(orders);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Purchase> loadOrders() {
		try (var ois = new ObjectInputStream(new FileInputStream(
				RESOURCES_FOLDER + File.separator + CURRENT_TASK_RESOURCE_FOLDER
				+ File.separator + ORDERS_DATA_FILE_NAME
			))) {
		return (List<Purchase>) ois.readObject();
	} catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();
	}
		return null;
	}


}
