package action;//用于初始化一个问卷表

import java.sql.*;

 
public class initialize_QA 
{
	private String authorname;
	private String authorid;
	private String biaoqian;
	private String basename;
	private String password;//这里要设置密码，目的是返回
	public String buildbase()
	{
		//System.out.println("得到的用户名是：");
		//System.out.println(this.authorname);
		
		int QAnum = 0;//先得到问卷号码,并且更新问卷的号码
		String a = "";
		Connection conn = new initialize().getlink("project");
		try
		{
			String sql3 = "select * from user where Name=\""+this.authorname+"\"";
			Statement stat3 = conn.createStatement();
			ResultSet rs3 = stat3.executeQuery(sql3);
			while(rs3.next()!=false)
			{
				this.authorid = rs3.getString(4);
				this.biaoqian = rs3.getString(5);
				this.password = rs3.getString(2);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
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
			this.basename = this.authorname+String.valueOf(QAnum);
			//以下初始化数据库中所有的表
			Connection conn2 = new initialize().getlink(this.authorname+String.valueOf(QAnum));
			try{
				Statement stat2 = conn2.createStatement();
				stat2.executeUpdate("create table property(QAid varchar(30),authorid varchar(4),classname varchar(10),totalscore float,choicenum int,fillnum int,QAnum int,totalans int,testlink varchar(200),papername varchar(30),state int");
				stat2.executeUpdate("create table choice(question varchar(255),Ach varchar(80),Bch varchar(80),Cch varchar(80),Dch varchar(80), answer varchar(1),score float)");
				stat2.executeUpdate("create table fill(blanknum int,question varchar(255),answer varchar(80),score float)");
				stat2.executeUpdate("create table QA(question varchar(255),answer varchar(255),keywords varchar(80),score float)");
				stat2.executeUpdate("create table list(mingci int,name varchar(80),score float)");
				//以下插入第一个表的初始化信息
				String sql4="insert into property(QAid,authorid,classname,totalscore,choicenum,fillnum,QAnum,totalans,testlink,papername,state) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=conn2.prepareStatement(sql4);
				ps.setString(1,this.authorname+String.valueOf(QAnum));
				ps.setString(2,this.authorid);
				ps.setString(3, this.biaoqian);
				ps.setInt(4, 0);//总的分值暂定是0
				ps.setInt(5, 0);
				ps.setInt(6, 0);
				ps.setInt(7, 0);
				ps.setInt(8, 0);
				ps.setString(9, "该部分尚未完成开发！");
				ps.setString(10, " ");
				ps.setInt(11,1);//1代表问卷开放了
				ps.executeUpdate();
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
	public void setauthorname(String authorname)
	{
		this.authorname = authorname;
	}
	public String getauthorname()
	{
		return authorname;
	}
	public void setauthorid(String authorid)
	{
		this.authorid = authorid;
	}
	public void setbiaoqian(String biaoqian)
	{
		this.biaoqian = biaoqian;
	}
	public String getBasename() {
		return basename;
	}
	public void setBasename(String basename) {
		this.basename = basename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
