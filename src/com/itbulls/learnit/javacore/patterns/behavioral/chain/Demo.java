package com.itbulls.learnit.javacore.patterns.behavioral.chain;

import java.util.Scanner;

public class Demo {
	private final DispenseChain dispenseChain;

	public Demo() {
		// initialize the chain
		this.dispenseChain = new Dollar50Dispenser();
		DispenseChain dispenseChain2 = new Dollar20Dispenser();
		DispenseChain dispenseChain3 = new Dollar10Dispenser();

		// set the chain of responsibility
		dispenseChain.setNextLink(dispenseChain2);
		dispenseChain2.setNextLink(dispenseChain3);

	}

	public static void main(final String[] args) {
		Demo atmDispenser = new Demo();
		while (true) {
			int amount = 0;
			System.out.print("Enter amount to dispense: ");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			// process the request
			atmDispenser.dispenseChain.dispense(new Currency(amount));
		}

	}
}
