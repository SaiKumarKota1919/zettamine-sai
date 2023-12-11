package com.zettamine.day02.bank;

/*Account POJO annd this account having two types 
 * 1.savings(rate of interest) 
 * 2.current(service charges based on no of transactions made more than allowed transactions)
*/
public class Account {
	private long accountNum;
	private String accountHolderName;
	private double accountBalance;
	
	
	public Account(long accountNum, String accountHolderName, double accountBalance) {
		super();
		this.accountNum = accountNum;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public long getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}
	

	public void withdrawBalance(double accountBalance) {
		this.accountBalance =this.accountBalance- accountBalance;
	}
	public void depositeBalance(double accountBalance) {
		this.accountBalance =this.accountBalance + accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", accountHolderName=" + accountHolderName + ", accountBalance="
				+ accountBalance + "]";
	}
	
	

}
