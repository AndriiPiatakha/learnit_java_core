package com.itbulls.learnit.javacore.patterns.behavioral.strategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//Strategy Interface
@FunctionalInterface
public interface CompressionStrategy {
	void compressFiles(List<File> files);
}
