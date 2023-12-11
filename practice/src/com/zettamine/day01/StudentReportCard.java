package com.zettamine.day01;

import java.util.Scanner;

public class StudentReportCard {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		
		System.out.print("enter student name : ");
		String studentName = scanner.nextLine();
		System.out.println();
		System.out.print("enter no of subjects : ");

		int noOfSub = scanner.nextInt();
		scanner.nextLine();   
		String[] subjectNames = getSubjectNames(noOfSub);
		

		int[] marksArray = getMarksEntry(subjectNames);

		printReportCrad(marksArray, studentName, subjectNames);

	}

	private static String[] getSubjectNames(int noOfSub) {
		String[] subjects = new String[noOfSub];

		for (int i = 0; i < noOfSub; i++) {
			
			System.out.print("enter subject-" + (i + 1) + " name :");

			subjects[i] = scanner.nextLine();
			

		}

		return subjects;
	}

	private static int[] getMarksEntry(String[] subjectNames) {

		int[] marksArray = new int[subjectNames.length];
		for (int i = 0; i < subjectNames.length; i++) {
			System.out.print("enter marks for " + subjectNames[i] + "- : ");
			marksArray[i] = scanner.nextInt();
			System.out.println();

		}
		return marksArray;

	}

	private static void printReportCrad(int[] marksArray, String studentName, String[] subjectNames) {
		int total = 0;

		System.out.println("-".repeat(40));
		System.out.println("\t\tREPORT CARD");
		System.out.println("NAME : " + studentName);
		System.out.println("-".repeat(40));
		System.out.println("SUBJECT\t\t Mark");
		System.out.println("-".repeat(40));
		for (int i = 0; i < marksArray.length; i++) {
			System.out.println(subjectNames[i]+"\t\t" + marksArray[i]);
			total = total + marksArray[i];

		}
		System.out.println("-".repeat(40));
		System.out.printf("TOTAL : " + total + "\t\t AVERAGE : %.2f", ((double) total) / marksArray.length);
		System.out.println();
		System.out.println("-".repeat(40));

	}

}
