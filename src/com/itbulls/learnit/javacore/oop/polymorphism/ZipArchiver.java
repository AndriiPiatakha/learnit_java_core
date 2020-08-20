package com.itbulls.learnit.javacore.oop.polymorphism;

import java.io.File;

public class ZipArchiver implements Archiver {

	@Override
	public void archiveFiles(File... files) {
		System.out.println("Method of Zip Archiver is called");
	}
	
	public void archiveFiles(int maxArchiveSize, File... files) {
		// stub method for the demo purposes
	}

}
