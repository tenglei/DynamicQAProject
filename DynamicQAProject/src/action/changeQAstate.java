package action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//改变问卷的状态
public class changeQAstate {
	private String QAname;
	
	public String changestate()
	{
		Connection conn = new initialize().getlink(this.QAname);
		try{
			String sql = "select * from property where QAid="+"\""+this.QAname+"\"";
			Statement stmt = conn.createStatement();
			Statement stat = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int x = 0;
			while(rs.next()!=false)
			{
				x= rs.getInt(11);
			}
			if(x==0)//如果原来是关闭的
			{
				String sql2 = "update property set state=1"+" where QAid="+"\""+this.QAname+"\"";
				stat.executeUpdate(sql2);//把所有的名次都更新一遍
			}
			else if(x==1)
			{
				String sql2 = "update property set state=0"+" where QAid="+"\""+this.QAname+"\"";
				stat.executeUpdate(sql2);//把所有的名次都更新一遍
			}
		}
		catch (SQLException e)
		{
			//return "getfailed";
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		return "changesuccess";
	}
	
	
	
	
	
	public String getQAname() {
		return QAname;
	}

	public void setQAname(String qAname) {
		QAname = qAname;
	}
	
}
