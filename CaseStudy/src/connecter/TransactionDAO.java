package connecter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.testing.cdw.Queries;

import getAndSet.TransactionDetailGetSet;

public class TransactionDAO extends JDBCconnection {
	
	
	//Parameters received from getUsingZip() in creditCardSystem class
	public ArrayList<TransactionDetailGetSet> getByzip(String Zip, int Month, int Year) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		ArrayList<TransactionDetailGetSet> zipArray = new ArrayList<TransactionDetailGetSet>();
		TransactionDetailGetSet z = new TransactionDetailGetSet();
		
		connect();
		PreparedStatement ps = con.prepareStatement(Queries.getTransactionOrderByDay);
		
		ps.setString(1, Zip);
		ps.setInt(2, Month);
		ps.setInt(3, Year);

		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		if (/*!rs.isBeforeFirst() ||*/ rs.wasNull()) {
			System.out.println("No entry in the database with these inputs (Zip: "+Zip+" Month: "+Month+" Year: "+Year+")." + " Please try a different input!");
		}
		else {
			do {
				//rs.next();
				z.setFirstName(rs.getString("FIRST_NAME"));
				z.setlastName(rs.getString("LAST_NAME"));
				z.setTransType(rs.getString("TRANSACTION_TYPE"));
				z.setTransValue(rs.getString("TRANSACTION_VALUE"));
			
				zipArray.add(z);
				
				File file = new File("hello.txt");
				
				if(file.createNewFile()) {
					System.out.println("File created!");
				}

				FileWriter write = new FileWriter(new File("hello.txt"),true);
				write.append(zipArray.get(0).getFirstName()+",");
				write.append(zipArray.get(0).getlastName()+",");
				write.append(zipArray.get(0).getTransType()+",");
				write.append(zipArray.get(0).getTransValue()+"\n");
				
				write.flush();
				write.close();
			
				System.out.println("First name: " + zipArray.get(0).getFirstName());
				System.out.println("Last Name: " + zipArray.get(0).getlastName());
				System.out.println("Transaction Type: " + zipArray.get(0).getTransType());
				System.out.println("Transaction Value: " + zipArray.get(0).getTransValue());
				System.out.println("");
				
				
				}while (rs.next());
			
			}
		
		
		

		
		return zipArray;
	}

		
	
	
		
	//Parameters received from getUsingTransType() in CreditCardSystem class
	public ArrayList<TransactionDetailGetSet> getByType(String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException{
		ArrayList<TransactionDetailGetSet> typeArray = new ArrayList<TransactionDetailGetSet>();
		TransactionDetailGetSet t = new TransactionDetailGetSet();
		
		connect();
		PreparedStatement ps = con.prepareStatement(Queries.getTotalValuesAndNumber);
		
		ps.setString(1, type);
		
		ResultSet rs = ps.executeQuery();
		
		
		if (!rs.isBeforeFirst() || rs.wasNull()) {
			System.out.println("Sorry the transaction type, "+type+" does not exist. Please try again!");
		}
		else {
			do {
			
			rs.next();
			t.setTransType(rs.getString("TRANSACTION_TYPE"));
			t.setCount(rs.getInt("COUNT(TRANSACTION_ID)"));
			t.setSum(rs.getDouble("SUM(TRANSACTION_VALUE)"));
			
			typeArray.add(t);
			
			System.out.println("Transaction Type: "+ typeArray.get(0).getTransType());
			System.out.println("Total transaction count for this transaction type: " + typeArray.get(0).getCount());
			System.out.println("Total amount spent: " + typeArray.get(0).getSum());
			System.out.println(" ");
		
			
			
			}while (rs.next());
			
		}
		return typeArray;
	} //end of method
	
	
	//Get by state gets from getUsingState() in CreditCardSystem class
	public ArrayList<TransactionDetailGetSet> getByState (String state) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		ArrayList<TransactionDetailGetSet> stateArray = new ArrayList<TransactionDetailGetSet>();
		TransactionDetailGetSet s = new TransactionDetailGetSet();
		
		connect();
		PreparedStatement ps = con.prepareStatement(Queries.getTransactionFromBranch);
		
		ps.setString(1, state);
		
		ResultSet rs = ps.executeQuery();
		
		if (!rs.isBeforeFirst() || rs.wasNull()) {
			System.out.println("Entry for "+state+" does not exist. Please try a different state.");
			}
		else {
		
			do {
			rs.next();
			s.setState(rs.getString("BRANCH_STATE"));
			s.setTransType(rs.getString("TRANSACTION_TYPE"));
			s.setCount(rs.getInt("COUNT(TRANSACTION_ID)"));
			s.setSum(rs.getDouble("SUM(TRANSACTION_VALUE)"));
			
			stateArray.add(s);
			
			System.out.println("Branch: "+ stateArray.get(0).getState());
			System.out.println("Transaction type: " + stateArray.get(0).getTransType());
			System.out.println("Total transaction count for this transaction type: " + stateArray.get(0).getCount());
			System.out.println("Total amount spent: " + stateArray.get(0).getSum());
			System.out.println(" ");
			} while(rs.next()); 
		} 
		return stateArray;

	}//end of method block
}
