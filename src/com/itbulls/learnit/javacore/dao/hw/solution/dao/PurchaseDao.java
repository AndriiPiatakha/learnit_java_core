package com.itbulls.learnit.javacore.dao.hw.solution.dao;

import java.util.List;

import com.itbulls.learnit.javacore.dao.hw.solution.dto.PurchaseDto;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Purchase;

public interface PurchaseDao {
	
	void savePurchase(PurchaseDto order);

	List<PurchaseDto> getPurchasesByUserId(int userId);
	
	List<PurchaseDto> getPurchases();

}
