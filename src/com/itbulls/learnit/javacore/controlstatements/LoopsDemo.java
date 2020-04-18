package com.itbulls.learnit.javacore.controlstatements;

public class LoopsDemo {
	
	public static void main(String[] args) {
		
		System.out.println("=========== for loop");
		for (int i = 0; i < 5; i++) {
			System.out.println("counter: " + i);
		}
		
		// Infinite loop
//		for (;;) {
//			
//		}
		
		System.out.println("=========== while loop");
		int counter = 0;
		while (counter < 5) {
			System.out.println("counter: " + counter++);
		}
		
		// Infinite loop
//		while (true) {
//			
//		}
		
		System.out.println("=========== do-while loop");
		counter = 0;
		do {
			System.out.println("counter: " + counter++);
		} while (counter < 5);
		
		do {
			System.out.println("counter is five already: " + counter);
		} while (counter < 5);
		
		System.out.println("=========== foreach loop");
		int[] arr = {1, 2, 3};
		for (int number : arr) {
			System.out.println("Number: " + number);
		}
		
		System.out.println("=========== nested loop");
		for (int i = 0; i < 5; i++) {
			System.out.println("*** i = " + i + " ***");
			for (int j = 0; j < 3; j++) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
		
		System.out.println("=========== continue");
		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println("counter: " + i);
		}
		
		System.out.println("=========== break");
		for (int i = 0; i < 5; i++) {
			if (i == 3) {
				break;
			}
			System.out.println("counter: " + i);
		}
		
		System.out.println("=========== labels");
		loop1: for (int i = 0; i < 5; i++) {
				System.out.println("counter i: " + i);
			loop2: for (int j = 0; j < 5; j++) {
					System.out.println("counter j: " + j);
						if (j >= 0 && j < 3) {
							System.out.println("continue loop2");
							continue loop2;
						} else {
							System.out.println("break loop1");
							break loop1;
						}
						
					}
		}
		
	}

}
