package com.zettamine.day04.vehicle.loan;

import java.util.Scanner;

public class VehicleLoanApp {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter vehicle number :");
		String vehicleNo = scanner.nextLine();
		System.out.print("Enter vehicle modelname :");
		String vehicelName = scanner.nextLine();
		System.out.print("Enter vehicle Type[1.4-Wheeler | 2. 3-Wheeler | 3.2-Wheeler] :");
		int vehicleTypeChoice = scanner.nextInt();
		
		while(!(vehicleTypeChoice==1||vehicleTypeChoice==2||vehicleTypeChoice==3))
		{
			System.err.println("Invalid input try again!!!");
			System.out.print("Enter vehicle Type[1.4-Wheeler | 2. 3-Wheeler | 3.2-Wheeler] :");
			vehicleTypeChoice = scanner.nextInt();
		}
		String vehicleType ="";
		if(vehicleTypeChoice==1)
		{
		vehicleType ="4wheeler";	
		}
		else if (vehicleTypeChoice==2) {
			vehicleType ="3wheeler";
			
		}
		else {
			vehicleType = "2wheeler";
		}
		System.out.print("Enter vehicle price :");
		
		double  vehiclePrice = scanner.nextDouble();
		
		
		Vehicle vehicle = new Vehicle(vehicleNo,vehicelName,vehicleType,vehiclePrice);
		
		if(vehicle.issueLoan()>0)
		{
			System.out.printf("Congratulations your elgible for the loan amount of  : %.2f \n",vehicle.issueLoan());
		}
		else {
			System.out.println("you are not elgible for the loan !!!!");
			
		}
		
		if(vehicle.takeInsurance()>0)
		{
			System.out.printf("Congratulations your elgible for the Insurance of premium amount  : %.2f \n",vehicle.takeInsurance());
			
		}
		else {
			System.out.println("Not elgible for the insurence");
		}
		
	}

}
