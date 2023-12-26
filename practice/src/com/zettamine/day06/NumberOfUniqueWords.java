package com.zettamine.day06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NumberOfUniqueWords {
	
	public static void main(String[] args) {

		Set<String> set = new TreeSet<String>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Students Article :");
		String string = scanner.nextLine().toLowerCase().trim();
		String[] wordsArr = string.split("[ :%*@&.?,!]+");
		System.out.println("Total no of words are : "+wordsArr.length);
		
		for(String word : wordsArr)
		{
			set.add(word);
		}
		System.out.println("Number of unique words are : "+set.size());
		
		System.out.println("The words are :");
		int i=1;
		for(String word : set)
		{
			System.out.println((i++)+". "+word);
			System.out.println();
		}
		
	}

}
