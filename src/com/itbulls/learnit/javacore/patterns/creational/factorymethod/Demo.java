package com.itbulls.learnit.javacore.patterns.creational.factorymethod;

import java.io.File;

public class Demo {
	
	public static void main(String[] args) {
		Archiver arc1 = ArchiverFactory.getArchiver("zip");
		Archiver arc2 = ArchiverFactory.getArchiver("rar");
		
		arc1.archive(new File(""));
		arc2.archive(new File(""));
		
		System.out.println(ArchiverFactory.getArchiver("zip") == arc1);
	}

}
