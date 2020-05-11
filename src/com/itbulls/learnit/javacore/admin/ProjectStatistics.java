package com.itbulls.learnit.javacore.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProjectStatistics {

	private static final String SRC_FOLDER_NAME = "src";
	private static final String TEST_FOLDER_NAME = "test";
	private static final String JAVA_FILES_EXXTENSION = ".java";
	private static final int MAX_DEPTH_OF_PACKAGES = Integer.MAX_VALUE;

	public static void main(String[] args) {
		long sourceFiles = calculateJavaFilesInProject();
		long testsAmount = calculateTestsInProject();

		System.out.println("Java source files: \t\t" + sourceFiles);
		System.out.println("Tests: \t\t\t\t" + testsAmount);
		System.out.println("Total amount of Java files: \t" + (testsAmount + sourceFiles));
	}

	private static long calculateTestsInProject() {
		try {
			return Files.find(Paths.get(TEST_FOLDER_NAME), MAX_DEPTH_OF_PACKAGES,
					(path, attr) -> {
						return path.getFileName().toString()
								.endsWith(JAVA_FILES_EXXTENSION);
					}).count();
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	private static long calculateJavaFilesInProject() {
		try {
			return Files.find(Paths.get(SRC_FOLDER_NAME), MAX_DEPTH_OF_PACKAGES,
					(path, attr) -> {
						return path.getFileName().toString()
								.endsWith(JAVA_FILES_EXXTENSION);
					}).count();
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
