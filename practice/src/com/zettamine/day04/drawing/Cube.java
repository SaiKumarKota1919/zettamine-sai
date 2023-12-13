package com.zettamine.day04.drawing;

public class Cube extends Shape implements Spatial{

	private int length;
	private int width;
	private int height;
	
	public Cube(int length,int width,int heigth,String color)
	{
		super(color);
		this.length = length;
		this.width =width;
		this.height = heigth;
	}

	@Override
	double area() {
		// TODO Auto-generated method stub
		return  (2 * length * width )+ (2 * length * height) +( 2* width * height);
	}

	@Override
	double volume() {
		// TODO Auto-generated method stub
		return length * width * height;
	}
	
	
}
