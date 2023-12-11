package com.zettamine.day01;

import java.util.Scanner;

public class NumberToWords {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("enter a number : ");
		int number = scanner.nextInt();
		String word = "";
		int tempNum = number;
		//StringBuffer stringBuffer = new StringBuffer("");
		
	
		while(number>0)
		{
			int digit = number%10;
			
			
			word = digitToWord(digit)+word;
			
			number = number/10;
		}
		
		System.out.println("word format for the number is "+tempNum+" -----> "+word);
		scanner.close();
	}



	private static String digitToWord(int number) {

		switch (number) {
		case 0: return "zero ";
		case 1: return "one ";
		case 2: return "two ";
		case 3: return "three ";
		case 4: return "four ";
		case 5: return "five ";
		case 6: return "six ";
		case 7: return "seven ";
		case 8: return "eight ";
		case 9: return "nine ";
		
		default:return "";
			
		}
		
		
		
		
	}

}
