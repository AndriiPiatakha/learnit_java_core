package com.itbulls.learnit.javacore.dao.hw.solution.services;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Purchase;

public interface PurchaseManagementService {

	void addPurchase(Purchase purchase);

	List<Purchase> getPurchasesByUserId(int userId);
	
	List<Purchase> getPurchases();
}
