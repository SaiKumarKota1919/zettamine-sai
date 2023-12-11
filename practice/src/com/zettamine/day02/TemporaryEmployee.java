package com.zettamine.day02;

public class TemporaryEmployee extends Employee {
	private int  hoursWorked;
    private int hourlyWages;
    
    public TemporaryEmployee(int employeeId,String employeeName,int hoursWoked,int hourlyWages)
    {
    	super(employeeId, employeeName);
    	this.hourlyWages = hourlyWages;
    	this.hoursWorked = hoursWoked;
    	
    	
    }

	@Override
	public void calculateSalary() {

		salary = hoursWorked*hourlyWages; 
		}


}
