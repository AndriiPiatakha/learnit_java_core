package com.itbulls.learnit.javacore.multithreading.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Task4_2 {

	private static final int COLUMNS = 100;
	private static final int ROWS = 4;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[][] matrix = SearchEngine.createRandomMatrix(ROWS, COLUMNS);

		SearchEngine se = new SearchEngine(matrix);

		System.out.println("=======  Demo of Multithreading Search ========");
		System.out.println("Max element in matrix: " + se.getMaxElementInMatrixMultiThreading());
		System.out.println("Time of multithreading search: " + se.getTimeOfMultiThreadingSearch());

		System.out.println();
		System.out.println("======= Demo of Single-thread Search ========");
		System.out.println("Max element in matrix: " + se.getMaxElementInMatrixSingleThreading());
		System.out.println("Time of singlethreading search: " + se.getTimeOfSingleThreadingSearch());

		System.out.println("\nPrinting the futureList: ");

		se.getListWithMaximumNumbersInRow().stream().forEach(System.out::println);
	}

	

	private static class SearchEngine {

		private int[][] matrix;
		private int maxInMatrix;
		private long timeOfMultiThreadingSearch;
		private long timeOfSingleThreadingSearch;
		private CountDownLatch countDownLatch;
		private List<Integer> maximumNumbersInEachRow;

		public SearchEngine(int[][] matrix) {
			this.matrix = matrix;
			maximumNumbersInEachRow = new ArrayList<>();
			countDownLatch = new CountDownLatch(matrix.length);
		}

	
		public long getTimeOfMultiThreadingSearch() {
			return timeOfMultiThreadingSearch;
		}


		public long getTimeOfSingleThreadingSearch() {
			return timeOfSingleThreadingSearch;
		}


		public List<Integer> getListWithMaximumNumbersInRow() {
			return this.maximumNumbersInEachRow;
		}


		public int getMaxElementInMatrixMultiThreading() throws InterruptedException, ExecutionException {
			Runnable[] arrFinders = createFindersForArray(this.matrix);
			long start = System.nanoTime();
			runFinders(arrFinders);
			countDownLatch.await(10, TimeUnit.SECONDS);
			maxInMatrix = findMaxOfAllThreads(this.maximumNumbersInEachRow);
			long finish = System.nanoTime();
			timeOfMultiThreadingSearch = (finish - start) / 1_000_000;
			return maxInMatrix;
		}

		private Runnable[] createFindersForArray(int[][] matrix) {
			Finder[] finders = new Finder[matrix.length];
			IntStream.range(0, finders.length).forEach(i -> finders[i] = new Finder(i));
			return finders;
		}


		private void runFinders(Runnable[] arrFinders) throws InterruptedException {
			ExecutorService es = Executors.newCachedThreadPool();
			for (Runnable task : arrFinders) {
				es.execute(task);
			}
			es.shutdown();
		}


		private int findMaxInRow(int row) throws InterruptedException {
			int maxInRow = matrix[row][0];
			for (int j = 1; j < matrix[row].length; j++) {
				TimeUnit.MILLISECONDS.sleep(1);
				if (maxInRow < matrix[row][j]) {
					maxInRow = matrix[row][j];
				}
			}
			return maxInRow;
		}

		private int findMaxOfAllThreads(List<Integer> maxInts) {
			return maxInts.stream().mapToInt(i -> i)
							.max().getAsInt();
		}


		public int getMaxElementInMatrixSingleThreading() throws InterruptedException {
			long start = System.nanoTime();
			int maxInRow = matrix[0][0];
			int max = matrix[0][0];
			for (int i = 0; i < matrix.length; i++) {
				maxInRow = findMaxInRow(i);
				if (maxInRow > max) {
					max = maxInRow;
				}
			}
			long finish = System.nanoTime();
			timeOfSingleThreadingSearch = (finish - start) / 1_000_000;
			return max;
		}


		public static int[][] createRandomMatrix(int rows, int cols) {
			Random random = new Random();
			int[][] matrix = new int[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					matrix[i][j] = random.nextInt();
				}
			}
			return matrix;
		}

	
		private class Finder implements Runnable {


			private int threadId;


			public Finder(int threadId) {
				this.threadId = threadId;
			}


			@Override
			public void run() {
				int maxOfThread = Integer.MIN_VALUE;
				try {
					maxOfThread = findMaxInRow(threadId);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				SearchEngine.this.maximumNumbersInEachRow.add(maxOfThread);
				SearchEngine.this.countDownLatch.countDown();
			}

		}

	}
}
