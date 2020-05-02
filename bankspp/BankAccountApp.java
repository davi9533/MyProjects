package bankspp;

import java.util.LinkedList;
import java.util.List;

import javax.swing.text.Utilities;

public class BankAccountApp {
	public static void main(String[] args) {
		String file = "C:\\Users\\sherr\\Documents\\1_HUMBER\\Java\\original.csv";

		List<Account> accounts = new LinkedList<Account>();

		// read a csv file and create a new account based on data
		List<String[]> newCustomers = utilities.CSV.read(file);
		for (String[] accountHolder : newCustomers) {
			String name = accountHolder[0];
			String ssn = accountHolder[1];
			String accType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			// System.out.println(name + " " + ssn + " " + accType + " " + initDeposit);
			if (accType.equals("Savings")) {

				accounts.add(new Savings(name, ssn, initDeposit));

			} else if (accType.equals("Checking")) {

				accounts.add(new Checking(name, ssn, initDeposit));
			} else {
				System.out.println("ERROR!!");
			}
		}

		for (Account acc : accounts) {
			System.out.println("\n*******************\n");
			acc.showInfo();
		}

	

	}
}
