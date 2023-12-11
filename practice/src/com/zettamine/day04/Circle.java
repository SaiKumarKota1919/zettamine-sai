package com.zettamine.day04;

public class Circle extends Shape {

	private static final double PI = 3.145;
	private int radius;
	
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}


	public int getRadius() {
		return radius;
	}


	public static double getPi() {
		return PI;
	}


	@Override
	double area() {
		// TODO Auto-generated method stub
		return PI*(radius*radius);
	}

}
