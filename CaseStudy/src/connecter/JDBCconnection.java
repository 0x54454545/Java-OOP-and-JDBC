package connecter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

@SuppressWarnings("unused")
public abstract class JDBCconnection {
	public Connection con = null;
	public ResultSet rs;
	public PreparedStatement ps;

		protected void connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			FileReader f = new FileReader("database.properties");
			
			Properties p = new Properties();
			p.load(f);
			
			System.out.println("Connecting to CDW database...");
			con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
			
			if(con.isValid(0)) {
				System.out.println("You are connected! \n");
			}
			else {
				System.out.println("Check your credentials and/or SQL url");
			}
		}
		
	
}

