package com.zettamine.day02;

public class Loan {
	public double calculateLoan(Employee employee)
	{
		if(employee instanceof PermanentEmployee)
		{
			return employee.getSalary()*0.15;
		}
		else  {
			
			return employee.getSalary()*0.1;
			
		}
	
	}
	
	

}
