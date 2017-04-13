package com.mitrais.java8;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileReadWrite {
	
	
	
	/**
	 * printNLetterWord with n = size, only print the First one
	 * @param file
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public static String printNLetterWord(String file, int size) throws Exception{
		
		String result = Files.lines(Paths.get(file))
				.filter(w -> w.length() == size)
				.findFirst()
				.orElse("null");
		
		System.out.printf("First %s-letter word is: %s%n", size , result);
		
		return result;
		
	}
	
	/**
	 * prinntNLetterWordWith n = size, and contain some word, only print the First one
	 * @param file
	 * @param size
	 * @param word
	 * @return
	 * @throws Exception
	 */
	public static String printNLetterWordWith(String file, int size, String word) throws Exception{
		
		String result = Files.lines(Paths.get(file))
				.filter(w -> w.length() == size && w.contains(word))
				.findFirst()
				.orElse("null");
		
		System.out.printf("First %s-letter word that contain \"%s\" is: %s%n", size, word, result);
		
		return result;
	}
	
	/**
	 * count how many lines in a file
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static int countLine(String file) throws Exception {
		
		int result = Files.lines(Paths.get(file)).collect(Collectors.toList()).size();
		
		System.out.printf("There are %s lines in %s%n", result, file);
		
		return result;
	}
	
	/**
	 * Write randomWordsGenerate to a file, with certain lengthPerWord and line
	 * @param line
	 * @param lengthPerWord
	 * @param outputFile
	 */
	public static void randomWordsGenerator(int line, int lengthPerWord, String outputFile) {
		
		
		try (PrintWriter out =
			      new PrintWriter(Files.newBufferedWriter(
			    		  Paths.get(outputFile)
			    		  ,Charset.defaultCharset()))){
			
			String word = "";
			for (int i = 0 ; i < line; i++) {
				
				for (int j = 0 ; j < lengthPerWord; j++) {
					
					word += (char)(Math.random() * 26 + 97);
				}
				
				out.printf("%s%n", word);
				System.out.printf("%s%n", word);
				
				word = "";
			}
			
		} catch (IOException ioe) {
			// TODO: handle exception
			System.err.printf("IOException: %s%n", ioe);
		}
	}

}
