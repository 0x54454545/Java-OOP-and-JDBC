package com.testing.cdw;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import connecter.JDBCconnection;
import connecter.TransactionDAO;
import resources.InvalidStateException;



public class CreditCardSystem extends JDBCconnection {

		//Constructor
		CreditCardSystem(){};
		Scanner scan = new Scanner(System.in);
		
		public void getUsingZip() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {
			String userZip=null;
			int userMonth=0;
			int userYear=0;
			boolean again = true;
			boolean again2 = true;
			boolean again3 = true;
			
		while (again) {
				again = false;
			try {
			System.out.println("Enter the zipcode you want to find: ");
			userZip = scan.next();
			if (userZip.length() > 5 || userZip.length() < 5)
				throw new Exception();
			}catch (Exception e) {
				System.out.println("Zipcode length cannot be greater or less than 5 digits");
				again = true;
				}
			}
			
			while (again2) {
				again2 = false;
			try {
			System.out.println("Enter in the month of the transaction (in number format): ");
			userMonth = scan.nextInt();
			if (userMonth > 12 || userMonth < 1)
				throw new Exception();
			}catch (Exception e) {
				System.out.println("The month cannot be greater than 12 or less than 1");
				again2 = true;
				}
			}
			
			while (again3) {
				again3 = false;
			try {
			System.out.println("Enter in the year of the transaction: ");
			userYear = scan.nextInt();
			if (userYear > 2100 || userYear < 1900)
				throw new Exception();
			}catch (Exception e) {
				System.out.println("The year cannot be greater than 2100 and less than 1900");
				again3 = true;
				}
			}
			//Passes the parameters in object TransactionDAO to TransactionDAO
			TransactionDAO tdo = new TransactionDAO();
			tdo.getByzip(userZip, userMonth, userYear);
			

		}
		
		public void getUsingTransType() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
				
			System.out.println("Enter the transaction type you want to check: ");
			String transType = scan.next();
				
			TransactionDAO tt = new TransactionDAO();
			tt.getByType(transType);

		
		}
			

		public void getUsingState() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
			String state = null;
			String[] strs = {"AK","AL","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};
			List<String> bStates = new ArrayList<String>();
			bStates.addAll(Arrays.asList(strs));
			
			Iterator<String> iterator = bStates.iterator();
			boolean again = true; //for controlling the loop so that it will ask for user input if exception is found 
			
			while (again == true) {
				again = false;
				try {
					System.out.println("Enter the state abbreviated (for example: NY or NJ) you want to check: ");
					String temp = scan.nextLine();
					temp = temp.toUpperCase();
					while (iterator.hasNext()) {
						if(bStates.contains(temp)) {
							state = temp;
							break;
						} else {
							throw new InvalidStateException();
						}
					}
				}catch (InvalidStateException e) {
					System.out.println("Looks like you entered an invalid state/format!");
					again = true;
					
				}
			}
			TransactionDAO ts = new TransactionDAO();
			ts.getByState(state);
			
			
		}
}
