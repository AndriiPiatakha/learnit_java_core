package com.itbulls.learnit.javacore.multithreading.hw;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates work of Spam class.
 * 
 * Create stream and reset System.in to another one stream.
 * 
 * @author Andrey Pyatakha
 *
 */

public class Task2 {

	/**
	 * Enter point to the Part2.
	 * 
	 * Create stream and reset System.in to another one stream. Run the main method
	 * of Spam2 class.
	 * 
	 * After 5 seconds had passed change input stream and simulates pressing of
	 * enter key.
	 * 
	 * @param args input parameters
	 * @throws IOException          in case of Exception in main class
	 * @throws InterruptedException in case of interruption of main thread
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		ByteArrayInputStream bais = new ByteArrayInputStream(new byte[] { '\n' });
		int[] latency = { 1000, 1000, 1000, 1000, 1000, 1000 };
		String[] messages = { "First message", "Second message", "Third message", "Fourth message", "Fifth message",
				"Sixth message" };
		Spam spam = new Spam(latency, messages);

		spam.startSpam();

		TimeUnit.SECONDS.sleep(5);
		System.setIn(bais);

	}

	/**
	 * Prints specified messages after specified intervals.
	 * 
	 * Takes array of int values and array of String values as a parameters. In case
	 * if arrays got different length throws an IllegalArgumentException.
	 * 
	 * This class extends Thread. It prints to console messages after specified
	 * latency.
	 * 
	 * @author Adnrey Pyatakha
	 *
	 */

	private static class Spam implements Runnable {
		/**
		 * Array of int values which uses as latency.
		 */
		private int[] latency;

		/**
		 * Array of String values which contains elements to print to console.
		 */
		private String[] messages;

		/**
		 * Takes array of int and array of String as parameters. In case if arrays got
		 * different length throws an IllegalArgumentException.
		 * 
		 * @param latency  int values of delays between printing messages.
		 * @param messages String values to print to console.
		 */
		public Spam(int[] latency, String[] messages) {
			if (latency.length != messages.length) {
				throw new IllegalArgumentException("Error! Arrays of latency and messages aren't equal!!!");
			}
			this.latency = latency;
			this.messages = messages;
		}

		/**
		 * Prints to console messages from String array after specified delays.
		 */
		@Override
		public void run() {
			try {
				for (int i = 0; i < messages.length; i++) {
					TimeUnit.MILLISECONDS.sleep(latency[i]);
					System.out.println(messages[i]);
				}
			} catch (InterruptedException ex) {
			}
		}

		/**
		 * Listener which observes when code point of "Enter" will be appeared. Observer
		 * for the thread which takes as an argument in constructor.
		 * 
		 * @author Andrey Pyatakha
		 *
		 */

		static class Listener implements Runnable {
			/**
			 * Thread for observing.
			 */
			private Thread thread;

			/**
			 * InputStream by default.
			 */
			public static final InputStream IN_DEFAULT = System.in;

			/**
			 * Constructor. Takes another thread as a parameter to listen events in parallel
			 * and terminate another thread when event will occur.
			 * 
			 * @param thread to listen.
			 */
			public Listener(Thread thread) {
				super();
				this.thread = thread;
			}

			/**
			 * Reads from the system in and wait for the enter.
			 */
			@Override
			public void run() {
				try {
					while (true) {
						if (System.in.available() > 0 && System.in.read() == '\n') {
							System.setIn(IN_DEFAULT);
							thread.interrupt();
						}
					}
				} catch (IOException e) {
				}
			}
		}

		public void startSpam() {
			var spam = new Thread(this);
			var listener = new Thread(new Listener(spam));

			spam.start();
			listener.setDaemon(true);
		}

	}

}
