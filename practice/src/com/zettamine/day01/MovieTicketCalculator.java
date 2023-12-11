package com.zettamine.day01;

import java.util.Scanner;

public class MovieTicketCalculator {
	private static int minTickets = 5;
	private static int maxTickets = 40;
	private static int refreshementCostPerPerson = 50;
	private static int kingCircleCost = 75;
	private static int queenCircleCost = 150;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Instructions : Y-Yes, N-NO, K-King, Q-queen");
		System.out.print("Enter the no of ticket: ");
		int noOfTickets = scanner.nextInt();
		if(noOfTickets>minTickets && noOfTickets<maxTickets)
		{
			calculateCostOfTickets(noOfTickets);
		}
		else {
			System.err.print("Minimum of 5 and Maximum of 40 Tickets");
		}
		
		
		
	}

	private static void calculateCostOfTickets(int noOfTickets) {
		
		
		System.out.print("Do you want refreshment: ");
		boolean needRefreshments  = scanner.next().charAt(0)=='Y'?true:false;
		
		System.out.print("Do you have coupon code: ");
		boolean applyCouponCode = scanner.next().charAt(0)=='Y'?true:false;
		System.out.print("Enter the circle:");
		char circle = scanner.next().charAt(0);
		if(circle=='K')
		{
			System.out.println("Total Cost:"+ getTotalCost(kingCircleCost,needRefreshments,applyCouponCode,noOfTickets));
			
		}
		else if (circle=='Q') {
			System.out.printf("Total Cost:%.2f",getTotalCost(queenCircleCost, needRefreshments, applyCouponCode,noOfTickets));
			
		}
		else {
			System.err.println("Invalid Input for Circle");
		}
		
	}

	private static double getTotalCost(int circleCost, boolean needRefreshments, boolean applyCouponCode, int noOfTickets) {
		
		double totalCost = (circleCost)*noOfTickets;
		if(noOfTickets>20)
		{
			totalCost = totalCost-(totalCost*0.1);
		}
		if(applyCouponCode)
		{
			totalCost = totalCost-(totalCost*0.02);
		}
		if(needRefreshments)
		{
			totalCost = totalCost+(noOfTickets*refreshementCostPerPerson);
		}
		
		return totalCost;
		
	}

}
