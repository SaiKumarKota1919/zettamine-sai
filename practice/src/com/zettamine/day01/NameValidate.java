package com.zettamine.day01;

import java.util.Scanner;

public class NameValidate {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Inmate's name: ");
		String name = scanner.nextLine();
		System.out.print("Inmate's father's name: ");
		String fathersName = scanner.nextLine();
		System.out.println(validateName(name+" "+fathersName));
		scanner.close();
	}
	public static boolean isValidName(String name)
	{
		if(name.matches("^[a-zA-Z ]+$"))
		{
			return true;
			
		}
		else {
			return false;
		}
	}

	public static String validateName(String string) {


		if(!string.matches("^[a-zA-Z ]+$"))
		{
			return "\u001B[31mInvalid name\u001B[30m "+string;
		}
		return string.toUpperCase().replaceAll("\\s+", " ").trim();
	}

}
