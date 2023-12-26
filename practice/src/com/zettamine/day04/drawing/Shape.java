package com.zettamine.day04.drawing;

abstract class Shape {
	
	
	String color;
	
	
	public Shape(String color) {
		super();
		this.color = color;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	abstract double area();
	abstract double volume();
	

}
