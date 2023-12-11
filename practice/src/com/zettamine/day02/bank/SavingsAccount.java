package com.zettamine.day02.bank;

public class SavingsAccount extends Account{
	private double rateOfInterest;
	public SavingsAccount(Account account,double roi) {
		super(account.getAccountNum(),account.getAccountHolderName(), account.getAccountBalance());
		rateOfInterest = roi;
	}
	public double calculateInterest() {
		
		double interest = getAccountBalance()*rateOfInterest/100;
		return  interest;
		
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	
	
	
	

}
