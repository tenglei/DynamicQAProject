package action;

import java.sql.*;//�����������ɾ�����ݿ⣨ɾ���ʾ�
//����ɾ���ʾ�ʱ����
public class delete_base 
{
	
	private String QAname;
	
	public String delete()
	{
		
		System.out.println(this.QAname);
		Connection conn = new initialize().getlink("project");
		try
		{
			Statement stat = conn.createStatement();
			String sql = "drop database "+this.QAname;
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
	public void setQAname(String QAname)
	{
		this.QAname = QAname;
	}
	
}
