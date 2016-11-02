package action;

//这里定义了一些通用的函数
import java.sql.*;

public class tongyong 
{
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
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
