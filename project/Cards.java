package project;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cards {

	int card, acc_no;
	long dob, contact;
	SimpleDateFormat o = new SimpleDateFormat("yyyy-mm");
	String name, address;
	int count = 0;
	Scanner sc = new Scanner(System.in);
	String ch;
	int monthlytrans, cr_rate;

	public void newCard() {

		do {
			System.out.println("Enter credit score:");
			cr_rate = sc.nextInt();

			if (cr_rate < 750) {
				System.out.println("You are not eligible to apply for credit card because of low credit score.");
				break;

			} else {
				System.out.println("Which Card? \n1.Credit \n2.Debit");
				card = sc.nextInt();
				getDetails();
				System.out.println();
				System.out.println("Want to register for new card?(Y/N)");
				ch = sc.next();
			}
		} while (ch == "y" || ch == "Y");
	}

	public void getDetails() {
		System.out.println("Enter account number: ");
		acc_no = sc.nextInt();
		System.out.println("Enter full Name: ");
		name = sc.next();
		System.out.println("Enter Address: ");
		address = sc.next();
		System.out.println("Enter contact number: ");
		contact = sc.nextLong();
		System.out.println("Enter date of birth (ex. 12011997): ");
		dob = sc.nextLong();

	}

	public long cardGenerator() {
		long number = (long) (Math.random() * 1000000000000000l);
		return number;
	}

	public static void exDate() {
		int i = (int) (Math.random() * 10);
		Calendar cal = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR) + i;
		int month = cal.get(Calendar.MONTH) + i;
		if (month > 12) {
			month = month / 12;
		}
		System.out.println("Your card will expire on :" + month + " " + year);
	}

	public void cardDisplay() {
		if (card == 1) {
			System.out.println("YOUR CREDIT CARD DETAILS:");
		} else {
			System.out.println("YOUR DEBIT CARD DETAILS:");
		}
		System.out.println("Name: " + name);
		System.out.println("Contact No.: " + contact);
		System.out.println("Your Card Number is: " + cardGenerator());
		exDate();
		System.out.println("\n\nKeep your information safe with you!");
	}
}
