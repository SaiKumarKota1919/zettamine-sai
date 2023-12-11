package com.zettamine.day02;

import java.util.Scanner;

import javax.xml.transform.Source;

public class StudentMain {
	static StudentDetails studentDetails;
	public static void main(String[] args) {
		//reading student details from the user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Student ID : ");
		int sId = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Student's Name: ");
		String sName = scanner.nextLine();
		System.out.print("Enter Student's address: ");
		String sAddress = scanner.nextLine();
		String string="";
		
		while(true)
		{
			System.out.print("Whether the student is from NIT(Yes/No): ");
			string = scanner.nextLine().toLowerCase().trim();
			boolean isValid =  string.equals("yes") || string.equals("no") ? true:false;
			if(isValid)
			{
				break;
			}
			else {
				
				System.err.println("Invalid Input try again");
			}
		}
		
		if(string.equals("yes"))
		{
			studentDetails = new StudentDetails(sId, sName, sAddress);
			studentDetails.setCollegeName("NIT");
		}
		else {
			System.out.print("Enter the college name: ");
			String cName = scanner.nextLine();
			studentDetails = new StudentDetails(sId, sName, sAddress,cName);
		}
		
		printStudentDetails(studentDetails);
	}
	
	
	private static void printStudentDetails(StudentDetails studentDetails) {
	
		System.out.println("-".repeat(40));
		System.out.println("Student id : "+studentDetails.getStudentId());
		System.out.println("Student name : "+studentDetails.getStudentName());
		System.out.println("Address : "+studentDetails.getStudentAddress());
		if(studentDetails.getCollegeName()!=null)
		{
			System.out.println("college Name : "+studentDetails.getCollegeName());
		}
		else {
			System.out.println("college Name : NIT");
		}
		System.out.println();
		
	}

}
