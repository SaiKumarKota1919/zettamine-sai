package com.zettamine.day04.drawing;

public class Triangle extends Shape {

	private int height,base;
	
	
	public Triangle(String color, int height, int base) {
		super(color);
		this.height = height;
		this.base = base;
	}




	@Override
	double area() {
		// TODO Auto-generated method stub
		return 0.5*height*base;
	}

}
