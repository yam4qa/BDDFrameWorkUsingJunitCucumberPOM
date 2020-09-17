package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database 
{
	static String Qry;
	public static String get(String columnName) throws ClassNotFoundException, SQLException 
	{
		// Setting properties for mysql
		Class.forName("com.mysql.cj.jdbc.Driver");
		// creating a connection to your local database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sirilabs", "root", "root");
		// empowering the con reference valiable to execute queries
		Statement smt = con.createStatement();
		// delivering the sql query
		Qry = "select * from users";
		ResultSet rs = smt.executeQuery(Qry);
		while (rs.next()) 
		{
			return rs.getString(columnName);
		} 
		return null; 
	}

}
