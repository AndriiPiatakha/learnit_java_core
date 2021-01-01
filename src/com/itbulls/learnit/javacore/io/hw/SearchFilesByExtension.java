package com.itbulls.learnit.javacore.io.hw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class SearchFilesByExtension {

	public long getNumberOfFilesWithExtension(Path pathToStartSearch, String extension) throws IOException {
		if (pathToStartSearch == null || extension == null || extension.isEmpty()) {
			return 0;
		}
		long result = 0;
		try (Stream<Path> stream = Files
				.find(pathToStartSearch, Integer.MAX_VALUE, (specificPath, attr) 
						-> String.valueOf(specificPath).endsWith(extension))
				
				) {
			return stream.count();
		}
		
	}

}
