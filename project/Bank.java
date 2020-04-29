package project;

import java.time.LocalDate;
import java.util.*;
import project.Loan;
import project.AccountManagement.Account;

public class Bank {

	Scanner sc = new Scanner(System.in);
	String a_name, email, dob, add, sin, mob;
	long acc_no;
	char std_chk, acc_type;

	public Bank() {
		// TODO Auto-generated constructor stub
	}

	public Bank(String a_name, String add, String email, String dob, String sin, String mob, char std_chk, long acc_no,
			char acc_type) {
		this.a_name = a_name;
		this.add = add;
		this.email = email;
		this.dob = dob;
		this.acc_no = acc_no;
		this.mob = mob;
		this.std_chk = std_chk;
		this.sin = sin;
		this.acc_type = acc_type;
	}

	public String var_check(String var, String msg) {
		int flag = 0;
		System.out.println(msg);
		var = sc.nextLine();
		while (flag == 0) {
			if (var.equals("")) {
				System.out.println(msg);
				var = sc.nextLine();
			} else
				flag = 1;
		}
		return var;
	}

	public char var_check(char var, String msg) {
		int flag = 0;
		String chr = "";
		System.out.println(msg);
		chr = sc.nextLine();
		while (flag == 0) {
			if (chr.equals("") | (chr.matches("[YyNn]") == false)) {
				System.out.println(msg);
				chr = sc.nextLine();
			} else if (chr.matches("[Yy]")) {
				var = 'Y';
				flag = 1;
			} else if (chr.matches("[Nn]")) {
				var = 'N';
				flag = 1;
			}
		}
		return var;
	}

	public char typ_Check(char var, String msg) {
		int flag = 0;
		String chr = "";
		System.out.println(msg);
		chr = sc.nextLine();
		while (flag == 0) {
			if (chr.equals("") | (chr.matches("[CcSs]") == false)) {
				System.out.println(msg);
				chr = sc.nextLine();
			} else if (chr.matches("[Cc]")) {
				var = 'C';
				flag = 1;
			} else if (chr.matches("[Ss]")) {
				var = 'S';
				flag = 1;
			}
		}
		return var;
	}

	public boolean dobVal(String dob_dt) {
		String[] dt = dob_dt.split("/");

		LocalDate tdy = LocalDate.now();
		int yr_ext = (tdy.getYear() - 18);

		int mon = Integer.parseInt(dt[0]);
		int dte = Integer.parseInt(dt[1]);
		int yr = Integer.parseInt(dt[2]);

		if ((mon >= 1 & mon <= 12 & mon != 2) & (dte >= 1 & (dte <= 30 | dte <= 31)) & (yr > 1900 & yr < yr_ext))
			return true;
		else if (mon == 2 & ((dte >= 1 & dte <= 28 & (yr > 1900 & yr < yr_ext))
				| (dte == 29 & (yr > 1900 & yr < yr_ext & yr % 4 == 0))))
			return true;
		else
			return false;
	}

	public boolean numVal(String num, int len) {
		if ((num.length() == len) && (num.matches("[0-9]+") == true))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// Now create a new Bank object
		Bank b = new Bank();
		Account myAcc = new Account();
		/*
		 * Account Type (chequing or saving) Account No (Exactly 6 to 16 digits: This
		 * condition must be retained all the time) Deposit for the account Withdraw for
		 * the account Getting the balance for the bank account
		 */
		Bank[] aaList = new Bank[500]; // 1000 is an arbitrary maximum number of entries

		// Get the data into variables
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		boolean eml_val = false;
		boolean dob_val = false;
		boolean sin_val = false;
		boolean mob_val = false;
		boolean acc_val = false;

		char std_chk = ' ', usr_chk = 'N', acc_typ = ' ';
		String a_name = "", add = "", email = "", dob = "", sin = "", mob = "", acc_chk = "";
		int bank_number = (100 + (int) (Math.random() * (500 - 100)));

		long llimit = 10000000L, rlimit = 49999999L;
		long acc_no = (llimit + (long) (Math.random() * (rlimit - llimit)));

		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int acc_ind = 0;
		int i = 0;

		// ----------------------------------------------------------------------------------------------------------
		// --------------------------------------------------PROGRAM
		// STARTS--------------------------------------------------
		// ----------------------------------------------------------------------------------------------------------

		do {
			if (acc_ind == 0) {
				System.out.println("Welcome to the DSP Bank!!! \n\n" + "Choose from below options.\n\n"
						+ "1. ) Create New Account\n" + "2. ) Check Bank Number\n" + "10.) Exit Application\n\n"
						+ "Please choose option by entering number indicated against it.\n"
						+ "<<<<<More options will be available once an account gets created>>>>>");

				choice = sc.nextInt();

				switch1: switch (choice) {
				case 1:
					// -------------------------------------------------------------------NEW
					// ACCOUNT GENERATION
					do {
						System.out.print("\nPlease enter below necessary details.\n\n");
						// ----------------------------------------------------------------------------------NAME
						a_name = "";
						a_name = b.var_check(a_name, "Name (Required Field): ");
						// -------------------------------------------------------------------------------ADDRESS
						add = "";
						add = b.var_check(add, "\nAddress (Required Field): ");
						// ---------------------------------------------------------------------------------EMAIL
						eml_val = false;
						email = "";
						while (eml_val == false) {
							email = b.var_check(email, "Valid Email Address (Required Field): ");
							eml_val = email.matches(regex);
						}
						// -------------------------------------------------------------------------DATE
						// OF BIRTH
						dob_val = false;
						dob = "";
						while (dob_val == false) {
							System.out.println("\n\nAccount holder must be atleast 18 years of age!!!");
							dob = b.var_check(dob, "Date of Birth (Required Field -> MM/DD/YYYY): ");
							dob_val = b.dobVal(dob);
						}
						// -----------------------------------------------------------------------------------SIN
						sin_val = false;
						sin = "";
						while (sin_val == false) {
							sin = b.var_check(sin, "SIN (Required): ");
							sin_val = b.numVal(sin, 9);
						}
						// --------------------------------------------------------------------------------MOBILE
						mob_val = false;
						mob = "";
						while (mob_val == false) {
							mob = b.var_check(mob, "Mobile Number (Required): ");
							mob_val = b.numVal(mob, 10);
						}
						// -------------------------------------------------------------------------IS a
						// STUDENT?
						std_chk = ' ';
						std_chk = b.var_check(std_chk, "\nAre you a Student (Y/ N)? ");

						// ---------------------------------------------------------------------------ACCOUNT
						// TYPE
						System.out.println("\n\nPlease enter an Account Type\nC for Chequeing\nS for Saving");
						acc_typ = ' ';
						acc_typ = b.typ_Check(acc_typ, "\nAccount Type (Required): ");

						// -------------------------------------------------------------ACCOUNT NUMBER
						// GENERATION
						acc_no += 7;

						// ----------------------------------------------------------------ACCOUNT
						// NUMBER DISPLAY
						System.out.println("\n\n*********************************************************************");
						System.out.println("Congratulations!!! Your Account has been successfully created.\n"
								+ "You Account number: " + acc_no);
						System.out.println("*********************************************************************\n\n");

						// Now create a new Data object with the information and add it to the array
						aaList[acc_ind] = new Bank(a_name, add, email, dob, sin, mob, std_chk, acc_no, acc_typ);

						// Variable Incrementation
						acc_ind++;

						usr_chk = 'N';
						usr_chk = b.var_check(usr_chk, "\nDo you want to create another account (Y/ N)? ");
					} while (usr_chk == 'Y');

					break switch1;

				case 2:
					// ----------------------------------------------------------------------BANK
					// Number Display
					System.out.println("\n\nBank Number differentiates one bank from another.\n"
							+ "First 3 numbers on your cheque are the Banking numbers.\n"
							+ "Banking Number for our bank: " + bank_number);
					break switch1;
				case 10:
					break switch1;
				default:
					System.out.println("Wrong Input");
				}
			} else {
				System.out.println("Welcome to the DSP Bank!!! \n\n" + "Choose from below options.\n\n"
						+ "1. ) Create New Account\n" + "2. ) Check Bank Number\n" + "3. ) Pay Bills\n"
						+ "4. ) Short Information regarding multiple accounts\n" + "5. ) Update Account Information\n"
						+ "6. ) Transfer Between Accounts\n" + "7. ) Access Loan Section\n"
						+ "8. ) Access Card Section\n" + "9. ) More information regarding Accounts and Functions\n"
						+ "10.) Exit Application\n\n"
						+ "Please choose option by entering number indicated against it.\n");

				choice = sc.nextInt();

				switch1: switch (choice) {
				case 1:
					// -------------------------------------------------------------------NEW
					// ACCOUNT GENERATION
					do {
						System.out.print("\nPlease enter below necessary details.\n\n");
						// ----------------------------------------------------------------------------------NAME
						a_name = "";
						a_name = b.var_check(a_name, "Name (Required Field): ");
						// -------------------------------------------------------------------------------ADDRESS
						add = "";
						add = b.var_check(add, "\nAddress (Required Field): ");
						// ---------------------------------------------------------------------------------EMAIL
						eml_val = false;
						email = "";
						while (eml_val == false) {
							email = b.var_check(email, "Valid Email Address (Required Field): ");
							eml_val = email.matches(regex);
						}
						// -------------------------------------------------------------------------DATE
						// OF BIRTH
						dob_val = false;
						dob = "";
						while (dob_val == false) {
							System.out.println("Account holder must be atleast 18 years of age!!!");
							dob = b.var_check(dob, "Date of Birth (Required Field -> MM/DD/YYYY): ");
							dob_val = b.dobVal(dob);
						}
						// -----------------------------------------------------------------------------------SIN
						sin_val = false;
						sin = "";
						while (sin_val == false) {
							sin = b.var_check(sin, "SIN (Required): ");
							sin_val = b.numVal(sin, 9);
						}
						// --------------------------------------------------------------------------------MOBILE
						mob_val = false;
						mob = "";
						while (mob_val == false) {
							mob = b.var_check(mob, "Mobile Number (Required): ");
							mob_val = b.numVal(mob, 10);
						}
						// -------------------------------------------------------------------------IS a
						// STUDENT?
						std_chk = ' ';
						std_chk = b.var_check(std_chk, "\nAre you a Student (Y/ N)? ");

						// ---------------------------------------------------------------------------ACCOUNT
						// TYPE
						System.out.println("\n\nPlease enter an Account Type\nC for Chequeing\nS for Saving");
						acc_typ = ' ';
						acc_typ = b.typ_Check(acc_typ, "\nAccount Type (Required): ");

						// -------------------------------------------------------------ACCOUNT NUMBER
						// GENERATION
						acc_no += 7;

						// ----------------------------------------------------------------ACCOUNT
						// NUMBER DISPLAY
						System.out.println("\n\n*********************************************************************");
						System.out.println("Congratulations!!! Your Account has been successfully created.\n"
								+ "You Account number: " + acc_no);
						System.out.println("*********************************************************************\n\n");

						// Now create a new Data object with the information and add it to the array
						aaList[acc_ind] = new Bank(a_name, add, email, dob, sin, mob, std_chk, acc_no, acc_typ);

						// Variable Incrementation
						acc_ind++;

						usr_chk = 'N';
						usr_chk = b.var_check(usr_chk, "\nDo you want to create another account (Y/ N)? ");
					} while (usr_chk == 'Y');

					break switch1;

				case 2:
					// ----------------------------------------------------------------------BANK
					// Number Display
					System.out.println("\n\nBank Number differentiates one bank from another.\n"
							+ "First 3 numbers on your cheque are the Banking numbers.\n"
							+ "Banking Number for our bank: " + bank_number);
					break switch1;

				case 3:
					System.out.print("\n\nWelcome to the DSP Bank's Bill Pay Service!!! \n\n"
							+ "Please enter your Account Number: \n");
					acc_chk = "";
					acc_val = false;
					while (acc_val == false) {
						acc_chk = b.var_check(acc_chk, "Account Number (Required): ");
						acc_val = b.numVal(acc_chk, 8);
					}

					inner: for (i = 0; i < acc_ind; i++) {
						if (String.valueOf(aaList[i].acc_no).equals(acc_chk)) {
							System.out.println("\nPlease enter bill amount: ");
							double bill = sc.nextDouble();
							// pay bill
							System.out.println("Bill paid");
							break inner;
						} else if (i == acc_ind)
							System.out.println("Account does not exist");
						System.out.println("i=" + i);
					}
					break switch1;

				case 4:
					System.out.print(
							"\nWelcome to the DSP Bank's Account Summary Page!!! \n\n" + "Please enter your SIN: ");
					sin = "";
					sin_val = false;
					while (sin_val == false) {
						sin = b.var_check(sin, "SIN (Required): ");
						sin_val = b.numVal(sin, 9);
					}
					for (i = 0; i < acc_ind; i++) {
						if (aaList[i].sin.equals(sin))
							System.out.print("\n" + String.valueOf(aaList[i].acc_no) + "\t" + aaList[i].a_name + "\t"
									+ aaList[i].email + "\t" + aaList[i].sin);
					}
					break switch1;
				case 5:
					System.out.println("Welcome to the DSP Bank!!! \n\n"
							+ "A valid Account Number is required to verify your account.\n");

					int choice3 = 0;
					acc_chk = "";
					acc_val = false;
					while (acc_val == false) {
						acc_chk = b.var_check(acc_chk, "Account Number (Required): ");
						acc_val = b.numVal(acc_chk, 8);
					}

					for (i = 0; i <= acc_ind; i++) {
						if (String.valueOf(aaList[i].acc_no).equals(acc_chk)) {
							// Verify account if student

							if ((aaList[i].std_chk == 'Y') | (aaList[i].std_chk == 'y')) {
								System.out.println("Welcome to the DSP Bank!!! \n\n"
										+ "Which piece of personal information would you like to update?\n\n"
										+ "1.) Name\n" + "2.) Address\n" + "3.) Email\n" + "4.) DOB\n" + "5.) SIN\n"
										+ "6.) Mobile\n" + "7.) Student Status\n\n"
										+ "Please choose option by entering number indicated against it.\n");
								choice3 = sc.nextInt();

								switch3: switch (choice3) {
								case 1:
									a_name = "";
									a_name = b.var_check(a_name, "Name (Required Field): ");
									aaList[i].a_name = a_name;
									break switch3;

								case 2:
									add = "";
									add = b.var_check(add, "\nAddress (Required Field): ");
									aaList[i].add = add;
									break switch3;

								case 3:
									// ---------------------------------------------------------------------------------EMAIL
									email = "";
									eml_val = false;
									while (eml_val == false) {
										email = b.var_check(email, "Valid Email Address (Required Field): ");
										eml_val = email.matches(regex);
									}
									aaList[i].email = email;
									break switch3;

								case 4:
									// -------------------------------------------------------------------------DATE
									// OF BIRTH
									dob = "";
									dob_val = false;
									while (dob_val == false) {
										dob = b.var_check(dob, "Date of Birth (Required Field -> MM/DD/YYYY): ");
										dob_val = b.dobVal(dob);
									}
									aaList[i].dob = dob;
									break switch3;

								case 5:
									// -----------------------------------------------------------------------------------SIN
									sin = "";
									sin_val = false;
									while (sin_val == false) {
										sin = b.var_check(sin, "SIN (Required): ");
										sin_val = b.numVal(sin, 9);
									}
									aaList[i].sin = sin;
									break switch3;

								case 6:
									// --------------------------------------------------------------------------------MOBILE
									mob = "";
									mob_val = false;
									while (mob_val == false) {
										mob = b.var_check(mob, "Mobile Number (Required): ");
										mob_val = b.numVal(mob, 10);
									}
									aaList[i].mob = mob;
									break switch3;

								case 7:
									// -------------------------------------------------------------------------IS
									// a STUDENT?
									std_chk = ' ';
									std_chk = b.var_check(std_chk, "\nAre you still a Student (Y/ N)? ");
									aaList[i].std_chk = std_chk;
									break switch3;

								default:
									System.out.println("Wrong Input!!!");
								}
							} else {
								System.out.println("Welcome to the DSP Bank!!! \n\n"
										+ "Which piece of personal information would you like to update?\n\n"
										+ "1.) Name\n" + "2.) Address\n" + "3.) Email\n" + "4.) DOB\n"
										+ "5.) Mobile\n\n"
										+ "Please choose option by entering number indicated against it.\n");
								choice3 = sc.nextInt();

								switch3: switch (choice3) {
								case 1:
									a_name = "";
									a_name = b.var_check(a_name, "Name (Required Field): ");
									aaList[i].a_name = a_name;
									break switch3;

								case 2:
									add = "";
									add = b.var_check(add, "\nAddress (Required Field): ");
									aaList[i].add = add;
									break switch3;

								case 3:
									// ---------------------------------------------------------------------------------EMAIL
									eml_val = false;
									email = "";
									while (eml_val == false) {
										email = b.var_check(email, "Valid Email Address (Required Field): ");
										eml_val = email.matches(regex);
									}
									aaList[i].email = email;
									break switch3;

								case 4:
									// -------------------------------------------------------------------------DATE
									// OF BIRTH
									dob_val = false;
									dob = "";
									while (dob_val == false) {
										dob = b.var_check(dob, "Date of Birth (Required Field -> MM/DD/YYYY): ");
										dob_val = b.dobVal(dob);
									}
									aaList[i].dob = dob;
									break switch3;

								case 5:
									// --------------------------------------------------------------------------------MOBILE
									mob_val = false;
									mob = "";
									while (mob_val == false) {
										mob = b.var_check(mob, "Mobile Number (Required): ");
										mob_val = b.numVal(mob, 10);
									}
									aaList[i].mob = mob;
									break switch3;

								default:
									System.out.println("Wrong Input!!!");
								}
							}
						} else if ((String.valueOf(aaList[i].acc_no) != acc_chk) & (i > acc_ind))
							System.out.println("Account does not exist");
					}

					break switch1;
				case 6:
					System.out.println("Transfer From Account: ");
					acc_val = false;
					acc_chk = "";
					while (acc_val == false) {
						acc_chk = b.var_check(acc_chk, "Account Number (Required): ");
						acc_val = b.numVal(acc_chk, 8);
					}
					outer: for (i = 0; i <= acc_ind; i++) {
						if (String.valueOf(aaList[i].acc_no).equals(acc_chk)) {
							System.out.println("Account exists");
							System.out.println("Transfer To Account: ");
							acc_val = false;
							acc_chk = "";
							while (acc_val == false) {
								acc_chk = b.var_check(acc_chk, "Account Number (Required): ");
								acc_val = b.numVal(acc_chk, 8);
							}

							for (int j = 0; j <= acc_ind; j++) {
								if (String.valueOf(aaList[j].acc_no).equals(acc_chk)) {
									System.out.println("Account exists");
									// Transfer
									break outer;
								} else if ((String.valueOf(aaList[i].acc_no) != acc_chk) & (i > acc_ind))
									System.out.println("Account does not exist");
							}
						} else if ((String.valueOf(aaList[i].acc_no) != acc_chk) & (i > acc_ind))
							System.out.println("Account does not exist");
					}
					break switch1;
				case 7:
					Loan l = new Loan();
					l.getData();
					l.display();

					break switch1;
				case 8:
					Cards c = new Cards();

					c.newCard();
					c.cardDisplay();

					break switch1;
				case 9:
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
						ch = sc.nextInt();
						switch (ch) {
						case 1:
							while (acc_val == false) {
								acc_chk = b.var_check(acc_chk, "Account Number (Required): ");
								acc_val = b.numVal(acc_chk, 8);
							}
							System.out.println("Enter a deposit amount");
							double deAmount = sc.nextDouble();
						//	myAcc.depositTo(acc_chk, deAmount);
							break;
						case 2:
							System.out.println("Enter a account number");
							int ac_Number = sc.nextInt();
							System.out.println("Enter a withdraw amount");
							double wiAmount = sc.nextDouble();
							 myAcc.withdrawFrom(ac_Number, wiAmount);
							break;
						case 3:
							System.out.println("Enter a account number");
							int accountNum = sc.nextInt();
							myAcc.printAccountInfo(accountNum);
							break;
						}
					} while (ch != '5');

					break switch1;
				case 10:
					break switch1;
				default:
					System.out.println("Wrong Input. Please enter again.");

				}
			}
		} while (choice != 10);

		sc.close();
	}

}
