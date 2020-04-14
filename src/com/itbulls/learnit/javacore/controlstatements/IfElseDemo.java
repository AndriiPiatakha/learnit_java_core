package com.itbulls.learnit.javacore.controlstatements;

public class IfElseDemo {
	
	public static void main(String[] args) {
		int amountOfMoneyOnAccount = 100;
		int itemPrice = 200;
		
		if (amountOfMoneyOnAccount < itemPrice) {
			System.out.println("You don't have enough money on your account to purchase "
					+ "this item.");
		} else {
			// purchase logic implementation here
			System.out.println("Item is purchased");
		}
		
		// ============== No braces demo
		
		amountOfMoneyOnAccount += 200;
		if (amountOfMoneyOnAccount < itemPrice) 
			System.out.println("You don't have enough money on your account to purchase " + "this item.");
		else 
			// purchase logic implementation here
			System.out.println("Item is purchased");
			System.out.println("I'm not in else block here");
		
		// ============== Nested if statement
		
		int i1 = 3;
		int i2 = 2;
		int i3 = 10;
		if (i1 > i2) {
			if (i1 > i3) 
				System.out.println("i1 is more than i2 and i3");
			else
				System.out.println("i1 is more than i2 but less than i3");
		}
		
		// ============== if - else - if
		
		int orderPrice = 1000;
		
		if (orderPrice > 0 && orderPrice < 100) {
			System.out.println("You have 5% discount for this order");
		} else if (orderPrice >= 100 && orderPrice < 500) {
			System.out.println("You have 10% discount for this order");
		} else if (orderPrice >= 500 && orderPrice < 5000) {
			System.out.println("You have 15% discount for this order");
		} 
		
	}

}
