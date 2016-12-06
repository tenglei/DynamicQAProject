package action;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class seefriends 
{
	private String logininfor;
	private String loginpassword;
	private String hisname;
	
	private List<String> myquestion = new ArrayList<String>();
	private List<String> linklist = new ArrayList<String>();
	private String friends1;
	private String friends2;
	private String friends3;
	private String friends4;
	private List<String> friends = new ArrayList<String>();
	private String guanzhushuliang;
	private String beiguanzhu;
	private List<List<String>> suoyoupaiming = new ArrayList<List<String>>();
	public void addlist(Connection conn,List<List<String>> suoyou)//加入问卷的排名
	{
		List<String> list = new ArrayList<String>();
		String sql = "select * from list";
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()!=false)
			{
				list.add(rs.getString(2));
			}
			suoyou.add(list);
			stmt.close();
			rs.close();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
	}
	public String login_user() 
	{
				
				
				//下面生成用户编辑成的问卷列表
				String x="";
				Connection conn2 = new initialize().getlink("project");
				try{
					String sql = "select * from user where Name="+"\""+this.hisname+"\"";
					Statement stmt2 = conn2.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql);
					
					while(rs2.next()!=false)
					{
						x= rs2.getString(6);
					}
				}
				catch (SQLException e)
				{
					//return "getfailed";
					e.printStackTrace();
				}
				if(x.length()==0)//没有任何问卷
				{
					this.myquestion.add("天啦噜，你还没有问卷，快快添加吧！");
					this.linklist.add(" ");
				}
				else
				{
					String[] h = x.split(" ");
					for(int z=0;z<h.length;z++)
					{
						this.myquestion.add(h[z]);//添加完成了相应信息
						this.linklist.add("http://localhost:8080/DynamicQAProject/huida.action?wenjuanhao="+h[z]);
					}
				}
				//下面生成朋友的列表
				String y = "";
				try{
					String sql = "select * from user where Name="+"\""+this.hisname+"\"";
					Statement stmt2 = conn2.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql);
					while(rs2.next()!=false)
					{
						y= rs2.getString(5);
						this.beiguanzhu = String.valueOf(rs2.getInt(8));
					}
					
					if(y.length()==0)//如果还没有关注的人
					{
						this.friends.add("天啦噜，你还没有关注的其他问者呢！快去添加吧！");
						this.friends1 = "快随便看看，顺便添加其他问者";
						this.guanzhushuliang = "0";
					}
					else
					{
						String[] g = y.split(" ");
						this.guanzhushuliang = String.valueOf(g.length);
						for(int z=0;z<g.length;z++)
						{
							this.friends.add(g[z]);//添加完成了相应信息
						}
						switch(g.length)
						{
						case 1:
							this.friends1 = g[0];
							break;
						case 2:
							this.friends1 = g[0];
							this.friends2 = g[1];
							break;
						case 3:
							this.friends1 = g[0];
							this.friends2 = g[1];
							this.friends3 = g[2];
							break;
						default:
							this.friends1 = g[0];
							this.friends2 = g[1];
							this.friends3 = g[2];
							this.friends4 = g[3];
							break;
						}
					}
					
				}
				catch (SQLException e)
				{
					//return "getfailed";
					e.printStackTrace();
				}
				//下面载入我被关注的数量和我关注的数量
				//下面生成所有问卷的排名
				for(int j=0;j<this.myquestion.size();j++)//对于每个问卷，生成它的排名
				{
					Connection p = new initialize().getlink(this.myquestion.get(j));
					addlist(p,this.suoyoupaiming);
					try {
						p.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				
				
				
				
				

				return "loginsuccess";//匹配，成功
	}

	public static void main(String[] args)
	{
		
		seefriends x = new seefriends();
		x.setlogininfor("yaobingkun");
		x.setloginpassword("qweasd");
		x.setHisname("xsz");
		x.login_user();
		System.out.println(x.getGuanzhushuliang());
		System.out.println(x.getBeiguanzhu());
	}
	
	public String fuzhu()
	{
		return "back";
	}
	public void setlogininfor(String logininfor)
	{
		this.logininfor = logininfor;
	}
	
	public void setloginpassword(String loginpassword)
	{
		this.loginpassword = loginpassword;
	}
	
	public String getloginfor()
	{
		return this.logininfor;
	}
	
	public String getloginpassword()
	{
		return this.loginpassword;
	}
//	public String getWelcomename() {
//		return welcomename;
//	}
//	public void setWelcomename(String welcomename) {
//		this.welcomename = welcomename;
//	}
	public List<String> getMyquestion() {
		return myquestion;
	}
	public void setMyquestion(List<String> myquestion) {
		this.myquestion = myquestion;
	}
	public List<String> getLinklist() {
		return linklist;
	}
	public void setLinklist(List<String> linklist) {
		this.linklist = linklist;
	}
	public String getFriends1() {
		return friends1;
	}
	public void setFriends1(String friends1) {
		this.friends1 = friends1;
	}
	public String getFriends2() {
		return friends2;
	}
	public void setFriends2(String friends2) {
		this.friends2 = friends2;
	}
	public String getHisname() {
		return hisname;
	}
	public void setHisname(String hisname) {
		this.hisname = hisname;
	}
	public String getFriends3() {
		return friends3;
	}
	public void setFriends3(String friends3) {
		this.friends3 = friends3;
	}
	public String getFriends4() {
		return friends4;
	}
	public void setFriends4(String friends4) {
		this.friends4 = friends4;
	}
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	public String getGuanzhushuliang() {
		return guanzhushuliang;
	}
	public void setGuanzhushuliang(String guanzhushuliang) {
		this.guanzhushuliang = guanzhushuliang;
	}
	public String getBeiguanzhu() {
		return beiguanzhu;
	}
	public void setBeiguanzhu(String beiguanzhu) {
		this.beiguanzhu = beiguanzhu;
	}
	public List<List<String>> getSuoyoupaiming() {
		return suoyoupaiming;
	}
	public void setSuoyoupaiming(List<List<String>> suoyoupaiming) {
		this.suoyoupaiming = suoyoupaiming;
	}
}
