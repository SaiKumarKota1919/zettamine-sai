package com.zettamine.day03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatedWords {
	public static void main(String[] args) {
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String :");
		String string = scanner.nextLine();
		String[] wordsArr = string.split("[ %*@&.?,!]+");
		System.out.println("Total no of words are : "+wordsArr.length);
		
		for(String word : wordsArr)
		{
			if(wordMap.containsKey(word))
			{
				wordMap.put(word, wordMap.get(word)+1);
				
			}
			else {
				wordMap.put(word, 1);
			}
		}
		System.out.println("No of unique words: "+wordMap.size());
		System.out.println("Repeated words are : ");
		for(Map.Entry<String, Integer> entry:wordMap.entrySet())
		{
			if(entry.getValue()>1)
			{
				System.out.println(entry.getKey()+" - "+entry.getValue());
			}
		}
	}

}
