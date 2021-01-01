package com.itbulls.learnit.javacore.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemoNio {
	
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("testDirectoryNio", "innerTestDirectoryNio");
		
		Files.isDirectory(path);
		Files.isRegularFile(path);
		Files.createDirectories(path);
		
		Path filePath = Paths.get("testDirectoryNio", "result.csv");
		if (!Files.exists(filePath)) {
			Files.createFile(filePath);
		}
		
		Files.delete(path);
	}

}
