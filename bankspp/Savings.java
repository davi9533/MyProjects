package bankspp;

public class Savings extends Account {
	// list the properties specific to savings account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;

	// constructor to initialize the savings account properties
	public Savings(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();

	}

	@Override
	public void setRate() {
		rate = getBaseRate() - .25;

	}

	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	// list any methods specific to the savings account

	public void showInfo() {
		System.out.println("Account Type: Savings");
		super.showInfo();
		System.out.println("Your Savings Account Features" + "\nSafety Deposit Box ID: " + safetyDepositBoxID
				+ "\nSafety deposit Box Key: " + safetyDepositBoxKey);

	}

}
