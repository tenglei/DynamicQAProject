package action;

//这里定义了一些通用的函数
import java.sql.*;

public class tongyong 
{
	public String getExact(Connection conn,String tablename,int rank,int num)//rank 是第rank+1条记录！,num是维度
	{
		String c = "";
		String sql="select * from "+tablename+" limit "+String.valueOf(rank)+",1";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				c = rs.getString(num);
			}
    	}
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return c;
	}
	
	
	
	public int getjilu(Connection conn,String tablename)//得到某个表的记录总数
	{
		int x = 0;
		String sql = "select count(*) from "+tablename;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				x = Integer.parseInt(rs.getString(1));
			}
		}
		catch (Exception e) { 
				e.printStackTrace(); 
			} 
		return x;
	}
	
	
	
	public static String getsth(Connection conn,String tablename,String keyvalue,String keyname,int num)//函数，得到一些东西
	{
		String x = "";
		try{
			String sql = "select * from "+tablename+" where "+keyname+"="+"\""+keyvalue+"\"";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()!=false)
			{
				x = rs.getString(num);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		if(x==null)
		{
			return "";
		}
		else
		{
			return x;
		}
	}
	
	
	
	public static void main(String[] args)
	{
		Connection conn = new initialize().getlink("project");
		System.out.println(getsth(conn,"user","tl","Name",5));
	}
	
	
	
	
	
	
	public void updatebase(Connection conn,int i,float score)//插入选择题、填空题或者大题的时候更新问卷数据库
	{
		try 
		{
			String sql = "select * from property";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			float x = 0;
			int num=0;
			String QAid = "";
			while(rs.next()!=false)
			{
				x = rs.getFloat(4)+score;
				if(i==1)//选择题
				{
					num = rs.getInt(5)+1;
				}
				else if(i==2)//填空题
				{
					num = rs.getInt(6)+1;
				}
				else if(i==3)//问答题
				{
					num = rs.getInt(7)+1;
				}
				QAid = rs.getString(1);
			}
			Statement stat1 = conn.createStatement();
			String sql2 = "";
			switch (i)
			{
			case 1:
				sql2 = "update property set choicenum="+String.valueOf(num)+" where QAid="+"\""+QAid+"\"";
				break;
			case 2:
				sql2 = "update property set fillnum="+String.valueOf(num)+" where QAid="+"\""+QAid+"\"";
				break;
			case 3:
				sql2 = "update property set QAnum="+String.valueOf(num)+" where QAid="+"\""+QAid+"\"";
				break;
			}
			stat1.executeUpdate(sql2);
			String sql3 = "update property set totalscore="+String.valueOf(x)+" where QAid="+"\""+QAid+"\"";
			stat.executeUpdate(sql3);
			stat.close();
			stat1.close();
			//conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
