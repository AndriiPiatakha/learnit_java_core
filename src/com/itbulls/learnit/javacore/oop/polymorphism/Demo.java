package com.itbulls.learnit.javacore.oop.polymorphism;

import java.io.File;

public class Demo {
	
	public static void main(String[] args) {
		User contentManager = new ContentManager();
		User admin = new AdminUser();
		
		contentManager.validateAccessRights();
		admin.validateAccessRights();
		
		System.out.println();
		System.out.println("==============");
		System.out.println();
		
		Archiver zipArchiver = new ZipArchiver();
		Archiver rarArchiver = new RarArchiver();
		
		zipArchiver.archiveFiles(new File(""));
		rarArchiver.archiveFiles(new File(""));
		
		System.out.println();
		System.out.println("==============");
		System.out.println();
		
		contentManager.getProfileInformtaion(new UserProfile());
		
		
		
		
	}

}
