package com.testing.cdw;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;



public class Main {

	static Scanner i = new Scanner(System.in);
	
	static Scanner yay = new Scanner(System.in);
	
	public static void menu() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		CreditCardSystem ccs = new CreditCardSystem();
		CustomerSystem cs = new CustomerSystem();
		
		System.out.println("Welcome to CDW banking database. Please choose what you like to do today (type in the number and press enter) \n" +
							"1. Get your transaction given Zip code, month, and year \n" +
							"2. Get transaction values given transaction type \n" +
							"3. Get total number and value of transaction given branch state \n" +
							"4. Check existing details of a customer \n" +
							"5. Update customer details \n" +
							"6. Generate bill given month and year \n" +
							"7. Get transactions given two dates");
		
		int menu = 0;

		menu = i.nextInt();
		
		switch(menu) {
			//Start of Transaction Detail (CreditCardSystem) portion after this line 
			case 1: ccs.getUsingZip();
				boolean again = true;
				while(again)
					again = false;
				System.out.println("Do you want to continue? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
					int temp = yay.nextInt();
					if (temp == 1) {
						menu();
					}
					else {
						System.out.println("Good bye!");
						System.exit(0);
					}
				break;
			case 2: ccs.getUsingTransType();
			boolean again2 = true;
			while(again2)
				again2 = false;
			System.out.println("Do you want to continue? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				int temp2 = yay.nextInt();
				if (temp2 == 1) {
					menu();
				}
				else {
					System.out.println("Good bye!");
					System.exit(0);
				}
				break;
			case 3: ccs.getUsingState();
			boolean again3 = true;
			while(again3)
				again3 = false;
			System.out.println("Do you want to continue? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				int temp3= yay.nextInt();
				if (temp3 == 1) {
					menu();
				}
				else {
					System.out.println("Good bye!");
					System.exit(0);
				}
				break;
			//Start of Customer Detail (Customer System) portion after this line
			case 4: cs.getCustomerDetails();
			boolean again4 = true;
			while(again4)
				again4 = false;
			System.out.println("Do you want to continue? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				int temp4 = yay.nextInt();
				if (temp4 == 1) {
					menu();
				}
				else {
					System.out.println("Good bye!");
					System.exit(0);
				}
				break;
			//Start of Update module after this line
			case 5: cs.updateAccountDetails();
			boolean again5 = true;
			while(again5)
				again5 = false;
			System.out.println("Do you want to continue? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				int temp5 = yay.nextInt();
				if (temp5 == 1) {
					menu();
				}
				else {
					System.out.println("Good bye!");
					System.exit(0);
				}
				break;
			case 6: cs.getBillusingCC();
			boolean again6 = true;
			while(again6)
				again6 = false;
			System.out.println("Do you want to continue? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				int temp6 = yay.nextInt();
				if (temp6 == 1) {
					menu();
				}
				else {
					System.out.println("Good bye!");
					System.exit(0);
				}
				break;
			case 7: cs.getCustomerDetailMonth();
			boolean again7 = true;
			while(again7)
				again7 = false;
			System.out.println("Do you want to continue? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				int temp7 = yay.nextInt();
				if (temp7 == 1) {
					menu();
				}
				else {
					System.out.println("Good bye!");
					System.exit(0);
				}
				break;
			default: 
				System.out.println("Invalid choice.");
				boolean again8 = true;
				while(again8)
					again8 = false;
				System.out.println("Do you want to continue? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
					int temp8 = yay.nextInt();
					if (temp8 == 1) {
						menu();
					}
					else {
						System.out.println("Good bye!");
						System.exit(0);
					}

		}
		i.close();
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {
	
		menu();
		i.close();
		yay.close();
		

	}//end of main block

}//end of main class 


//Getting transaction given zip code, month, year - 39120, 02, 2018
//Get transaction values given transaction type - bills
//Get total number and value of transaction given branch state - NY 
//Check existing details of a customer - 123456100
//Update customer details - Use 123456100
//Generate bill - use 4210653344660822
/*Get transaction given two dates - 123456100 As for date, the month, day, and year will all be entered individually. For example
02/10/2018 (mm/dd/yyyy) will entered like this: mm. dd. yyyy for first date. Second date would be mm. dd. yyyy. 
*/
