package com.testing.cdw;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import connecter.CustomerDAO;

public class CustomerSystem {
	
	Scanner scan = new Scanner(System.in);
	
	
	public void getCustomerDetails() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		String ssn = null;
		boolean again = true;
		
		
		while (again) {
			again = false;
		try {
		System.out.println("Enter the social security number of the person you want to find: ");
		ssn = scan.nextLine();
		if (ssn.length() > 9 || ssn.length() < 9 )
			throw new Exception();
		}catch(Exception e) {
			System.out.println("The length of the Social security number cannot be greater or less than 9.");
			again = true; //force user to re-enter values.
			}
		}
		CustomerDAO cd = new CustomerDAO();
		cd.getExisting(ssn);
		
	}
	
	//Method for updating customer account details.
	public void updateAccountDetails() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		String ssn = null;
		boolean again = true;
		
		
		while (again) {
			again = false;
		try {
		System.out.println("Enter the social security number of the person you want to find: ");
		ssn = scan.nextLine();
		if (ssn.length() > 9 || ssn.length() < 9 )
			throw new Exception();
		}catch(Exception e) {
			System.out.println("The length of the Social security number cannot be greater or less than 9.");
			again = true; //force user to re-enter values.
			}
		}
		
		CustomerDAO cd = new CustomerDAO();
		cd.updateExistingDetails(ssn);

	}
	
	public void getBillusingCC() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException, InputMismatchException {
		int month = 0;
		int year = 0;
		boolean again = true;
		boolean again2 = true;
	

		while(again) {
			again = false;
			System.out.print("Enter the month (in mm format) for your bill: ");
	
				int temp = scan.nextInt();
				if(temp <= 12 && temp >= 1) {
					month = temp;
					} 
				else {
					System.out.println("The month cannot be above 12 or below 1.");
					//scan.next();
					again = true;
				
					}
		}
		
		
		
		while (again2) {
			again = false;
			System.out.println("Enter the year (in yyyy format) you want to look up: ");
			if (scan.hasNextInt()) {
				int temp = scan.nextInt();
				if (temp <= 2100 && temp >= 1900) {
					year = temp;
					break;
				}else { 
					System.out.println("The year cannot be above 2100 or below 1900.");
					again = true;
				}
			}
			
		}
		
		System.out.println("Enter the credit card number to pull up bill information: ");
		String credCard = scan.next();
		
		CustomerDAO gbcc = new CustomerDAO();

		gbcc.getBills(month, year, credCard);


	}
		
	
	public void getCustomerDetailMonth() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		
		
		String ssn = null;
		int month=0;
		int month2=0; 
		int day=0;
		int day2=0;
		int year=0;
		int year2=0;
		
		//Flags to loop the program
		boolean again1=true;
		boolean again2=true;
		boolean again3=true;
		boolean again4=true;
		boolean again5=true;
		boolean again6=true;
		boolean again7=true;
		
		while (again1) {
			again1 = false;
		try {
			System.out.println("Enter the social security number: ");
			ssn = scan.next();
			if (ssn.length() > 9 || ssn.length() <9)
				throw new Exception();
		}catch (Exception e) {
			System.out.println("The length of the Social security number cannot be greater or less than 9 and must be numbers.");
			again1 = true;	
			}
		}
		
		
		while(again2) {
			again2 = false;
			System.out.print("Enter the month of the first date (in mm format for example 02 for February) you want to compare: ");
				int temp = scan.nextInt();
				if(temp <= 12 && temp >= 1) {
					month = temp;
					} 
				else {
					System.out.println("The month cannot be above 12 or below 1");
					again2 = true;
					}

			}
		
		while (again3) {
			again3 = false;
			System.out.println("Enter the day of the first date (in dd format for example 31) you want to compare: ");
				int temp = scan.nextInt();
				if (temp <= 31 && temp >= 1) {
					day = temp;
				}
			
			else { 
				System.out.println("The day cannot be above 31 or below 1 and must only be numbers.");
				again3 = true;
			}	
		}
		
		while (again4) {
			again4 = false;
			System.out.println("Enter the year of the first date (in yyyy format for example 2018) you want to compare: ");
	
				int temp = scan.nextInt();
				if (temp <= 2100 && temp >= 1900) {
					year = temp;
				}else { 
					System.out.println("The year cannot be above 2100 or below 1900. Enter anything to continue.");
					again4 = true;
				}
			
		}
		
		while(again5) {
			again5 = false;
			System.out.print("Enter the month (in mm format) of the second date you want to compare: ");
				int temp = scan.nextInt();
				if(temp <= 12 && temp >= 1) {
					month2 = temp;
				} else {
					System.out.println("The month cannot be above 12 or below 1");
					scan.next();
					again5=true;
					}

			}
		
		while (again6) {
			again6 = false;
			System.out.println("Enter the second day (in dd format) of the second date you want to compare: ");
				int temp = scan.nextInt();
				if (temp <= 31 && temp >= 1) {
					day2 = temp;
				}
				else { 
				System.out.println("The day cannot be above 31 or below 1 and must only be numbers.");
				again6 = true;
			}
			
		}
		
		
		while (again7) {
			again7 = false;
			System.out.println("Enter the second year (in yyyy format) of the second date you want to compare: ");
			int temp = scan.nextInt();
			if (temp <= 2100 && temp >= 1900) {
					year2 = temp;
				}
			else { 
					System.out.println("The year cannot be above 2100 or below 1900.");
					scan.next();
					again7=true;
				}
			
		}
		
		String date1 = year + "-" + month + "-" + day;
		String date2 = year2 + "-" + month2 + "-" + day2;
		
		System.out.println(date1);
		
		CustomerDAO cM = new CustomerDAO();
		cM.getBillsDates(ssn,date1, date2);

	}//end of getCustomerDetailMonth block

	}

	
