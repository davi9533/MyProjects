package studentdatabase;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1001;

	// constructor: prompts user to enter student's name and year
	public Student() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student's first name: ");
		this.firstName = sc.nextLine();

		System.out.println("Enter Student's last name: ");
		this.lastName = sc.nextLine();

		System.out.println("1. Freshmen\n2. Sophmore\n3. Junior\n4. Senior\nEnter Student's grade year: ");
		this.gradeYear = sc.nextInt();

		setStudentID();

	}

	// generate an ID
	private void setStudentID() {
		// grade level + ID
		id++;
		this.studentID = gradeYear + "" + id;
	}

	// enroll courses
	public void enroll() {
		// get inside a loop , user hits 0
		do {
			System.out.print("Enter a course to enroll (Q to quit): ");
			Scanner sc = new Scanner(System.in);
			String course = sc.nextLine();
			if (!course.equals("Q")) {
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			} else {
				break;
			}
		} while (1 != 0);
	}

	// view balance
	public void viewBalance() {
		System.out.println("Your balance is $" + tuitionBalance);
	}

	// pay tuition
	public void payTuition() {
		viewBalance();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter amount: $");
		int payment = sc.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank You for your payment");
		viewBalance();
	}
	// show status
	
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nGrade Level: " + gradeYear + "\nStudent ID: " + studentID
				+ "\nCourses Enrolled: " + courses + "\nTuition Balance: " + tuitionBalance;
	}
}
