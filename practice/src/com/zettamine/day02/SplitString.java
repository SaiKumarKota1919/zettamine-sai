package com.zettamine.day02;

import java.util.Arrays;
import java.util.Scanner;


public class SplitString {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String[] arrOfWords = string.split("[ %*@&.?,!]+"); // java is a programming language used for developing platform independent Application.
		
		System.out.println(Arrays.toString(arrOfWords));
		System.out.println("no of words :" +arrOfWords.length);//java, is!a programming* language,used%for developing* platform@independent Application.
		scanner.close();
	} 

}
