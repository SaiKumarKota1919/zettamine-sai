package com.zettamine.day02;

public class LoanMain {
	public static void main(String[] args) {
		Loan loan = new Loan();
		Employee employee = new TemporaryEmployee(101, "sai kumar", 300, 200);
		employee.calculateSalary();
		Employee employee2 = new PermanentEmployee(121, "rafi", 50000);
		employee2.calculateSalary();
		System.out.printf("loan offerd is :%.2f",loan.calculateLoan(employee2));
		
	}

}
