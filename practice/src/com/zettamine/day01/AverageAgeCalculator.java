package com.zettamine.day01;


import java.util.Scanner;

public class AverageAgeCalculator {
	private static int minAge =28;
	private static int maxAge = 40;
	private static int minEmployee =2;
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.print("Enter total no. of employees: " );
		int noOfEmp = scanner.nextInt();
		if(noOfEmp>minEmployee) //checking whether no of employees are greater than minimum employees
		{
			System.out.println("Enter the age for "+ noOfEmp+ " employees:");
		System.out.printf("The average age is %.2f",calculateAverage(noOfEmp)); //calling method to calculate average age of employee
			
			System.out.println();
			
		}
		else {
			System.err.println("Please enter a valid employee count");
		}
		
		scanner.close();
		
	}
	private static double calculateAverage(int noOfEmp) {
		int[] ageArr = new int[noOfEmp];
		double avgAge = 0.0; 
		for(int i=0;i<noOfEmp;i++)
		{
			int age = scanner.nextInt(); //reading n employees age from the user 
			if(age>minAge && age<maxAge) //checking the range of the age
			{
				ageArr[i] = age;
				avgAge += age;
			}
			else {
				System.err.println("Invalid Age Encountered"); //if age is not in range exit
				System.exit(0);
				
			}
		}
		return avgAge/noOfEmp;
	}

}
