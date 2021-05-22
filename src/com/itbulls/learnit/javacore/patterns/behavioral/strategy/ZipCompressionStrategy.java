package com.itbulls.learnit.javacore.patterns.behavioral.strategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ZipCompressionStrategy implements CompressionStrategy {

	@Override
	public void compressFiles(List<File> files) {
		//using ZIP approach
		System.out.println("Zip compression");
	}

}