package action;

import java.sql.*;

public class finishedit 
{
	private String welcomename;
	private String authorname;
	private String name;
	private String editname;
	public String back()//回到登录界面，并且生成问卷号码
	{
		this.welcomename = this.authorname;
		this.name = this.editname;
		System.out.println(name);
		System.out.println(welcomename);
		Connection conn = new initialize().getlink(name);
		String testlink = "http://localhost:8080/DynamicQAProject/huida.action?wenjuanhao="+this.name;                     
		try
		{
			String sql = "update property set testlink="+"\""+testlink+"\""+" where QAid="+"\""+this.name+"\"";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "successback";
	}
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	public String getEditname() {
		return editname;
	}
	public void setEditname(String editname) {
		this.editname = editname;
	}
	public String getWelcomename() {
		return welcomename;
	}
	public void setWelcomename(String welcomename) {
		this.welcomename = welcomename;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	
}
