package project;

import java.util.Scanner;
import project.Bank;

public class Loan {

	double amount;
	Bank b = new Bank();
	float monthly;
	int duration;
	double interest, principal, air;
	int choice;
	static int cr_rate;
	long acc_no;
	String cr;
	String[] credit = { "Excellent", "Good", "Bad" };
	int income;

	public void getData() {

		int i;
		Scanner s = new Scanner(System.in);
		 
		System.out.println("What type of loan you are looking for? ");
		System.out.println("1. Personal Loan \n2. Business Loan");
		choice = s.nextInt();
		System.out.print("\nAnnual Interest Rate: ");
		air = s.nextInt();
		System.out.println("Enter credit score(600-900): ");
		cr_rate = s.nextInt();

		switch (choice) {
		case 1:

			float interest = 3.65f;
			System.out.println("Enter amount to borrow (Minimum amount should be $10,000): ");
			amount = s.nextDouble();
			if (amount < 10000) {
				System.out.println("Minimum loan amount should be $10,000) ");
				break;
			} else if (amount > 200000) {
				System.out.println("Maximum loan amount should be $200,000");
				break;
			}

			System.out.println(
					"Enter duration: \n Enter 12 for 12 months \n Enter 36 for 36 months \n Enter 60 for 60 months");
			duration = s.nextInt();

			System.out.println("Enter your annual income: ");
			income = s.nextInt();

			if (income < 20000) {
				System.out.println("Minimum income required to qualify for loan is $20,000");
				break;
			}
			break;

		case 2:
			interest = 5.9f;
			System.out.println("Enter amount to borrow (Minimum amount should be $50,000) : ");
			amount = s.nextDouble();
			if (amount < 50000) {
				System.out.println("Minimum loan amount should be $50,000");
				break;
			} else if (amount > 500000) {
				System.out.println("Maximum loan amount should be $500,000");
				break;
			}

			System.out.println(
					"Enter duration: \n Enter 12 for 12 months \n Enter 36 for 36 months \n Enter 60 for 60 months");
			duration = s.nextInt();
			System.out.println("Enter your annual business revenue: ");
			income = s.nextInt();

			if (income < 100000) {
				System.out.println("Minimum annual business revenue required to qualify for loan is $100,000");
				break;
			}

			break;

		default:
			System.out.println("Wrong input!!!");

		}
		// }
	}

	public String creditScore() {
		if (cr_rate < 600 || cr_rate > 900) {
			System.out.println("Invalid Credit score!!");

		} else if (cr_rate >= 600 && cr_rate <= 700) {
			System.out.println("Your Credit rating is: " + credit[2]);
			System.out.println("You are not eligible for loan");
		} else if (cr_rate >= 700 && cr_rate <= 800) {
			System.out.println("Your Credit rating is: " + credit[1]);
			if (choice == 1)
				System.out.println("You are eligible to take loan upto $50,000");
			else if (choice == 2)
				System.out.println("You are eligible to take loan upto $200,000");

		} else if (cr_rate >= 800 && cr_rate <= 900) {
			System.out.println("Your Credit rating is: " + credit[0]);
			if (choice == 1)
				System.out.println("You are eligible to take loan upto $250,000");
			else if (choice == 2)
				System.out.println("You are eligible to take loan upto $500,000");

		}
		return null;

	}

	public void display() {
		double bal = amount;
		double mon_Interest = air / 1200;
		double mon_Payment = amount * mon_Interest / (1 - 1 / Math.pow(1 + mon_Interest, duration));
		double tot_Payment = mon_Payment * duration;
		creditScore();
		System.out.printf("\n\nMonthly Payment: %.2f\n", mon_Payment);
		System.out.printf("Total Payment: %.2f\n\n\n", tot_Payment);
		System.out.println("Payment#	Interest	Principal	Balance");

		for (int i = 1; i <= duration; i++) {

			interest = mon_Interest * bal;
			principal = mon_Payment - interest;
			bal = bal - principal;
			System.out.printf("Month %-13d   %-13.2f   %-13.2f   %.2f\n", i, interest, principal, bal);

		}
	}
}
