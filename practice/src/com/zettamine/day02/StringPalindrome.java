package com.zettamine.day02;

import java.util.Scanner;

public class StringPalindrome {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a String :");
		String string = scanner.nextLine();
		
		StringBuffer stringBuffer = new StringBuffer(string).reverse();
		if(stringBuffer.toString().equals(string))
		{
			System.out.println("Given String is a pallindrome");
		}
		else {
			System.out.println("Not a Pallindrom");
		}
		scanner.close();
		
	}

}
