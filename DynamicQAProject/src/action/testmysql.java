package action;

import java.sql.*;

public class testmysql 
{
	/*
	public static void InsertSql()
	{
        try
        {
        	String insql="insert into user(Name,PassWord,Email,UserID) values(?,?,?,?)";
        	Connection conn = new initialize().getlink();
            PreparedStatement ps=conn.prepareStatement(insql);
            ps.setString(1, "222");
            ps.setString(2, "222");
            ps.setString(3, "222");
            ps.setString(4,"222");
            int result=ps.executeUpdate();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
	public static void main(String[] args)
	{
		InsertSql();
	}
	*/
	/*
	public static void testfixdata()
	{
		int idnum = 0;
		try
		{
			Connection a1 = new initialize().getlink();
			String sql2 = "select * from nowinformation";
			String sql3 = "";
			String s1 = "";
			Statement stmt2 = a1.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			while(rs2.next()!=false)
			{
				idnum = Integer.parseInt(rs2.getString(1))+1;
				s1 = rs2.getString(1);
				System.out.println(s1);
			}
			sql3 = "update nowinformation set idnow="+"\""+String.valueOf(idnum)+"\""+"where idnow="+"\""+s1+"\"";                
			stmt2.executeUpdate(sql3);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(idnum);
	}
	*/
	/*
	public static void buildbase2(String authorname)
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
			String sql3 = "create database "+authorname+String.valueOf(QAnum);
			stat.executeUpdate(sql3);//创建了数据库
			stat.close();
			conn.close();
			//以下初始化数据库中所有的表
			Connection conn2 = new initialize().getlink(authorname+String.valueOf(QAnum));
			try{
				Statement stat2 = conn2.createStatement();
				stat2.executeUpdate("create table property(QAid varchar(10),authorid varchar(4),classname varchar(10),totalscore int,choicenum int,fillnum int,QAnum int,totalans int,testlink varchar(80))");
				stat2.executeUpdate("create table choice(question varchar(255),Ach varchar(80),Bch varchar(80),Cch varchar(80),Dch varchar(80), answer varchar(1),score int)");
				stat2.executeUpdate("create table fill(blanknum int,question varchar(255),answer varchar(80),score int)");
				stat2.executeUpdate("create table QA(question varchar(255),answer varchar(255),keywords varchar(80),score int)");
				stat2.executeUpdate("create table list(mingci int,name varchar(80),score int)");
				
				String sql4="insert into property(QAid,authorid,classname,totalscore,choicenum,fillnum,QAnum,totalans) values(?,?,?,?,?,?,?,?)";
				PreparedStatement ps=conn2.prepareStatement(sql4);
				ps.setString(1,"qwe2");
				ps.setString(2,"11");
				ps.setString(3, "asd");
				ps.setInt(4, 0);//总的分值暂定是0
				ps.setInt(5, 0);
				ps.setInt(6, 0);
				ps.setInt(7, 0);
				ps.setInt(8, 0);
				ps.executeUpdate();
				
				stat2.close();
				conn2.close();
				System.out.println("aaa");
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
	}
	*/
	/*
	public static String delete()
	{
		Connection conn = new initialize().getlink("project");
		try
		{
			Statement stat = conn.createStatement();
			String sql = "drop database "+"ybk";
			stat.executeUpdate(sql);
			stat.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "deletesuccess";
	}
	*/
	/*
	public static void getnum()
	{
		Connection conn = new initialize().getlink("project");
		String sql = "select count(*) from allpaper";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
		}
		catch (Exception e) { 
				e.printStackTrace(); 
			} 
	}
	*/
	public static void randomCommon(int min, int max, int n){//生成随机数  
	    int[] result = new int[n];  
	    int count = 0;  
	    while(count < n) {  
	        int num = (int) (Math.random() * (max - min)) + min;  
	        boolean flag = true;  
	        for (int j = 0; j < n; j++) {  
	            if(num == result[j]){  
	                flag = false;  
	                break;  
	            }  
	        }  
	        if(flag){  
	        	//Connection conn = new initialize().getlink("gongyou");
	        	
	        	System.out.println(num);
	        	//String sql="insert into gongyou qa select * from project allqa where id=2";
	        
	        	
	            result[count] = num;  
	            count++;  
	        }  
	    }    
	}  
	/*
	public static void getRannum()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println((int)(4*Math.random()+1));
		}
	}
	*/
	public static void t1()
	{
		Connection conn = new initialize().getlink("gongyou");
    	
    	//System.out.println(num);
    	String sql="insert into gongyou.qa select * from project.allqa limit 3,1";
    	try{
    		PreparedStatement ps=conn.prepareStatement(sql);
    		ps.executeUpdate();
    	}
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		
		testmysql.t1();
	}
	/*
	public String fanhui(String p)
	{
		if(p.length() == 3)
		{
			return "shit";
		}
		else
		{
			return "fuck you";
		}
	}
	*/

}
