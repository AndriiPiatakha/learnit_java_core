package com.itbulls.learnit.javacore.patterns.behavioral.observer;

import java.util.Scanner;

public class Demo {
    public static void main( String[] args ) {
        OnlineStore store = new OnlineStore();
        
        new B2CCustomer(store);
        new B2BCustomer(store);
        new B2CCustomer(store);
        
        Scanner sc = new Scanner(System.in);
        boolean isArrived = false;
        while (!isArrived) {
        	System.out.print("Are goods arrived to the store? ");
        	isArrived = sc.nextBoolean();
        }
		store.setState(isArrived);
    }
}
