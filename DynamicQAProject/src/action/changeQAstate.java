package action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//�ı��ʾ��״̬
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
			if(x==0)//���ԭ���ǹرյ�
			{
				String sql2 = "update property set state=1"+" where QAid="+"\""+this.QAname+"\"";
				stat.executeUpdate(sql2);//�����е����ζ�����һ��
			}
			else if(x==1)
			{
				String sql2 = "update property set state=0"+" where QAid="+"\""+this.QAname+"\"";
				stat.executeUpdate(sql2);//�����е����ζ�����һ��
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
