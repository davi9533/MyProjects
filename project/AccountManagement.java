package project;

import java.util.Scanner;

public class AccountManagement {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account myAccount = new Account();

		int ch = 2;

		do {
			System.out.println();
			System.out.println("1) Deposit to a Account account");
			System.out.println("2) Withdraw to Account account");
			System.out.println("3) Print short account information");
			System.out.println("4) Print the detailed account information including last transactions");
			System.out.println("5) Quit");
			System.out.println();
			System.out.print("Enter choice [1-5]: ");
			ch = input.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter a account number");
				int acNumber = input.nextInt();
				System.out.println("Enter a deposit amount");
				double deAmount = input.nextDouble();
				myAccount.depositTo(acNumber, deAmount);
				break;
			case 2:
				System.out.println("Enter a account number");
				int ac_Number = input.nextInt();
				System.out.println("Enter a withdraw amount");
				double wiAmount = input.nextDouble();
				myAccount.withdrawFrom(ac_Number, wiAmount);
				break;
			case 3:
				System.out.println("Enter a account number");
				int accountNum = input.nextInt();
				myAccount.printAccountInfo(accountNum);
				break;
			}
		} while (ch != '5');

	}

	static class Account {
		private bankAccount[] accounts;
		private int numOfAccounts;

		public Account() {
			accounts = new bankAccount[100];
			numOfAccounts = 0;
		}

		public void withdrawFrom(int accountNum, double amount) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					accounts[i].withdraw(amount);
					System.out.println("Amount withdrawn successfully");
					return;
				}
			}
			System.out.println("Please enter the right account number.");
		}

		public void depositTo(int accountNum, double amount) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					accounts[i].deposit(amount);
					System.out.println("Amount deposited successfully");
					return;
				}
			}
			System.out.println("Please enter the right account number.");
		}

		public void printAccountInfo(int accountNum) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					System.out.println(accounts[i].getAccountInfo());
					return;
				}
			}
			System.out.println("Please enter the right account number.");
		}

		public void printAccountInfo(int accountNum, int n) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					System.out.println(accounts[i].getAccountInfo());
					System.out.println(accounts[i].getTransactionInfo(n));
					return;
				}
			}
			System.out.println("Please enter the right account number.");
		}

	}

	static class bankAccount {

		private int accountNum;
		private String customerName;
		private double balance;
		private double[] transactions;
		private int numOfTransactions;
		private static int noOfAccounts = 0;

		public String getAccountInfo() {
			return "Account number: " + accountNum + "\nCustomer Name: " + customerName + "\nBalance:" + balance + "\n";
		}

		public int getTransactionInfo(int n) {
			numOfTransactions = n;
			return n;

		}

		public bankAccount(String sss, double abc) {
			customerName = sss;
			balance = abc;
			noOfAccounts++;
			accountNum = noOfAccounts;
			transactions = new double[100];
			transactions[0] = balance;
			numOfTransactions = 1;
		}

		public int getAccountNum() {
			return accountNum;
		}

		public void deposit(double amount) {

			if (amount <= 0) {
				System.out.println("Amount to be deposited should be positive");
			} else {
				balance = balance + amount;
				transactions[numOfTransactions] = amount;
				numOfTransactions++;
			}
		}

		public void withdraw(double amount) {
			if (amount <= 0) {
				System.out.println("Amount to be withdrawn should be positive");
			} else {
				if (balance < amount) {
					System.out.println("Insufficient balance");
				} else {
					balance = balance - amount;
					transactions[numOfTransactions] = amount;
					numOfTransactions++;
				}
			}
		}
	}

}
