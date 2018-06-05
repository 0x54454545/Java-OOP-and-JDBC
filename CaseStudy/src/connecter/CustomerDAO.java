package connecter;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Scanner;

import com.testing.cdw.Main;
import com.testing.cdw.Queries;

import getAndSet.CustomerDetailGetSet;

public class CustomerDAO extends JDBCconnection{
	
	
	//Social security gets passed from getCustomerDetails() in customer system
	public ArrayList<CustomerDetailGetSet> getExisting(String socialsec) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException{
		ArrayList<CustomerDetailGetSet> existingArray = new ArrayList<CustomerDetailGetSet>();
		CustomerDetailGetSet ge = new CustomerDetailGetSet();
		
		
		connect();
		PreparedStatement ps = con.prepareStatement(Queries.getCustomerDetails);
		
		ps.setString(1, socialsec);
		
		ResultSet rs = ps.executeQuery();
		
		if (!rs.isBeforeFirst() || rs.wasNull()) {
			System.out.println("Looks like the social security number you entered does not exist in our database.");
			}
		else {
			
			do {
			rs.next();
			ge.setFirstName(rs.getString("FIRST_NAME"));
			ge.setLastName(rs.getString("LAST_NAME"));
			ge.setCardNo(rs.getString("CREDIT_CARD_NO"));
			ge.setAptNo(rs.getString("APT_NO"));
			ge.setStreetName(rs.getString("STREET_NAME"));			
			ge.setcCity(rs.getString("CUST_CITY"));
			ge.setcState(rs.getString("CUST_STATE"));
			ge.setcCountry(rs.getString("CUST_COUNTRY"));
			ge.setcEmail(rs.getString("CUST_EMAIL"));
			
			existingArray.add(ge);
			
			System.out.println("First name: "+existingArray.get(0).getFirstName());
			System.out.println("Last name: "+existingArray.get(0).getLastName());
			System.out.println("Card number: "+existingArray.get(0).getCardNo());
			System.out.println("Apt number: "+existingArray.get(0).getAptNo());
			System.out.println("Street name: "+existingArray.get(0).getStreetName());
			System.out.println("City: "+existingArray.get(0).getcCity());
			System.out.println("State: "+existingArray.get(0).getcState());
			System.out.println("Country: "+existingArray.get(0).getcCountry());
			System.out.println("Email: "+existingArray.get(0).getcEmail());
			
			}while(rs.next());
			
		}//end of else statement
		
		return existingArray;
		
	}//end of get getExisting method
	
	//Get social security from updateAccountDetails()
	public ArrayList<CustomerDetailGetSet> updateExistingDetails (String socialsec) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		ArrayList<CustomerDetailGetSet> updateArray = new ArrayList<CustomerDetailGetSet>();
		connect();
		PreparedStatement ps = con.prepareStatement(Queries.getCustomerDetails);
		CallableStatement ups = con.prepareCall(Queries.modifyCustomerDetails);
		CustomerDetailGetSet ge = new CustomerDetailGetSet();
		
		ps.setString(1, socialsec);
		
		ResultSet rs = ps.executeQuery();
		
		
		if (!rs.isBeforeFirst()) {
			System.out.println("Looks like the social security number you entered does not exist in our database.");
			System.exit(0);
			}
		else {
			
			do {
			rs.next();
			ge.setFirstName(rs.getString("FIRST_NAME"));
			ge.setLastName(rs.getString("LAST_NAME"));
			ge.setAptNo(rs.getString("APT_NO"));
			ge.setCardNo(rs.getString("CREDIT_CARD_NO"));
			ge.setStreetName(rs.getString("STREET_NAME"));			
			ge.setcCity(rs.getString("CUST_CITY"));
			ge.setcState(rs.getString("CUST_STATE"));
			ge.setcCountry(rs.getString("CUST_COUNTRY"));
			ge.setcEmail(rs.getString("CUST_EMAIL"));
			ge.setcPhone(rs.getInt("CUST_PHONE"));
			ge.setcZip(rs.getString("CUST_ZIP"));
			}while(rs.next());
		}
		
		ups.setString(12, socialsec);
		System.out.println("You will now be entering your updates.");
		
		Scanner scan = new Scanner(System.in);

		Scanner input = new Scanner(System.in);
		int i = 0;
		//Scanner i = new Scanner(System.in);
		//menu = i.nextInt();
//		switch(menu) {
//			case 1: First name

				System.out.println("1. Do you want to update your first name? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				i = scan.nextInt();
				if (i == 1)
				{
					System.out.println("Enter your first name.");
					String fname=input.nextLine();
					ge.setFirstName(fname);
					ups.setString(1, fname);
				}
				else {
					ups.setString(1, ge.getFirstName());
				}

//			case 2: middle name
				System.out.println("2. Do you want to update your middle name? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				 i = scan.nextInt();
				if(i==1) {
					System.out.println("Enter your middle name.");
					String mName = input.nextLine();
					ge.setMiddleName(mName);
					ups.setString(2, mName);
				}
				else {
					ups.setString(2, ge.getMiddleName());
				}
//			case 3: Last name
				System.out.println("3. Do you want to update your last name? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				i = scan.nextInt();
				if(i==1) {
					System.out.println("Enter your last name.");
					String lName = input.nextLine();
					ge.setLastName(lName);
					ups.setString(3, lName);
				}
				else {
					ups.setString(3, ge.getLastName());
				}
//			case 4: Apt Number
				System.out.println("4. Do you want to update your Apartment number? ((Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				i = scan.nextInt();
				if(i==1) {
					System.out.println("Enter your apartment number.");
					String aNo = input.nextLine();
					ge.setAptNo(aNo);
					ups.setString(4, aNo);
				}
				else {
					ups.setString(4,  ge.getAptNo());
				}
//			case 5: Street Name
				System.out.println("5. Do you want to update your street name of where you live? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				i = scan.nextInt();
				if(i==1) {
					System.out.println("Enter the street name you want to update.");
					String stName = input.nextLine();
					ge.setStreetName(stName);
					ups.setString(5, stName);
				}
				else {
					ups.setString(5, ge.getStreetName());
				}
//			case 6: City
				System.out.println("6. Do you want to update your city of where you live? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				i = scan.nextInt();
				if(i==1) {
					System.out.println("Enter the city you want to update.");
					String city = input.nextLine();
					ge.setcCity(city);
					ups.setString(6, city);
				}
				else {
					ups.setString(6,  ge.getcCity());
				}
//			case 7: State
				System.out.println("7. Do you want to update the state in which you live in? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				i = scan.nextInt();
				if(i==1) {
					System.out.println("Enter the state you want to update.");
					String state = input.nextLine();
					ge.setcState(state);
					ups.setString(7, state);
					
				}
				else {
					ups.setString(7, ge.getcState());
				}
//			case 8: Country
				System.out.println("8. Do you want to update the country in which you live in? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				i = scan.nextInt();
				if(i==1) {
					System.out.println("Enter the country you want to update.");
					String country = input.nextLine();
					ge.setcState(country);
					ups.setString(8, country);
				}
				else {
					ups.setString(8, ge.getcCountry());
				}
//			case 9: Zip code
				System.out.println("9. Do you want to update your zip code? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				i = scan.nextInt();
				if(i==1) {
					System.out.println("Enter the zip code you want to update");
					String zip = input.nextLine();
					ge.setcZip(zip);
					ups.setString(9, zip);
				}
				else {
					ups.setString(9, ge.getcZip());
				}
//			case 10: Phone number
				System.out.println("10. Do you want to update the phone number? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				i = scan.nextInt();
				if(i==1) {
					System.out.println("Enter the new phone number without hypens.");
					int phone = input.nextInt();
	
					ge.setcPhone(phone);
					ups.setInt(10, phone);
				}
				else {
					ups.setInt(10, ge.getcPhone());
				}
			
//			case 11: Email
				System.out.println("11. Do you want to update the email? (Type in 1 for yes and any other **NUMBER** for no. For example, entering in 5 or 4 will mean no)");
				i = scan.nextInt();
				if(i==1) {
					System.out.println("Enter the new email");
					String email = input.nextLine();
					ge.setcEmail(email);
					ups.setString(11, email);

				}
				else {
					ups.setString(11, ge.getcEmail());

				}


		
				
				
		updateArray.add(ge);
		ResultSet urs = ps.executeQuery();
		while(urs.next()) {
			System.out.println("First name: "+updateArray.get(0).getFirstName());
			System.out.println("Last name: "+updateArray.get(0).getLastName());
			System.out.println("Card number: "+updateArray.get(0).getCardNo());
			System.out.println("Apt number: "+updateArray.get(0).getAptNo());
			System.out.println("Street name: "+updateArray.get(0).getStreetName());
			System.out.println("City: "+updateArray.get(0).getcCity());
			System.out.println("Zip: "+updateArray.get(0).getcZip());
			System.out.println("State: "+updateArray.get(0).getcState());
			System.out.println("Country: "+updateArray.get(0).getcCountry());
			System.out.println("Email: "+updateArray.get(0).getcEmail());
		}
		
		ups.executeUpdate();
		scan.nextLine();
		return updateArray;
	} // end of updateExistingDetails method
	

	
	public ArrayList<CustomerDetailGetSet> getBills (int m, int y, String ccNo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		ArrayList<CustomerDetailGetSet> billArray = new ArrayList<CustomerDetailGetSet>();
		ArrayList<CustomerDetailGetSet> billArray2 = new ArrayList<CustomerDetailGetSet>();
	
		
		CustomerDetailGetSet gb = new CustomerDetailGetSet();
		CustomerDetailGetSet gb2 = new CustomerDetailGetSet();

		connect();
		
		PreparedStatement ps = con.prepareStatement(Queries.getBill);
		PreparedStatement ps2 = con.prepareStatement(Queries.getBill2);

		
		ps.setInt(1, m);
		ps.setInt(2, y);
		ps.setString(3, ccNo);
		
		ps2.setInt(1, m);
		ps2.setInt(2, y);
		ps2.setString(3, ccNo);
		
		ResultSet rs = ps.executeQuery();
		ResultSet rs2 = ps2.executeQuery();
		rs.next();
		rs2.next();
		
		try {

			do {
				//getbill2 aka ps2/rs2= transaction type and group by transaction type
				//rs.next();
				gb2.setFirstName(rs2.getString("FIRST_NAME"));
				gb2.setLastName(rs2.getString("LAST_NAME"));
				gb2.setTransType(rs2.getString("transaction_type"));
				//Next line gets the individual sum spent on on a specific type as opposed to the TOTAL SUM
				gb2.setTransValue(rs2.getDouble("sum(transaction_value)"));
				//gb.setTransSum(rs.getDouble("sum(transaction_value)"));
				
				//billArray.add(gb);
				billArray2.add(gb2);

				System.out.println("Transaction Type: "+billArray2.get(0).getTransType()+" - "+billArray2.get(0).getTransValue());
				
				}while(rs2.next());
				
				do {
					gb.setTransSum(rs.getDouble("sum(transaction_value)"));
					billArray.add(gb);
					System.out.println("Total Sum: "+billArray.get(0).getTransSum());
				}while(rs.next());
			
			} catch (SQLException e) {
				System.out.println("Looks like the credit card number doesn't exist. Please check the credit card number.");
			}
		
	
		return billArray ;
	

		} //end of getBills method
		
	
	

	public ArrayList<CustomerDetailGetSet> getBillsDates(String ssn, String date1, String date2) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException{
		ArrayList<CustomerDetailGetSet> bdArray = new ArrayList<CustomerDetailGetSet>();
		CustomerDetailGetSet a = new CustomerDetailGetSet();
		
		connect();
		
		PreparedStatement ps = con.prepareStatement(Queries.getTransactionFromTwoDates);
		
		ps.setString(1, date1);
		ps.setString(2, date2);
		ps.setString(3, ssn);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		if (!rs.next() ) {
			System.out.println("Looks like there is no entry between these two dates.");
			}
		else {
			rs.next();
			do {
		
				a.setFirstName(rs.getString("FIRST_NAME"));
				a.setLastName(rs.getString("Last_Name"));
				a.setTransactionDate(rs.getString("TRANSACTION_DATE"));
				a.setTransValue(rs.getDouble("TRANSACTION_VALUE"));
				bdArray.add(a);
			
				System.out.println("First Name: "+bdArray.get(0).getFirstName());
				System.out.println("Last Name: "+bdArray.get(0).getLastName());
				System.out.println("Transaction date: "+bdArray.get(0).getTransactionDate());
				System.out.println("Transaction Value: "+bdArray.get(0).getTransValue());
				System.out.println("");
		
				}while(rs.next());
			}//end of else block
		
		return bdArray;
		
	}//end of getBillsDates block
	
}//end of CustomerDao class
