package com.zettamine.day04.accountmanipulation;

import java.util.Scanner;

public class BankingApp {

	
	public static void main(String[] args) {
		Account account;
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter A/C number: ");
		int accountNo = scanner.nextInt();
		System.out.print("enter customer id: ");
		int cId = scanner.nextInt();
		scanner.nextLine();
		System.out.print("enter customer name : ");
		String name = scanner.nextLine();
		System.out.print("enter customer email : ");
		String email = scanner.nextLine();
		System.out.println("enter balance : ");
		double balance = scanner.nextDouble();
		System.out.print("enter minimum balance : ");
		double minBal = scanner.nextDouble();
		System.out.println();
		System.out.print("enter amount to withdraw : ");
		double amount  =scanner.nextDouble();
		
		account = new SavingsAccount(accountNo, new Customer(cId, name, email),balance,minBal);
		
		if(account.withdraw(amount))
		{
			System.out.println();
			System.out.printf("Rs.%.2f debited | Balance: Rs. %.2f",amount,account.getBalance());
		}
		else {
			System.err.println("insufficient balance try again!!! ");
		}
		
		scanner.close();
	}
}
