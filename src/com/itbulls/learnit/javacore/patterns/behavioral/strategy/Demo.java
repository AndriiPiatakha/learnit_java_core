package com.itbulls.learnit.javacore.patterns.behavioral.strategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	
	public static void main(String[] args) {

		CompressionContext ctx = new CompressionContext();
		ctx.setCompressionStrategy(new ZipCompressionStrategy());

		// get a list of files...
		List<File> fileList = new ArrayList<>();
		ctx.createArchive(fileList);
		
		ctx.createArchive(fileList, file -> System.out.println("Any compression strategy here"));
		ctx.createArchive(fileList, Demo::customCompressStrategy);
		
		
		// Comparator is also strategy pattern.
		fileList.sort( (file1, file2) -> file1.getName().compareTo(file2.getName()));

	}
	
	public static void customCompressStrategy(List<File> files) {
		System.out.println("Custom compression strategy");
	}

}
