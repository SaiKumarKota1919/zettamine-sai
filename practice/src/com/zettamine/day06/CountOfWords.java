package com.zettamine.day06;

import java.util.Scanner;

public class CountOfWords {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		System.out.println("Enter Student's Article ");
		printNoOfWords(scanner.nextLine());
		
			}

	private static void printNoOfWords(String string) {
		
		String[] wordsArr = string.split("[ :%*@&.?,!]+");
		
	}

}
