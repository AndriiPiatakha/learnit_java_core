package com.itbulls.learnit.javacore.patterns.creational.prototype;

import java.io.File;
import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

public class ZipArchiver implements Archiver, Serializable {

	@Override
	public void archive(File directory) {
		System.out.println("Zip Archiver");
	}

	@Override
	public Archiver clone() {
		return (Archiver) SerializationUtils.clone(this);
	}
	
}
