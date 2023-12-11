package com.zettamine.day03;



import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import com.zettamine.day01.NameValidate;

public class StudentRegister {
	static Set<Student> studentSet = new TreeSet<Student>();
	public static void main(String[] args) {
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter student Name : ");
			String name = scanner.nextLine();
			while(!NameValidate.isValidName(name))
			{
				System.out.println("\u001B[31mInvalid Name please enter valid Name!!!\u001B[30m");
				System.out.print("Enter student Name : ");
				 name = scanner.nextLine().trim().replaceAll(" +", " ");
			}
			
			System.out.print("Enter student Email  : ");
			String email = scanner.nextLine();
			while(!EmailValidate.isValidEmail(email)) 
			{
				System.out.println("\u001B[31mInvalid Email please enter valid Email!!!\u001B[30m");
				System.out.print("Enter student Email  : ");
				email = scanner.nextLine();
			}
			studentSet.add(new Student(name, email));
			System.out.print("Do you want to enter more students[Y/N] : ");
			char ch = scanner.nextLine().charAt(0);
			if(ch== 'N'||ch=='n')
			{
				break;
			}
			else if(!(ch=='y'||ch=='Y'))
			{
			  while(!(ch=='y'||ch=='Y'||ch=='N'||ch=='n'))
			  {
				  System.out.println("\u001B[31m Invalid input please try again \u001B[30m");
				  System.out.print("Do you want to enter more students[Y/N] : ");
					 ch = scanner.nextLine().charAt(0);
			  }
			}
			
		}
		printStudentDetails();
		
	}
	
	private static void printStudentDetails() {

		System.out.println("=".repeat(80));
		
		
		System.out.println("Student_ID   |   Student_NAME     |      EMAIL         |         COLLEGE NAME ");
		System.out.println("=".repeat(80));
		for(Student student : studentSet)
		{
			System.out.printf("%-15s|%-20s|%-25s|%-10s|",student.getStudentId(),student.getStudentName()
			,student.getStudentEmail(),Student.getCollegeName());
		System.out.println();
		System.out.println("-".repeat(80));
		
	
		}
		
	}

}
