package com.zettamine.day04.composition;

public class Hosteller{

	private String hostelName;
	private int roomNumber;
	
	
	
	public Hosteller(String hostelName, int roomNumber) {
		super();
		this.hostelName = hostelName;
		this.roomNumber = roomNumber;
	}
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	
}
