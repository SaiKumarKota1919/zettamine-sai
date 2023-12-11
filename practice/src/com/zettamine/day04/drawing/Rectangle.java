package com.zettamine.day04.drawing;

public class Rectangle extends Shape{

	private int length,breadth;
	
	
	
	public Rectangle(String color,  int length, int breadth) {
		super(color);
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	double area() {
		// TODO Auto-generated method stub
		return length*breadth;
	}

	
	

}
