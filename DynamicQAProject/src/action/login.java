package action;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class login 
{
	private String logininfor;
	private String loginpassword;
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
	
	public String login_user() 
	{
		String truepassword = "";
		if(this.logininfor.length()!=0 && this.loginpassword.length()!=0)//ȫ���ǿգ���ʼ�ж�
		{
			Connection a1 = new initialize().getlink("project");//���ú������г�ʼ��
			boolean isfound = false;
			String sql1 = "select * from user where Name=\""+this.logininfor+"\"";//�Ȱ�����������
			try
			{
				Statement stmt1 = a1.createStatement();
				ResultSet rs1 = stmt1.executeQuery(sql1);
				while(rs1.next()!=false)
				{
					isfound = true;//�ҵ���
					truepassword = rs1.getString(2);
					//System.out.println(truepassword);
					break;
				}
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			if(isfound == false)//��δ�ҵ�,�ٰ���������һ��
			{
				String sql2 = "select * from user where Email=\""+this.logininfor+"\"";
				try
				{
					Statement stmt2 = a1.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					while(rs2.next()!=false)
					{
						isfound = true;//�ҵ���
						truepassword = rs2.getString(2);
						break;
					}
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			if(isfound == false)//���û�ҵ�
			{
				return "loginfailed";//û���ҵ���ʧ��
			}
			else if(this.loginpassword.equals(truepassword)==true)//
			{				
				this.welcomename = this.logininfor;
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
					this.myquestion.add("�����࣬�㻹û���ʾ������Ӱɣ�");
					this.linklist.add(" ");
				}
				else
				{
					String[] h = x.split(" ");
					for(int z=0;z<h.length;z++)
					{
						this.myquestion.add(h[z]);//����������Ӧ��Ϣ
						this.linklist.add("http://localhost:8080/DynamicQAProject/huida.action?wenjuanhao="+h[z]);
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
				
				
				
				
				
				
				return "loginsuccess";//ƥ�䣬�ɹ�
			}
			else
			{
				return "loginfailed";//�û������벻ƥ�䣬ʧ��
			}
		}
		else
		{
			return "loginfailed";//����Ϣû�����룬ʧ��
		}
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
}
