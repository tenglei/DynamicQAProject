package action;

import java.sql.*;//�����������ɾ�����ݿ⣨ɾ���ʾ�
//�������ʾ����ʱ��������ɾ���ʾ�ʱ���ã���������б�Ķ�������Ϊ����������ܻ���ö��
public class delete_base 
{
	private String name;
	private String QAname;
	private String welcomename;
	public String delete()
	{
		this.welcomename = this.name;
		//System.out.println("1:");
		//System.out.println(this.QAname);
		//System.out.println("2:");
		//System.out.println(this.name);
		//System.out.println("3:");
		//System.out.println(this.welcomename);
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
	public String getWelcomename() {
		return welcomename;
	}
	public void setWelcomename(String welcomename) {
		this.welcomename = welcomename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
