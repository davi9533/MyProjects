package studentdatabase;

import java.util.Scanner;

public class StudentDatabseApp {

	public static void main(String[] args) {

		// Ask how many students we want to add
		System.out.print("Enter number of students you want to enroll");
		Scanner sc = new Scanner(System.in);
		int noOfstudents = sc.nextInt();
		Student[] students = new Student[noOfstudents];

		// create a number of new students
		for (int i = 0; i < noOfstudents; i++) {
			students[i] = new Student();
			students[i].enroll();
			students[i].payTuition();

		}

		// displaying info
		for (int i = 0; i < noOfstudents; i++) {
			System.out.println(students[i]);
		}
	}

}
