package action;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class wenjuanchengxian 
{
	private String zuozhemingzi;
	private List<String> QAjihe = new ArrayList<String>();
	private List<String> CLJjh = new ArrayList<String>();
	private List<String> QAstate = new ArrayList<String>();
	public String getwenjuan()
	{
		String x="";
		Connection conn = new initialize().getlink("project");
		try{
			String sql = "select * from user where Name="+"\""+this.zuozhemingzi+"\"";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()!=false)
			{
				x= rs.getString(6);
			}
		}
		catch (SQLException e)
		{
			//return "getfailed";
			e.printStackTrace();
		}
		if(x==null)
		{
			return "getfailed";
		}
		String[] h = x.split(" ");
		for(int z=1;z<h.length;z++)
		{
			this.QAjihe.add(h[z]);//添加完成了相应信息
			this.CLJjh.add("http://localhost:8080/DynamicQAProject/huida.action?wenjuanhao="+h[z]);
		}
		return "getsuccess";
	}
	
	public List<String> getQAjihe() {
		return QAjihe;
	}
	public void setQAjihe(List<String> qAjihe) {
		QAjihe = qAjihe;
	}
	public List<String> getCLJjh() {
		return CLJjh;
	}
	public void setCLJjh(List<String> cLJjh) {
		CLJjh = cLJjh;
	}
	public String getZuozhemingzi() {
		return zuozhemingzi;
	}
	public void setZuozhemingzi(String zuozhemingzi) {
		this.zuozhemingzi = zuozhemingzi;
	} 
	/*
	public static void main(String[] args)
	{
		wenjuanchengxian s = new wenjuanchengxian();
		s.zuozhemingzi = "luxin";
		System.out.println(s.getwenjuan());
		
	}
	*/
}
