package com.zettamine.day04;

abstract class Shape {
	
	String color;
	
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	abstract double area();

}
