package com.zettamine.day02;

import java.util.Scanner;

public class ValidateMobileNum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter 10 digit mobile number only :");
		String mobileNum = scanner.nextLine();
		if(mobileNum.matches("^[6-9][0-9]{9}"))
		{
			System.out.println("valid number : "+mobileNum);
		}
		else {
			System.out.println("not match");
		}
		scanner.close();
		
	}

}
