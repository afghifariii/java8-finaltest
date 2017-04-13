package com.mitrais.java8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class FileReadWriteTest {
	String inputFile = "random-words.txt";

	@Test
	public void printNLetterWord() throws Exception {
		
		//Wrong scenario test case
		assertEquals(FileReadWrite.printNLetterWord(inputFile, 1_000), "null");
		
		//Correct scenario testCase
		assertEquals(FileReadWrite.printNLetterWord(inputFile, 3), "aah");
		
	}

	@Test
	public void printNLetterWordWith() throws Exception {
		
		//Wrong scenario test case
		assertEquals(FileReadWrite.printNLetterWordWith(inputFile, 1_000, "x@#$!@#"), "null");
		
		//Correct scenario testCase
		assertEquals(FileReadWrite.printNLetterWordWith(inputFile, 5, "aa"), "aahed");
		
	}
	
	@Test
	public void countLine() throws Exception {
		
		assertEquals(FileReadWrite.countLine(inputFile), 172_820);
	}
	
	@Test
	public void randomWords() throws Exception {
		int line = 10;
		int length = 5;
		String outputFile = "random-words-generated.txt";
		
		FileReadWrite.randomWordsGenerator(line, length, "random-words-generated.txt");
		
		assertNotNull(Paths.get(outputFile));
		List<String> result = Files.lines(Paths.get(outputFile)).collect(Collectors.toList());
		assertEquals(result.size(), line);
	}

}
