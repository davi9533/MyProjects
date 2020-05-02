package bankspp;

public class Checking extends Account {

	// list the properties specific to checking account
	private int debitCardNumber;
	private int debitCardPin;

	// constructor to initialize the checking account properties
	public Checking(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();

	}

	@Override
	public void setRate() {
		rate = getBaseRate() * 1.5;
	}

	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}

	// list any methods specific to the checking account
	public void showInfo() {
		System.out.println("Account Type: Checking");
		super.showInfo();
		System.out.println("Your Checking Account Features" + "\nDebit Card Number: " + debitCardNumber
				+ "\nDebit Card Pin: " + debitCardPin);

	}
}
