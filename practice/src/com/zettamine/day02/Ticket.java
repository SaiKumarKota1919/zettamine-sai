package com.zettamine.day02;

public class Ticket {

	private int ticketId;
	private int price;
	private static int availableTickets;
	
	
	
	public Ticket(int ticketId, int price) {
		super();
		this.ticketId = ticketId;
		this.price = price;
	}
	
	public int calculateTicketCost(int nooftickets) 
	{
		int availTickets = getAvailableTickets();
		if(availTickets>=nooftickets)
		{
			
			return nooftickets*getPrice();
		}
		else {
			return -1;
		}
		
		
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static int getAvailableTickets() {
		return availableTickets;
	}
	public static void setAvailableTickets(int availableTickets) {
		if(availableTickets<0)
		{
			System.err.println("Invalid available tickets count....try again");
			System.exit(0);
			
		}
		else {
			Ticket.availableTickets = availableTickets;

		}
			}
	
	
}
