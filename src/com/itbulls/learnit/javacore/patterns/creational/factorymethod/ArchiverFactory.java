package com.itbulls.learnit.javacore.patterns.creational.factorymethod;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ArchiverFactory {
	
	
	private static Map<String, Supplier<Archiver>> typeConstructorMap = new HashMap<>();
	
	static {
		typeConstructorMap.put("zip", ZipArchiver::new);
		typeConstructorMap.put("rar", RarArchiver::new);
	}

	public static Archiver getArchiver(String archiverType) {
		return typeConstructorMap.get(archiverType) == null ? null : 
					typeConstructorMap.get(archiverType).get();
	}

}
