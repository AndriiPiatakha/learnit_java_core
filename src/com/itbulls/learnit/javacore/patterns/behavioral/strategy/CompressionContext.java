package com.itbulls.learnit.javacore.patterns.behavioral.strategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CompressionContext {

	private CompressionStrategy strategy;

	// this can be set at runtime by the application preferences

	public void setCompressionStrategy(CompressionStrategy strategy) {
		this.strategy = strategy;
	}

	// use the strategy
	public void createArchive(List<File> files) {
		// do smth
		strategy.compressFiles(files);
		// do smth
	}
	
	// or just pass strategy to the method
	public void createArchive(List<File> files, CompressionStrategy cs) {
		// do smth
		cs.compressFiles(files);
		// do smth
	}

}
