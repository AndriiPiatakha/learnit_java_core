package com.itbulls.learnit.javacore.patterns.creational.prototype;

import java.io.File;

public class Demo {
	
	public static void main(String[] args) {
		
		String archiverType1 = "zip";
		String archiverType2 = "rar";
		
		Archiver zipArchiver = ArchiverFactory.getPrototypeForType(archiverType1);
		Archiver rarArchiver = ArchiverFactory.getPrototypeForType(archiverType2);
		
		zipArchiver.archive(new File(""));
		rarArchiver.archive(new File(""));
	}

}
