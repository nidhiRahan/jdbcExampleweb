/**
 * 
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author rahan
 *
 */
public class Datahelper {

	Connection con;
	Statement st;
	public void makeConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","nidhi@123");
	}
	
	public int dmlRecord(String query) throws SQLException
	{
		st = con.createStatement();
		return st.executeUpdate(query);
	}
	public ResultSet dqlRecord(String query) throws SQLException
	{
		st = con.createStatement();
		return st.executeQuery(query);
	}
	public void closeConnection() throws SQLException
	{
		con.close();
	}
	
}
