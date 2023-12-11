package com.zettamine.day03.contacthostler;

import java.util.Scanner;

import com.zettamine.day01.NameValidate;

public class HostelMain {

	public static void main(String[] args) {
		Hosteller hosteller = getHostellerDetails();
		System.out.println("-".repeat(30));
		System.out.println("Student ID: "+hosteller.getStudentId());
		System.out.println("Student Name: "+hosteller.getName());
		System.out.println("Department ID: "+hosteller.getDepartmentId());
		System.out.println("Student Gender: "+hosteller.getGender());
		System.out.println("Student Phone No: "+hosteller.getPhone());
		System.out.println("Hostel Name: "+hosteller.getHostelName());
		System.out.println("Room No: "+hosteller.getRoomNumber());
		
		
	}
	
//	Student ID: 101
//	Student Name: John 
//	Department ID: 1  
//	Student Gender: Male     
//	Student Phone No: 9876543121   
//	Hostel Name: YMCA     
//	Room No: 11
//	Enter the Student Details & Hostel Details:
//		Student ID:   101
//		Student Name:  John
//		Department Id:  1
//		Gender[M/F]:  M
//		Phone Number: 9848586878
//		Hostel Name:  YMCA
//		Room Number:  10
//		Modify Room Number(Y/N): Y
//		New Room Number: 11
//		Modify Phone Number(Y/N): Y
//		New Phone Number: 9876543128
//		Sample Output 1:
//		The Student Details are as follows:
//


	
	public static Hosteller getHostellerDetails() {
		Scanner scanner = new Scanner(System.in);
		Hosteller hosteller;
		System.out.println("Enter the Student Details & Hostel Details:");
		System.out.print("Student ID: ");
		int studentId = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Student Name: ");
		String studentName = scanner.nextLine();
		while(!NameValidate.isValidName(studentName))
		{
			System.out.println("\u001B[31m Enter valid Name!! \u001B[30m");
			System.out.print("Student Name: ");
			studentName = scanner.nextLine();
		}
		
		System.out.print("Department ID: ");
		int departmentId = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Gender[M/F]: ");
		String gender = scanner.nextLine().toLowerCase();
		if(!(gender.equals("m")||gender.equals("f")))
		{
			while(!(gender.equals("m")||gender.equals("f")))
			{
					System.out.println("\u001B[31m Enter valid input!! \u001B[30m");
					System.out.print("Gender[M/F]: ");
					gender = scanner.nextLine().toLowerCase();
			}
		}
		System.out.print("Phone Number: ");
		String phoneNumber = scanner.nextLine();
		
		while(!phoneNumber.matches("^[6-9][0-9]{9}"))
		{
			System.out.println("\u001B[31m Enter Valid Phone Number \u001B[30m");
			System.out.print("Phone Number: ");
			 phoneNumber = scanner.nextLine();
		}
		System.out.print("Hostel Name: ");
		String hostelName = scanner.nextLine();
		System.out.print("Room Number: ");
		int roomNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Modify Room Number(Y/N): ");
		String modifyRoom = scanner.nextLine();
		if(modifyRoom.toLowerCase().equals("y"))
		{
			System.out.print("New Room Number: ");
			roomNumber = scanner.nextInt();
			scanner.nextLine();
		}
		
		System.out.print("Modify Phone Number(Y/N): ");
		String modifyPhoneNo = scanner.nextLine();
		if(modifyRoom.toLowerCase().equals("y"))
		{
			System.out.print("New phone Number: ");
			phoneNumber = scanner.nextLine();
		}
	
		System.out.println("");
		if(gender=="m")
		{
			gender = "Male";
		}
		else {
			gender = "Female";
		}
		
		hosteller = new Hosteller(studentId, studentName, departmentId, gender, 
											phoneNumber, hostelName, roomNumber); 
		return hosteller;
	}
}
