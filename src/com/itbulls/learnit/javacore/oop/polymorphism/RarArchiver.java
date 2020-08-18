package com.itbulls.learnit.javacore.oop.polymorphism;

import java.io.File;

public class RarArchiver implements Archiver {

	@Override
	public void archiveFiles(File... files) {
		System.out.println("Method of Rar Archiver is called");
	}

}
