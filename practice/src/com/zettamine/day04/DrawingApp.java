 package com.zettamine.day04;

import java.util.Scanner;

public class DrawingApp {

	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Shape shape;
		System.out.print("Which shape do you want to woark with? [1.Rectangle | 2.Circle | 3.Triangle] :");
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
		default: System.out.println("invalid shape slection :: try again --closing the app ");
			
			
		
		}
		scanner.close();
	}

	private static void drawShape(Shape shape) {
		String name = shape.getClass().getSimpleName().toUpperCase();
		System.out.println("===========SHAPE SELECTED : "+name+" ============");
		System.out.println("color of \""+name+"\" is "+shape.getColor());
		System.out.printf("area of \""+name+"\" is %.2f",shape.area());
		
	}
}
