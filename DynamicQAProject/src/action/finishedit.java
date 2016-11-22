package action;

import java.sql.*;

public class finishedit 
{
	private String welcomename;
	private String authorname;
	private String name;
	private String editname;
	private String wenjuanclass;//问卷类型
	private String wenjuanname;//作者自定义的问卷的名字，可以用于查找
	public String back()//回到登录界面，并且生成问卷号码,把新生成的问卷号加入到用户属性中,把新生成的问卷号加入到问卷总列表和各个类型的分列表中，设置问卷的类别（大学、生活、情感）
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
		Connection conn2 = new initialize().getlink("project");
		String temp = "";
		try
		{
			String sql2 = "select * from user where Name="+"\""+this.authorname+"\"";
			Statement stat2 = conn2.createStatement();
			ResultSet rs2 = stat2.executeQuery(sql2);
			while(rs2.next()!=false)
			{
				temp = rs2.getString(6);
			}
			rs2.close();
			stat2.close();
			Statement stat3 = conn2.createStatement();
			String sql3 = "update user set wenjuanhao="+"\""+temp+" "+this.name+"\""+" where Name="+"\""+this.authorname+"\"";
			stat3.executeUpdate(sql3);
			stat3.close();
			//conn2.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		/*下面把新的问卷号码加入总的问卷表中*/
		String sql4="insert into allpaper(paper) values(?)";
		try{
			PreparedStatement ps=conn2.prepareStatement(sql4);
			ps.setString(1,this.name);
			ps.executeUpdate();
			//conn2.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//插入到分过类的的问卷表中
		String sql7="insert into "+this.wenjuanclass+"(paper) values(?)";
		try{
			PreparedStatement ps2=conn2.prepareStatement(sql7);
			ps2.setString(1,this.name);
			ps2.executeUpdate();
			conn2.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//下面把问卷的类型加入到问卷属性中
		Connection conn3 = new initialize().getlink(this.name);
		try
		{
			Statement stat4 = conn3.createStatement();
			String sql5 = "update property set classname="+"\""+this.wenjuanclass+"\""+" where QAid="+"\""+this.name+"\"";
			stat4.executeUpdate(sql5);
			Statement stat5 = conn3.createStatement();
			String sql6 = "update property set papername="+"\""+this.wenjuanname+"\""+" where QAid="+"\""+this.name+"\"";
			stat5.executeUpdate(sql6);
			stat4.close();
			stat5.close();
			conn3.close();
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
	public String getWenjuanclass() {
		return wenjuanclass;
	}
	public void setWenjuanclass(String wenjuanclass) {
		this.wenjuanclass = wenjuanclass;
	}
	public String getWenjuanname() {
		return wenjuanname;
	}
	public void setWenjuanname(String wenjuanname) {
		this.wenjuanname = wenjuanname;
	}
	
}
