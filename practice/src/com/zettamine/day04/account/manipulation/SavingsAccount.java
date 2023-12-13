package com.zettamine.day04.account.manipulation;

public class SavingsAccount extends Account {

	private double minimumBalance;
	
	public SavingsAccount(int accountNumber, Customer customerObj, double balance,double minBalance) {
		super(accountNumber, customerObj, balance);
		minimumBalance = minBalance;
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public boolean withdraw(double amount) {
		if(balance-amount>minimumBalance)
		{
			setBalance(balance-amount);
			return true;
		}
		return false;
	}

}
