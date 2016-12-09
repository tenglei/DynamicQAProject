package action;

import java.sql.*;

public class initialize {
	public Connection getlink(String name)
	{
		Connection conn = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			String url = "jdbc:mysql://127.0.0.1:3306/"+name+"?useSSL=true";
			conn = DriverManager.getConnection(url,"root","qweasd");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
