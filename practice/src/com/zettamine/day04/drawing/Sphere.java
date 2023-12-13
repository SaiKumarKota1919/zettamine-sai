package com.zettamine.day04.drawing;

public class Sphere extends Shape implements Spatial{
	
	private int radius;
 public Sphere(int radius,String color)
 {
	 super(color);
	 this.radius = radius;
 }
@Override
double area() {
	return 4  * Math.PI *( radius*radius);
}
@Override
double volume() {
	return ( 4  * Math.PI *Math.pow(radius,3)) / 3;
}
	

}
