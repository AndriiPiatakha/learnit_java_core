package com.itbulls.learnit.javacore.patterns.creational.factorymethod;

import java.io.File;
import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

public class ZipArchiver implements Archiver {

	@Override
	public void archive(File directory) {
		System.out.println("Zip Archiver");
	}
	
}
