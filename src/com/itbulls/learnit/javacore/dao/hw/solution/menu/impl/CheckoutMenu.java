package com.itbulls.learnit.javacore.dao.hw.solution.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.dao.hw.solution.configs.ApplicationContext;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.Purchase;
import com.itbulls.learnit.javacore.dao.hw.solution.enteties.impl.DefaultPurchase;
import com.itbulls.learnit.javacore.dao.hw.solution.menu.Menu;
import com.itbulls.learnit.javacore.dao.hw.solution.services.PurchaseManagementService;
import com.itbulls.learnit.javacore.dao.hw.solution.services.impl.DefaultOrderManagementService;
import com.itbulls.learnit.javacore.dao.hw.solution.services.impl.MySqlPurchaseManagementService;

public class CheckoutMenu implements Menu {

	private static final String CONRIMATION_CREDIT_CARD_WORD = "confirm";
	
	private ApplicationContext context;
	private PurchaseManagementService purchaseManagementService;
	
	{
		context = ApplicationContext.getInstance();
		purchaseManagementService = new MySqlPurchaseManagementService();
	}
	
	@Override
	public void start() {
		while (true) {
			printMenuHeader();
			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();

			if (!createOrder(userInput)) {
				continue;
			}
			context.getSessionCart().clear();
			break;
		}
		
		System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
		new MainMenu().start();

	}
	
	private boolean createOrder(String creditCardNumber) {
		Purchase order = new DefaultPurchase();
		if (creditCardNumber.equalsIgnoreCase(CONRIMATION_CREDIT_CARD_WORD)) {
			creditCardNumber = context.getLoggedInUser().getCreditCard();
		}
		
		if (!order.isCreditCardNumberValid(creditCardNumber)) {
			return false;
		}
		
		order.setCreditCardNumber(creditCardNumber);
		order.setProducts(context.getSessionCart().getProducts());
		order.setCustomerId(context.getLoggedInUser().getId());
		purchaseManagementService.addPurchase(order);
		return true;
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** CHECKOUT *****");
		String creditCard = context.getLoggedInUser().getCreditCard();
		if (creditCard != null && !creditCard.isEmpty()) {
			System.out.println("Confirm your credit card number \"" + creditCard + "\" by writing \"" + CONRIMATION_CREDIT_CARD_WORD + "\": ");
		} else {
			System.out.print(
					"Enter your credit card number without spaces and press enter to confirm purchase: ");
		}
	}

}
