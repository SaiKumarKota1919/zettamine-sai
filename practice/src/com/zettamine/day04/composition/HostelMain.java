package com.zettamine.day04.composition;

import java.util.Scanner;

import com.zettamine.day01.NameValidate;

public class HostelMain {

	public static void main(String[] args) {
		Student student = getStudentObj();
		System.out.println("-".repeat(30));
		System.out.println("Student ID: "+student.getDepartmentId());
		System.out.println("Student Name: "+student.getName());
		System.out.println("Department ID: "+student.getDepartmentId());
		System.out.println("Student Gender: "+student.getGender());
		System.out.println("Student Phone No: "+student.getPhone());
		System.out.println("Hostel Name: "+student.getHosteller().getHostelName());
		System.out.println("Room No: "+student.getHosteller().getRoomNumber());
		
		
	}
	



	
	public static Student getStudentObj() {
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
		if(modifyPhoneNo.toLowerCase().equals("y"))
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
		
		Hosteller hostel = new Hosteller(hostelName, roomNumber);
		return new Student(studentId,studentName, departmentId, gender, phoneNumber, hostel);
	}
}
