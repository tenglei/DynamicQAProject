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
			String url = "jdbc:mysql://localhost:3306/"+name+"?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url,"root","qweasd");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
