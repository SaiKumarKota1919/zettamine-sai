package com.zettamine.day04;

public class Triangle extends Shape {

	int height,base;
	
	
	public Triangle(int height, int base) {
		super();
		this.height = height;
		this.base = base;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getBase() {
		return base;
	}


	public void setBase(int base) {
		this.base = base;
	}


	@Override
	double area() {
		// TODO Auto-generated method stub
		return 0.5*height*base;
	}

}
