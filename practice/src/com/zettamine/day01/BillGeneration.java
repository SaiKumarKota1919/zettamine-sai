package com.zettamine.day01;

import java.util.Scanner;

public class BillGeneration {
	private static int pizzaUnitPrice =100;
	private static int puffUnitPrice =20;
	private static int coolDrinkUitPrice =5;
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		//reading input from the user
		System.out.print("Enter the no of pizzas bought : ");
		int noOfPizzas =scanner.nextInt();
		System.out.print("Enter the no of puffs bought : ");
		int noOfPuffs =scanner.nextInt();
		System.out.print("Enter the no of cool drinks bought : ");
		int noOfCoolDrinks =scanner.nextInt();
		System.out.println();
		
		//calling generate bill method 
		generateBill(noOfPizzas,noOfCoolDrinks,noOfPuffs);
		
		scanner.close();
		
		
	}

	private static void generateBill(int noOfPizzas, int noOfCoolDrinks, int noOfPuffs) {
		
		int totalPizzaPrice =noOfPizzas*pizzaUnitPrice;
		int totalPuffPrice = noOfPuffs*puffUnitPrice;
		int totalCoolDrinkPrice = noOfCoolDrinks*coolDrinkUitPrice;
		float totalPrice = (float)totalPizzaPrice+totalCoolDrinkPrice+totalPuffPrice;
		
		System.out.println("Bill Details");
		System.out.println("No of pizzas \t  :  "+noOfPizzas+"\t   cost : "+noOfPizzas+" * "+pizzaUnitPrice+" = "+totalPizzaPrice);
		System.out.println("No of puffs  \t  :  "+noOfPuffs+"\t   cost : "+noOfPuffs+" * "+puffUnitPrice+" = "+totalPuffPrice);
		System.out.println("No of cool drinks :  "+noOfCoolDrinks+"\t   cost : "+noOfCoolDrinks+" * "+coolDrinkUitPrice+" = "+totalCoolDrinkPrice);
		System.out.println();
		System.out.println();
		System.out.printf("Total Price=%.2f\n",totalPrice);
		
		System.out.println("ENJOY THE SHOW!!!");
		
	}

}
