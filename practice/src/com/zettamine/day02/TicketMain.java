package com.zettamine.day02;

import java.util.Scanner;

public class TicketMain {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);    
	
	//reading ticket details form the user
	System.out.print("Enter no of bookings: ");
	int noOfBookings = scanner.nextInt();
	System.out.print("Enter the available tickets: ");
	int availTickets = scanner.nextInt();
	Ticket.setAvailableTickets(availTickets);
	for(int i=0;i<noOfBookings&&Ticket.getAvailableTickets()>0;i++)
	{
		// reading tickect details based on no of bookings
		System.out.print("Enter the ticket id :");
		int tId = scanner.nextInt();
		System.out.print("Enter the price: ");
		int tPrice = scanner.nextInt();
		System.out.print("Enter the no of tickets: ");
		int noOftickets = scanner.nextInt();
		
		System.out.println();
		if(!isBookingSuccess(tPrice,noOftickets,tId))
		{
			System.out.println("tickets "+noOftickets+" are not available!!");
		}
		else {
			Ticket.setAvailableTickets(Ticket.getAvailableTickets()-noOftickets);
			System.out.println("Available ticket after booking: "+Ticket.getAvailableTickets());
		}
		System.out.println();
		
		
	}
	scanner.close();
	
}

private static boolean isBookingSuccess( int tPrice, int noOtickets, int tId) {
	
	
	Ticket ticket = new Ticket(tId, tPrice);
	int avaiTickets =Ticket.getAvailableTickets();
	int totalPrice = ticket.calculateTicketCost(noOtickets);
	if(totalPrice>0)
	{
		System.out.println("Available tickets: "+avaiTickets);
		System.out.println("Total amount: "+totalPrice);
		
		return true;
	}

	return false;
}
	
}
