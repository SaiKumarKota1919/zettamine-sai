package com.zettamine.day02;


public class PermanentEmployee extends Employee {
	private double basicPay;
	
	
	public PermanentEmployee(int employeeId,String employeeName,double basicPay)
	{
		super(employeeId, employeeName);
		this.basicPay = basicPay;
	}
	
	@Override
	public void calculateSalary() {

		double pfAmount  = basicPay*0.12;
				salary = basicPay-pfAmount;
				
	}

}
