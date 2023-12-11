package com.zettamine.day01;

import java.util.Scanner;


public class DisplayCharacter {
	public static void main(String[] args) {
		int num1,num2,num3,num4;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 4 Numbers:");
		num1 = scanner.nextInt();
		num2 = scanner.nextInt();
		num3 = scanner.nextInt();
		num4 = scanner.nextInt();
		printChartecter(num1,num2,num3,num4);
		scanner.close();
	}

	private static void printChartecter(int... num) {
		
		for(int n :num)
		{
			System.out.println(n+"-"+(char)n);
		}
		
	}

}
