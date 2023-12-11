package com.zettamine.day02.bank;

public class CurrentAccount extends Account{

	private int noOfTransactions;
	private double serviceChages;
	private static  final int ALLOWED_TRANSACTIONS=3;

	public CurrentAccount(Account account, int serviceChages) {
		super(account.getAccountNum(),account.getAccountHolderName(), account.getAccountBalance());
		this.serviceChages = serviceChages;
	}

	

	

	
	@Override
	public void withdrawBalance(double accountBalance) {
		noOfTransactions++;
		super.withdrawBalance(accountBalance);
	}






	@Override
	public void depositeBalance(double accountBalance) {
		noOfTransactions++;
		super.depositeBalance(accountBalance);
	}






	public int getNoOfTransactions() {
		return noOfTransactions;
	}

	public double calculateServiceCharges() {
		
		if(noOfTransactions>ALLOWED_TRANSACTIONS)
		{
			
			double charge = (noOfTransactions-ALLOWED_TRANSACTIONS)*serviceChages;
			noOfTransactions=-1;
			return charge;
		}
		return 0;
		
		
	}
	public void setNoOfTransactions(int noOfTransactions) {
		this.noOfTransactions = noOfTransactions;
	}


}
