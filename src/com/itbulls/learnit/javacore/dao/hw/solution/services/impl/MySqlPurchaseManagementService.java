package com.itbulls.learnit.javacore.dao.hw.solution.services.impl;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.dao.PurchaseDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dao.impl.MySqlJdbcPurchaseDao;
import com.itbulls.learnit.javacore.dao.hw.solution.dto.PurchaseDto;
import com.itbulls.learnit.javacore.dao.hw.solution.dto.converter.PurchaseDtoToPurchaseConverter;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Purchase;
import com.itbulls.learnit.javacore.dao.hw.solution.services.PurchaseManagementService;

public class MySqlPurchaseManagementService implements PurchaseManagementService {
	
	private PurchaseDao purchaseDao;
	private PurchaseDtoToPurchaseConverter purchaseConverter;
	
	{
		purchaseDao = new MySqlJdbcPurchaseDao();
		purchaseConverter = new PurchaseDtoToPurchaseConverter();
	}

	@Override
	public void addPurchase(Purchase purchase) {
		purchaseDao.savePurchase(purchaseConverter.convertPurchaseToPurchaseDto(purchase));
	}

	@Override
	public List<Purchase> getPurchasesByUserId(int userId) {
		List<PurchaseDto> purchasesDtos = purchaseDao.getPurchasesByUserId(userId);
		return purchaseConverter.convertPurchaseDtosToPurchases(purchasesDtos);
	}

	@Override
	public List<Purchase> getPurchases() {
		List<PurchaseDto> purchasesDtos = purchaseDao.getPurchases();
		return purchaseConverter.convertPurchaseDtosToPurchases(purchasesDtos);
	}

}
