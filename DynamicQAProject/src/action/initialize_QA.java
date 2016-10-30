package action;//用于初始化一个问卷表

import java.sql.*;

 
public class initialize_QA 
{
	private String authorname;
	public String buildbase()
	{
		int QAnum = 0;//先得到问卷号码,并且更新问卷的号码
		String a = "";
		Connection conn = new initialize().getlink("project");
		try 
		{
			String sql = "select * from nowinformation";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()!=false)
			{
				QAnum = Integer.parseInt(rs.getString(1))+1;
				a = rs.getString(1);
			}
			String sql2 = "update nowinformation set QAnumnow="+"\""+String.valueOf(QAnum)+"\""+"where QAnumnow="+"\""+a+"\"";
			stat.executeUpdate(sql2);
			String sql3 = "create database "+this.authorname+String.valueOf(QAnum);
			stat.executeUpdate(sql3);//创建了数据库
			stat.close();
			conn.close();
			//以下初始化数据库中所有的表
			Connection conn2 = new initialize().getlink(this.authorname+String.valueOf(QAnum));
			try{
				Statement stat2 = conn2.createStatement();
				stat2.executeUpdate("create table property(QAid varchar(10),authorid varchar(2),classname varchar(10),totalscore int,choicenum int,fillnum int,QAnum int,totalans int,testlink varchar(80))");
				stat2.executeUpdate("create table choice(question varchar(255),Ach varchar(80),Bch varchar(80),Cch varchar(80),Dch varchar(80), answer varchar(1),score int)");
				stat2.executeUpdate("create table fill(blanknum int,question varchar(255),answer varchar(80),score int)");
				stat2.executeUpdate("create table QA(question varchar(255),answer varchar(255),keywords varchar(80),score int)");
				stat2.executeUpdate("create table list(mingci int,name varchar(80),score int)");
				stat2.close();
				conn2.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "successbuild";
	}
}
