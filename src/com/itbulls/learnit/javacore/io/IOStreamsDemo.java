package com.itbulls.learnit.javacore.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.nio.file.StandardOpenOption.*;

public class IOStreamsDemo {

	public static void main(String[] args) throws IOException {
		String filePath = "testDirectory" + File.separator + "demo.txt";
		String textToWrite = "Some text example " + System.lineSeparator() + "with Line separator and cyrylic "
				+ "characters: это символы кириллицы" + System.lineSeparator();
		
		
		//===== Write examples
		writeFileToPathFileOutputStream(filePath, textToWrite);
		writeFileToPathFileOutputStreamWithBuffer(filePath, textToWrite);
		noWriteWithoutFlush(filePath, textToWrite);
		writeFileToPathFileWriter(filePath, textToWrite);
		writeFileToPathFileWriterBuffered(filePath, textToWrite);
		
		// ===== Read examples
		printFileWithFileInputStream(filePath);
		printFileWithFileInputStreamWithBuffer(filePath);
		printFileWithFileReader(filePath);
		printFileWithBuffer(filePath);
		
		// ===== NIO write example
		writeNio(filePath, textToWrite);
		
		// ===== NIO read examples
		printFileToConsole(filePath);
		printFileToConsoleWithCustomEncoding(filePath);
		
		// ===== NIO misc demo
		findMethodDemo(filePath, 4);
		walkMethodDemo(filePath);
		
	}

	// ====================== Write examples

	private static void writeFileToPathFileOutputStream(String path, String textToWrite)
			throws FileNotFoundException, IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			byte[] bytes = textToWrite.getBytes();
			fos.write(bytes);
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}

	private static void writeFileToPathFileOutputStreamWithBuffer(String path, String textToWrite)
			throws FileNotFoundException, IOException {
		try (var fbos = new BufferedOutputStream(new FileOutputStream(path))) {
			fbos.write(textToWrite.getBytes());
		}
	}
	private static void noWriteWithoutFlush(String path, String textToWrite) throws IOException {
		var bos = new BufferedOutputStream(new FileOutputStream(path));
		bos.write(textToWrite.getBytes());
//		bos.flush();
	}

	private static void writeFileToPathFileWriter(String path, String textToWrite) throws IOException {
		try (var fw = new FileWriter(path)) {
			fw.write(textToWrite);
		}
	}

	private static void writeFileToPathFileWriterBuffered(String path, String textToWrite) throws IOException {
		try (var bfw = new BufferedWriter(new FileWriter(path))) {
			bfw.write(textToWrite);
		}
	}



	// ====================== Read examples

	private static void printFileWithFileInputStream(String path) throws IOException, FileNotFoundException {
		try (var fis = new FileInputStream(path)) {
			int i;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
			}
		}

	}

	private static void printFileWithFileInputStreamWithBuffer(String path) throws IOException, FileNotFoundException {
		try (var fis = new FileInputStream(path);
				var bis = new BufferedInputStream(fis);
				var dis = new DataInputStream(bis);
//				DataInputStream dis2 = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))	
		) {
			int i;
			
			while (dis.available() != 0) {
//				int intValue = dis.readInt();
				System.out.print(dis.readLine());
				System.out.println();
			}
		}
	}

	private static void printFileWithFileReader(String path) throws IOException, FileNotFoundException {
		try (var fr = new FileReader(path)) {
			int content;
			while ((content = fr.read()) != -1) {
				System.out.print((char) content);
			}
		}
	}

	private static void printFileWithBuffer(String path) throws FileNotFoundException, IOException {
		try (var br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	
	
	
	// ===== NIO examples write
	
	private static void writeNio(String path, String textToWrite) throws IOException {
		Files.write(Paths.get(path), textToWrite.getBytes(), CREATE, APPEND);
		List<String> lines = Arrays.asList("a", "s", "d");
		Files.write(Paths.get(path), lines, StandardCharsets.UTF_8);
	}
	
	
	
	// ===== NIO examples read
	
	public static void printFileToConsole(String path) throws IOException {
		try (Stream<String> fStream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
			fStream.forEach(System.out::println);
//			fStream.forEach((s) -> System.out.println(s));
		}

		List<String> readAllLines = Files.readAllLines(Paths.get(path));
	}


	private static void printFileToConsoleWithCustomEncoding(String path) throws IOException {
		try (Stream<String> stream = Files.lines(Paths.get(path), Charset.forName("windows-1251"))) {
			SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
			stream.forEach(System.out::println);
		}
	}

	
	// ===== NIO misc demo
	
	private static void findMethodDemo(String path, int maxDepth) throws IOException {
		Path start = Paths.get(path);
		try (Stream<Path> stream = Files
				.find(start, maxDepth, (specificPath, attr) -> String.valueOf(specificPath)
				.endsWith(".java"))) {
			String joined = stream
					.sorted()
					.map(String::valueOf)
					.collect(Collectors.joining(";"));
			if (joined != null && !joined.isEmpty()) {
				System.out.println("Found: " + joined);
			}
		}
	}

	private static void walkMethodDemo(String path) throws IOException {
		Files.walk(Paths.get(path))
			.filter(p -> p.toString().endsWith(".ext"))
			.map(p -> p.getParent().getParent())
			.distinct()
			.forEach(System.out::println);
	}

}
