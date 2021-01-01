package com.itbulls.learnit.javacore.io.hw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class ConfigMapHw {
	
	public String getValueFromConfigMap(String configMapFilePath, String keyName) throws IOException {
		if (configMapFilePath == null || keyName == null) {
			return null;
		}
		Map<String, String> collect = Files.lines(Paths.get(configMapFilePath))
				.collect(Collectors.toMap(line -> ((String)line).split("=")[0], 
											line -> ((String)line).split("=")[1]));
		
		return collect.get(keyName);
	}

}
