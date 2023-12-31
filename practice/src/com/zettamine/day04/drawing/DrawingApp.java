 package com.zettamine.day04.drawing;

import java.util.Scanner;

public class DrawingApp {

	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Shape shape;
		System.out.print("Which shape do you want to work with? [1.Rectangle | 2.Circle | 3.Triangle |4.cube |5.sphere] :");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice)
		{
		
		case 1: 
			System.out.print("enter color of rectangle : ");
			String color = scanner.nextLine();
			System.out.print("enter legth of rectangle : ");
			int length = scanner.nextInt();
			System.out.print("enter breadth of rectangle : ");
			int breadth = scanner.nextInt();
			scanner.nextLine();
			shape = new Rectangle(color,length, breadth);
			shape.setColor(color);
			drawShape(shape);
			break;
		case 2: 
			System.out.print("enter color of Circle : ");
			String circleColor = scanner.nextLine();
			System.out.print("enter radius of Circle : ");
			int radius = scanner.nextInt();
			scanner.nextLine();
			shape = new Circle(circleColor,radius);
			drawShape(shape);
			break;
		case 3: 
			System.out.print("enter color of Triangle : ");
			String triangleColor = scanner.nextLine();
			System.out.print("enter height of Triangle : ");
			int height = scanner.nextInt();
			System.out.print("enter base of Triangle : ");
			int base = scanner.nextInt();
			scanner.nextLine();
			shape = new Triangle(triangleColor,height,base);
			drawShape(shape);
			break;
		case 4: 
			System.out.print("enter color of Cube : ");
			String cubeColor = scanner.nextLine();
			System.out.print("enter length of cube : ");
			int cubeLength = scanner.nextInt();
			System.out.print("enter width of cube : ");
			int cubeWidth = scanner.nextInt();
			System.out.print("enter height of cube : ");
			int cubeHeight = scanner.nextInt();
			scanner.nextLine();
			shape = new Cube(cubeLength, cubeWidth, cubeHeight, cubeColor);
			drawShape(shape);
			break;
		case 5: 
			System.out.print("enter color of  sphere : ");
			String sphereColor = scanner.nextLine();
			System.out.print("enter radius of Circle : ");
			int sphereRadius = scanner.nextInt();
			scanner.nextLine();
			shape = new Sphere(sphereRadius,sphereColor);
			
			drawShape(shape);
			break;
		default: System.out.println("invalid shape slection :: try again --closing the app ");
			
			
		
		}
		scanner.close();
	}

	private static void drawShape(Shape shape) {
		String name = shape.getClass().getSimpleName().toUpperCase();
		System.out.println("===========SHAPE SELECTED : "+name+" ============");
		System.out.println("color of \""+name+"\" is "+shape.getColor());
		System.out.printf("area of \""+name+"\" is %.2f\n",shape.area());
		if(shape instanceof Spatial)
		{
			System.out.printf("Volume of \""+name+"\" is %.2f",shape.volume());
		}
		
	}
}
