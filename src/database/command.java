package database;

import java.sql.*;


public class command {

	public static void main(String[] args) {
		try {
		

			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/B5774500/Database1.accdb");
			Statement s = conn.createStatement();
			
			//s.executeUpdate("insert into lab6 (sakul,country,cast) values('fsf','Gafme',12345)"); 
			//s.executeUpdate("insert into lab6 (sakul,country,cast) values('rwfe','32212',3223)");
			
			
			ResultSet rs = s.executeQuery("SELECT * FROM lab6");
			

			
			while (rs.next()) {
				//System.out.println(rs.getString(1));
				System.out.println("\n"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
		} catch (Exception e) {

			System.out.println(e);

		}

	}
}
