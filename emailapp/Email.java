package emailapp;

import java.util.Scanner;

public class Email {

	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity = 500;

	private String alternateEmail;
	private int defaultpasswordLength = 10;
	private String companySuffix = "aeycompany.com";

	// constructor to receive the firstName & lastName
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		// call method to ask for department - return department
		this.department = setDepartment();

		// call a method to return a random password
		this.password = randomPassword(defaultpasswordLength);
		System.out.println("Your Password is: " + this.password);

		// combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

	}

	// Ask for the department
	private String setDepartment() {
		System.out.println("New Worker: " + firstName
				+ "\nEnter the department\n1. For Sales\n2. For Development\n3. Accounting\n0. For None");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if (deptChoice == 1) {
			return "Sales";
		} else if (deptChoice == 2) {
			return "Dev";
		} else if (deptChoice == 3) {
			return "Accounting";
		} else {
			return "";
		}

	}

	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-!@#$%&*_";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// set the mailbox Capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// set alternate email
	public void setAlternateEmail(String altemail) {
		this.alternateEmail = altemail;
	}

	// change the password
	public void changePassword(String pass) {
		this.password = pass;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public String showInfo() {
		return "\nDisplay Name: " + firstName + " " + lastName + " " + "\nCompany Email: " + email
				+ "\nMailbox Capacity: " + mailboxCapacity + "mb";

	}

}
