package com.itbulls.learnit.javacore.patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class ArchiverFactory {
	
	private static Map<String, Archiver> prototypes = new HashMap<>();
	
	static {
		prototypes.put("zip", new ZipArchiver());
		prototypes.put("rar", new RarArchiver());
	}

	public static Archiver getPrototypeForType(String archiverType) {
		return prototypes.get(archiverType).clone();
	}

}
