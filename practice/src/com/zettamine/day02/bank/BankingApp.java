package com.zettamine.day02.bank;

import java.util.Scanner;

import com.zettamine.day01.NameValidate;

public class BankingApp {
	static Scanner scanner = new Scanner(System.in);
	static Account account;

	public static void main(String[] args) {
		

		while (true) {
			
			/* here we are allowing the user to use application until user wants to exit the application
			 * and needs to select exit choice  */
			System.out.println("1.Create Account" + "\n2.Deposit" + "\n3.withdraw" + "\n4.Details" + "\n5.Add Interest"
					+ "\n6.Service Charge" + "\n7.no of transactions" + "\n8.Exit");
			System.out.print("Enter your choice : ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			
			case 1:
				createAccount();
				break;
     		case 2:
				depositAmount();
				break;
			case 3:
				withdrawAmount();
				break;
			case 4:
				getAccountDetails();
				break;
			case 5://this option is only for savings account holder
				if (account != null) {
					if (account instanceof SavingsAccount) {
						addInterest();
					} else {
						System.out.println("\u001B[31m Not A Savings Account \u001B[30m");
					}
				} else {
					System.out.println("\u001B[31m Account doesn't exist \u001B[30m");
				}
				break;
			case 6://this option is only for current account holder
				if (account != null) {
					if (account instanceof CurrentAccount) {
						addServiceCharge();

					} else {
						System.out.println("\u001B[31m Not A Current Account \u001B[30m");
					}
				} else {
					System.out.println("\u001B[31m Account doesn't exist \u001B[30m");
				} 
				break;
			case 7://this option is only for current account holder
				if (account != null) {
					if (account instanceof CurrentAccount) {
						System.out.println("No of transaction made : "+((CurrentAccount)account).getNoOfTransactions());

					} else {
						System.out.println("\u001B[31m Not A Current Account \u001B[30m");
					}
				} else {
					System.out.println("\u001B[31m Account doesn't exist \u001B[30m");
				} 
				
				break;

			case 8:
				
				if (account != null && account instanceof CurrentAccount) {
					addServiceCharge();
				}
				scanner.close();
				exitProcess();
				break;
			default:
				invalidInput();
				break;
			}
		}

	}
	
	// this method is used to create Account based on user choice either savings or current
	private static void createAccount() {

		if (account == null) {
			System.out.print("Enter Account Type[1.Savings/2.Current]:");
			int i = scanner.nextInt();
			scanner.nextLine();
			// if user choose other than given options warn the user and allow to choose again till correct option
			while (!(i == 1 || i == 2)) {
				System.out.println("\u001B[31m Invalid Input please try agian!!!\u001B[30m ");
				System.out.print("Enter Account Type[1.Savings/2.Current]:");
				i = scanner.nextInt();
				scanner.nextLine();

			}
			if (i == 1) {
				// here getDematAccount() is a method which accepts inputs from user and returns Account object
				Account dematAccount = getDematAccount();
				// after getting account object getting rate of interest from the user
				System.out.print("Enter Rate Of Interest : ");
				double roi = scanner.nextDouble();
				// then there is a constructor which accepts account and roi as parameters and initialize SavingsAccount object
				account = new SavingsAccount(dematAccount, roi);
			} else {

				Account deAccount = getDematAccount();
				// after getting account object getting service charges from the user
				System.out.print("Enter service charges : ");
				int serviceCharges = scanner.nextInt();
				scanner.nextLine();
				// then there is a constructor which accepts account and service Charges as parameters and initialize CurrentAccount object
				account = new CurrentAccount(deAccount, serviceCharges);

			}
			//After Successful creation of the Account showing status

			System.out.println("\u001B[34m Your Account is successfuly created\n Thank You!!! \u001B[30m");
		} else {
			// if account is already created warn the user
			System.out.println("\u001B[32m Account is already exist!! \u001B[30m");
		}

	}


	// this method is used to return Account object
	private static Account getDematAccount() {
		System.out.print("Enter Account Number :");
		Long accountNumber = scanner.nextLong();
		scanner.nextLine();
		System.out.print("Enter name :");
		String name = scanner.nextLine();
		while (!NameValidate.isValidName(name)) {
			System.out.print("\u001B[31m Please Enter valid Name\u001B[30m ");
			System.out.println();
			System.out.print("Enter name :");
			name = scanner.nextLine();
		}
		System.out.print("Enter initial deposite : ");
		double initialDeposit = scanner.nextDouble();
		return new Account(accountNumber, name, initialDeposit);
	}
	

	private static void addServiceCharge() {

		double totalServiceCharge = ((CurrentAccount) account).calculateServiceCharges();
		
		
		if (totalServiceCharge != 0) {
			account.withdrawBalance(totalServiceCharge);
			System.out.println("\u001B[32m Total service chage is :" + totalServiceCharge + " debited from the account"
					+ "No: " + account.getAccountNum() + "\n curent balance is: " + account.getAccountBalance()
					+ "\u001B[30m");
		} else {
			System.out.println("\u001B[31mservice charge is not aplicable\u001B[30m");
		}

	}

	private static void addInterest() {

		double interestAmount = ((SavingsAccount) account).calculateInterest();
		account.depositeBalance(interestAmount);
		System.out.printf(
				"\u001B[32m interest amount :%.2f is successflly credited to the account No:%d"
						+ "\n current balance is :%.2f \u001B[30m",
				interestAmount, account.getAccountNum(), account.getAccountBalance());
		System.out.println();

	}

	private static void invalidInput() {

		System.out.println("\u001B[31mInvalid input......Pls try again!!! \u001B[30m");

	}

	private static void exitProcess() {
		System.out.println("\u001B[44m \u001B[37m Application is developed by sai kumar \n Thank You\n Visit Again!!! \u001B[30m\u001B[47m");
		System.exit(0);

	}

	
	/* this method is used to get statement for the account*/
	private static void getAccountDetails() {

		if (account == null) {
			System.out.println("\u001B[31m Account doesn't exist \u001B[30m");
		} else {
			System.out.printf("\u001B[32m Account No :%d \n Name :%s\n Available Balance :%.2f \n \u001B[30m",
					account.getAccountNum(), account.getAccountHolderName(), account.getAccountBalance());
		}

	}
	
	/* this method is used to withdraw the amount 
	 * if the account is a current account then transaction is increased by one
	 * and withdraw is possible only the deposit amount is greater than or equal to 100 */

	private static void withdrawAmount() {
		if (account == null) {
			//if account is not created yet warn the user
			System.out.println("\u001B[31m Account doesn't exist \u001B[30m");
		} else {
			System.out.print("Enter amount to withdraw : ");
			double amount = scanner.nextDouble();
			if(amount>=100)
			{
				if (amount > account.getAccountBalance()) {
					//if the amount is greater than available balance warn the user
					System.out.println("\u001B[31m Insufficient balance!!! \u001B[30m");
				} else {
					// if the amount is available in the account perform transaction
					account.withdrawBalance(amount);
					// after successful completion of deposit showing the status
					System.out.printf("\u001B[32mAmount %.2f is successfully debited from account no:%d\n current balance "
							+ "is :%.2f \u001B[30m", amount, account.getAccountNum(), account.getAccountBalance());
					System.out.println();
				}
			}
			else {
				// if the amount is less than 100 warn the user
				System.out.println("\u001B[31m Amount should be greater than 100 \u001B[30m");
			}
			

		}

	}
	
	/* this method is used to deposit the amount 
	 * if the account is a current account then transaction is increased by one
	 * and deposit is possible only the deposit amount is greater than or equal to 100 */

	private static void depositAmount() {
		
		

		if (account == null) {
			//if account is not created yet warn the user
			System.out.println("\u001B[31m Account doesn't exist \u001B[30m");
		} else {
			System.out.print("Enter amount to deposite : ");
			double amount = scanner.nextDouble();
			if(amount>=100)
			{
				account.depositeBalance(amount);
				// after successful completion of deposit showing the status
				System.out.printf("\u001B[32mAmount %.2f is successfully credited to account no:%d\n current balance "
						+ "is :%.2f \u001B[30m", amount, account.getAccountNum(), account.getAccountBalance());
				System.out.println();
			}
			else {
				// if the amount is less than 100 warn the user
				System.out.println("\u001B[31m Amount should be greater than 100 \u001B[30m");
			}
			
			
		}

	}

	

}
