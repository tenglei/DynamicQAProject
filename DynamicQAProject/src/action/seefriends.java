package action;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class seefriends
{
	private String myname;//�����Լ�������
	private String logininfor;//��������Ҫ�����˵�����
	private String welcomename;
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
	private List<String> gongyoupaiming = new ArrayList<String>();
	private String isempty;
	public void addlist(Connection conn,List<List<String>> suoyou)//�����ʾ������
	{
		this.isempty = "1";
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
		//String truepassword = "";
//		if(this.getLogininfor().length()!=0 && this.getLoginpassword().length()!=0)//ȫ���ǿգ���ʼ�ж�
//		{
			//Connection a1 = new initialize().getlink("project");//���ú������г�ʼ��
//			boolean isfound = false;
//			String sql1 = "select * from user where Name=\""+this.getLogininfor()+"\"";//�Ȱ�����������
//			try
//			{
//				Statement stmt1 = a1.createStatement();
//				ResultSet rs1 = stmt1.executeQuery(sql1);
//				while(rs1.next()!=false)
//				{
//					isfound = true;//�ҵ���
//					truepassword = rs1.getString(2);
//					//System.out.println(truepassword);
//					break;
//				}
//			}
//			catch (SQLException e1)
//			{
//				e1.printStackTrace();
//			}
//			if(isfound == false)//��δ�ҵ�,�ٰ���������һ��
//			{
//				String sql2 = "select * from user where Email=\""+this.getLogininfor()+"\"";
//				try
//				{
//					Statement stmt2 = a1.createStatement();
//					ResultSet rs2 = stmt2.executeQuery(sql2);
//					while(rs2.next()!=false)
//					{
//						isfound = true;//�ҵ���
//						truepassword = rs2.getString(2);
//						break;
//					}
//				}
//				catch (SQLException e1)
//				{
//					e1.printStackTrace();
//				}
//			}
//			if(isfound == false)//���û�ҵ�
//			{
//				return "loginfailed";//û���ҵ���ʧ��
//			}
//			else if(this.getLoginpassword().equals(truepassword)==true)//
//			{				
				this.welcomename = this.getLogininfor();
				//���������û��༭�ɵ��ʾ��б�
				String x="";
				Connection conn2 = new initialize().getlink("project");
				try{
					String sql = "select * from user where Name="+"\""+this.welcomename+"\"";
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
				if(x.length()==0)//û���κ��ʾ�
				{
					this.isempty = "0";
					this.myquestion.add("�����࣬�㻹û���ʾ������Ӱɣ�");
					this.linklist.add(" ");
				}
				else
				{
					InetAddress ia = null;
					String localname = "";
					try {
						ia = InetAddress.getLocalHost();
						localname=ia.getHostAddress().toString();
					} catch (UnknownHostException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String[] h = x.split(" ");
					for(int z=0;z<h.length;z++)
					{
						this.myquestion.add(h[z]);//����������Ӧ��Ϣ
						this.linklist.add("http://"+localname+":8080/DynamicQAProject/huida.action?wenjuanhao="+h[z]);
					}
				}
				//�����������ѵ��б�
				String y = "";
				try{
					String sql = "select * from user where Name="+"\""+this.welcomename+"\"";
					Statement stmt2 = conn2.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql);
					while(rs2.next()!=false)
					{
						y= rs2.getString(5);
						this.beiguanzhu = String.valueOf(rs2.getInt(8));
					}
					
					if(y.length()==0)//�����û�й�ע����
					{
						this.friends.add("�����࣬�㻹û�й�ע�����������أ���ȥ��Ӱɣ�");
						this.friends1 = "����㿴����˳�������������";
						this.guanzhushuliang = "0";
					}
					else
					{
						String[] g = y.split(" ");
						this.guanzhushuliang = String.valueOf(g.length);
						for(int z=0;z<g.length;z++)
						{
							this.friends.add(g[z]);//����������Ӧ��Ϣ
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
				//���������ұ���ע���������ҹ�ע������
				//�������������ʾ������
				if(x.length()!=0)
				{
					for(int j=0;j<this.myquestion.size();j++)//����ÿ���ʾ�������������
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
				}
				
				
				
				
				Connection b1 = new initialize().getlink("gongyou");//���ú������г�ʼ��
				String sql10 = "select * from list";//�Ȱ�����������
				try
				{
					Statement stmt10 = b1.createStatement();
					ResultSet rs10 = stmt10.executeQuery(sql10);
					while(rs10.next()!=false)
					{
						this.gongyoupaiming.add(rs10.getString(2));
					}
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				
				
				
				
				
				
				return "loginsuccess";//ƥ�䣬�ɹ�
//				for(int y1 =0;y1<this.suoyoupaiming.size();y1++)
//				{
//					for(int h=0;h<this.suoyoupaiming.get(y1).size();h++)
//					{
//						System.out.println(this.suoyoupaiming.get(y1).get(h));
//					}
//				}
				
				
				
				
				
				
				
//			}
//			else
//			{
//				return "loginfailed";//�û������벻ƥ�䣬ʧ��
//			}
//		}
//		else
//		{
//			return "loginfailed";//����Ϣû�����룬ʧ��
//		}
	}
	/*
	public static void main(String[] args)
	{
		
		login x = new login();
		x.logininfor = "yaobingkun";
		x.loginpassword = "qweasd";
		x.login_user();
		System.out.println(x.getGuanzhushuliang());
		System.out.println(x.getBeiguanzhu());
	}
	*/
	public String fuzhu()
	{
		return "back";
	}
	public void setlogininfor(String logininfor)
	{
		this.setLogininfor(logininfor);
	}
//	
//	public void setloginpassword(String loginpassword)
//	{
//		this.setLoginpassword(loginpassword);
//	}
	
	public String getloginfor()
	{
		return this.getLogininfor();
	}
	
//	public String getloginpassword()
//	{
//		return this.getLoginpassword();
//	}
	public String getWelcomename() {
		return welcomename;
	}
	public void setWelcomename(String welcomename) {
		this.welcomename = welcomename;
	}
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
	public String getLogininfor() {
		return logininfor;
	}
	public void setLogininfor(String logininfor) {
		this.logininfor = logininfor;
	}
//	public String getLoginpassword() {
//		return loginpassword;
//	}
//	public void setLoginpassword(String loginpassword) {
//		this.loginpassword = loginpassword;
//	}
	public List<String> getGongyoupaiming() {
		return gongyoupaiming;
	}
	public void setGongyoupaiming(List<String> gongyoupaiming) {
		this.gongyoupaiming = gongyoupaiming;
	}
	public String getIsempty() {
		return isempty;
	}
	public void setIsempty(String isempty) {
		this.isempty = isempty;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
}
