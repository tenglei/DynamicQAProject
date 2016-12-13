package action;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class finishedit 
{
	private List<String>listTmp= new ArrayList<String>();
	private String welcomename;
	private String authorname;
	private String name;//ϵͳ���ɵ��ʾ��
	private String editname;
	private String lianjie;
	private String wenjuanclass;//�ʾ�����
	private String wenjuanname;//�����Զ�����ʾ�����֣��������ڲ���
	private List<String> choiceques = new ArrayList<String>();
	private List<String> ansA = new ArrayList<String>(); 
	private List<String> ansB = new ArrayList<String>();
	private List<String> ansC = new ArrayList<String>();
	private List<String> ansD = new ArrayList<String>();
	private List<String> choicescore = new ArrayList<String>();
	private List<String> choiceans = new ArrayList<String>();
	private List<String> fillques = new ArrayList<String>();
	private List<String> fillscore = new ArrayList<String>();
	private List<String> blanknum = new ArrayList<String>();
	private List<String> fillans = new ArrayList<String>();
	private List<String> ques = new ArrayList<String>();
	private List<String> quesans = new ArrayList<String>();
	private List<String> queskey = new ArrayList<String>();
	private List<String> quesscore = new ArrayList<String>(); 
	public int getNum(Connection conn,String name)//�õ�����
	{
		int num = 0;
		String sql = "select count(*) from "+name;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				num = Integer.parseInt(rs.getString(1));
			}
		}
		catch (Exception e) { 
				e.printStackTrace(); 
			} 
		
		return num;
	}
	
	public void see(List<String> list)
	{
		for(int x=0;x<list.size();x++)
		{
			System.out.println(list.get(x));
		}
	}
	
	public void deletetable(Connection conn,String tablename)
	{
		try{
			Statement st = conn.createStatement();
			String sql = "delete from "+tablename; 
			st.executeUpdate(sql);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	public void insertques(Connection conn,String insertablename,String oritablename,int rank)//rank �ǵ�rank+1����¼��
	{
		String sql="insert into gongyou."+insertablename+" select * from project."+oritablename+" limit "+String.valueOf(rank)+",1";
		try{
    		PreparedStatement ps=conn.prepareStatement(sql);
    		ps.executeUpdate();
    	}
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void chuli(List<String> list)
	{
		String a = list.get(0);
		String[] b = a.split(",");
		list.clear();
		for(int x=0;x<b.length;x++)
		{
			list.add(b[x]);
		}
	}
	public void inserttixing(int min,int max,int n,Connection conn,String insertablename,String oritablename)//����ĳ������
	{
		 int[] result = new int[n];  
		    int count = 0;  
		    while(count < n) {  
		        int num = (int) (Math.random() * (max - min)) + min;  
		        boolean flag = true;  
		        for (int j = 0; j < n; j++) {  
		            if(num == result[j]){  
		                flag = false;  
		                break;  
		            }  
		        }  
		        if(flag){  
		        	//System.out.println(num);
		        	insertques(conn,insertablename,oritablename,num);
		            result[count] = num;  
		            count++;  
		        }  
		    }  
		
		
	}
	
	public String back()//�ص���¼���棬���������ʾ����,�������ɵ��ʾ�ż��뵽�û�������,�������ɵ��ʾ�ż��뵽�ʾ����б�͸������͵ķ��б��У������ʾ����𣨴�ѧ�������У�
	{
		chuli(this.ansA);
		chuli(this.ansB);
		chuli(this.ansC);
		chuli(this.ansD);
		chuli(this.blanknum);
		
		chuli(this.choiceans);
		chuli(this.choiceques);
		chuli(this.choicescore);
		chuli(this.fillans);
		chuli(this.fillques);
		
		chuli(this.fillscore);
		chuli(this.ques);
		chuli(this.quesans);
		chuli(this.queskey);
		chuli(this.quesscore);
		this.welcomename = this.authorname;//���ڻ�ȥ��
		this.name = this.editname;//�ʾ��
		//�Ȱ��ʾ�ŵ����ݿ��С�
		Connection conn = new initialize().getlink(name);
		Connection conn4 = new initialize().getlink("project"); 
		//�Ȳ���ѡ���⣬ͬʱ��ѡ���������ѡ���������
		for(int q = 0;q<this.choiceques.size();q++)//����û��ѡ����
		{
			String sql="insert into choice(question,Ach,Bch,Cch,Dch,answer,score) values(?,?,?,?,?,?,?)";
			try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,this.choiceques.get(q));
			ps.setString(2,this.ansA.get(q));
			ps.setString(3, this.ansB.get(q));
			ps.setString(4, this.ansC.get(q));//�ܵķ�ֵ�ݶ���0
			ps.setString(5, this.ansD.get(q));
			ps.setString(6, this.choiceans.get(q));
			ps.setFloat(7, Float.parseFloat(this.choicescore.get(q)));
			ps.executeUpdate();
			new tongyong().updatebase(conn, 1, Float.parseFloat(this.choicescore.get(q)));
			//��ѡ������뵽�������
			String sql2="insert into allchoice(question,Ach,Bch,Cch,Dch,answer,score) values(?,?,?,?,?,?,?)";
			try{
				PreparedStatement ps2=conn4.prepareStatement(sql2);
				ps2.setString(1,this.choiceques.get(q));
				ps2.setString(2,this.ansA.get(q));
				ps2.setString(3, this.ansB.get(q));
				ps2.setString(4, this.ansC.get(q));//�ܵķ�ֵ�ݶ���0
				ps2.setString(5, this.ansD.get(q));
				ps2.setString(6, this.choiceans.get(q));
				ps2.setFloat(7, Float.parseFloat(this.choicescore.get(q)));
				ps2.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			//
			System.out.println("���ӳɹ���");
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		//�ٲ�������⣬ͬʱ���������뵽�ܵ������
		for(int q = 0;q<this.fillques.size();q++)//����û��ѡ����
		{
			String sql="insert into fill(blanknum,question,answer,score) values(?,?,?,?)";
			try{
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1,Integer.parseInt(this.blanknum.get(q)));
				ps.setString(2,this.fillques.get(q));
				ps.setString(3, this.fillans.get(q));
				ps.setFloat(4, Float.parseFloat(this.fillscore.get(q)));
				ps.executeUpdate();
				new tongyong().updatebase(conn, 2, Float.parseFloat(this.fillscore.get(q)));
				System.out.println("���ӳɹ���");
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			String sql2="insert into allfill(blanknum,question,answer,score) values(?,?,?,?)";
			try{
				PreparedStatement ps2=conn4.prepareStatement(sql2);
				ps2.setInt(1,Integer.parseInt(this.blanknum.get(q)));
				ps2.setString(2,this.fillques.get(q));
				ps2.setString(3, this.fillans.get(q));
				ps2.setFloat(4, Float.parseFloat(this.fillscore.get(q)));
				ps2.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		//�ٲ����ʴ��⣬���ʴ�����뵽�ܵ������
		for(int q=0;q<this.ques.size();q++)
		{
			String sql="insert into qa(question,answer,keywords,score) values(?,?,?,?)";
			try{
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,this.ques.get(q));
				ps.setString(2,this.quesans.get(q));
				ps.setString(3, this.queskey.get(q));
				ps.setFloat(4, Float.parseFloat(this.quesscore.get(q)));//�ܵķ�ֵ�ݶ���0
				ps.executeUpdate();
				new tongyong().updatebase(conn, 3, Float.parseFloat(this.quesscore.get(q)));
				System.out.println("���ӳɹ���");
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			String sql2="insert into allqa(question,answer,keywords,score) values(?,?,?,?)";
			try{
				PreparedStatement ps2=conn4.prepareStatement(sql2);
				ps2.setString(1,this.ques.get(q));
				ps2.setString(2,this.quesans.get(q));
				ps2.setString(3, this.queskey.get(q));
				ps2.setFloat(4, Float.parseFloat(this.quesscore.get(q)));//�ܵķ�ֵ�ݶ���0
				ps2.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		//�ٸ��¸������
		
//		System.out.println(name);
//		System.out.println(welcomename);
		InetAddress ia = null;
		String localname = "";
		try {
			ia = InetAddress.getLocalHost();
			localname=ia.getHostAddress().toString();
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
		String testlink = "http://"+localname+":8080/DynamicQAProject/huida.action?wenjuanhao="+this.name;                     
		try
		{
			String sql = "update property set testlink="+"\""+testlink+"\""+" where QAid="+"\""+this.name+"\"";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//���ʾ�����߹ҿ�
		Connection conn2 = new initialize().getlink("project");
		String temp = "";
		try
		{
			String sql2 = "select * from user where Name="+"\""+this.authorname+"\"";
			Statement stat2 = conn2.createStatement();
			ResultSet rs2 = stat2.executeQuery(sql2);
			while(rs2.next()!=false)
			{
				temp = rs2.getString(6);
			}
			rs2.close();
			stat2.close();
			Statement stat3 = conn2.createStatement();
			String sql3 = "";
			if(temp.length()!=0)
			{
				sql3 = "update user set wenjuanhao="+"\""+temp+" "+this.name+"\""+" where Name="+"\""+this.authorname+"\"";
			}
			else
			{
				sql3 = "update user set wenjuanhao="+"\""+temp+this.name+"\""+" where Name="+"\""+this.authorname+"\"";
			}
			stat3.executeUpdate(sql3);
			stat3.close();
			//conn2.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		/*������µ��ʾ��������ܵ��ʾ����*/
		String sql4="insert into allpaper(paper,num) values(?,?)";
		try{
			PreparedStatement ps=conn2.prepareStatement(sql4);
			ps.setString(1,this.name);
			ps.setInt(2, 0);
			ps.executeUpdate();
			//conn2.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//���뵽�ֹ���ĵ��ʾ����
		String sql7="insert into "+this.wenjuanclass+"(paper,num) values(?,?)";
		try{
			PreparedStatement ps2=conn2.prepareStatement(sql7);
			ps2.setString(1,this.name);
			ps2.setInt(2, 0);
			ps2.executeUpdate();
			//conn2.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//������ʾ�����ͼ��뵽�ʾ�������
		Connection conn3 = new initialize().getlink(this.name);
		try
		{
			Statement stat4 = conn3.createStatement();
			String sql5 = "update property set classname="+"\""+this.wenjuanclass+"\""+" where QAid="+"\""+this.name+"\"";
			stat4.executeUpdate(sql5);
			Statement stat5 = conn3.createStatement();
			String sql6 = "update property set papername="+"\""+this.wenjuanname+"\""+" where QAid="+"\""+this.name+"\"";
			stat5.executeUpdate(sql6);
			stat4.close();
			stat5.close();
			//conn3.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//��������ɡ����в��ԡ���������ÿ���5���ʾ�������һ�Ρ�
		///Connection conn4 = new initialize().getlink("project");
		if(getNum(conn4,"allpaper") % 5==0)//�����ʱ�ʾ�������5�ı���
		{
			if(getNum(conn4,"allchoice")>=10&&getNum(conn4,"allfill")>=10&&getNum(conn4,"allqa")>=5)//�����Ŀ��������Ҫ��
			{
				Connection conn5 = new initialize().getlink("gongyou");
				try{
					Statement stat7 = conn5.createStatement();
					String sql8 = "update property set state=1 where QAid=\"gongyou\"";
					stat7.executeUpdate(sql8);
					stat7.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				deletetable(conn5,"choice");
				deletetable(conn5,"fill");
				deletetable(conn5,"qa");
				//���濪ʼ�����Ŀ
				int choicenum = getNum(conn4,"allchoice")-1;
				int fillnum = getNum(conn4,"allfill")-1;
				int qanum = getNum(conn4,"allqa")-1;
				inserttixing(0,choicenum,5,conn5,"choice","allchoice");
				inserttixing(0,fillnum,5,conn5,"fill","allfill");
				inserttixing(0,qanum,2,conn5,"qa","allqa");
				try{
					conn4.close();
					conn5.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
		//����������еĶ���
//		System.out.println("safvdsfgdrt:");
//		System.out.println(this.authorname);
//		System.out.println(this.editname);
//		System.out.println(this.wenjuanclass);
//		System.out.println(this.wenjuanname);
//		see(this.ansA);
//		see(this.ansB);
//		see(this.ansC);
//		see(this.ansD);
//		see(this.blanknum);
//		see(this.choiceans);
//		see(this.choiceques);
//		see(this.choicescore);
//		see(this.fillans);
//		see(this.fillques);
//		see(this.fillscore);
//		see(this.ques);
//		see(this.quesans);
//		see(this.queskey);
//		see(this.quesscore);
		
		//��������ʾ���Ŀ˳��
		Connection conn10 = new initialize().getlink(this.name);
		try
		{
			Statement stat10 = conn10.createStatement();
			String sql10 = "update property set tixing="+"\""+this.listTmp.get(0)+"\""+" where QAid="+"\""+this.name+"\"";
			stat10.executeUpdate(sql10);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		this.lianjie = "http://"+localname+":8080/DynamicQAProject/huida.action?wenjuanhao=" + this.editname;
		return "successback";
	}
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	public String getEditname() {
		return editname;
	}
	public void setEditname(String editname) {
		this.editname = editname;
	}
	public String getWelcomename() {
		return welcomename;
	}
	public void setWelcomename(String welcomename) {
		this.welcomename = welcomename;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getWenjuanclass() {
		return wenjuanclass;
	}
	public void setWenjuanclass(String wenjuanclass) {
		this.wenjuanclass = wenjuanclass;
	}
	public String getWenjuanname() {
		return wenjuanname;
	}
	public void setWenjuanname(String wenjuanname) {
		this.wenjuanname = wenjuanname;
	}
	public List<String> getChoiceques() {
		return choiceques;
	}
	public void setChoiceques(List<String> choiceques) {
		this.choiceques = choiceques;
	}
	public List<String> getAnsA() {
		return ansA;
	}
	public void setAnsA(List<String> ansA) {
		this.ansA = ansA;
	}
	public List<String> getAnsB() {
		return ansB;
	}
	public void setAnsB(List<String> ansB) {
		this.ansB = ansB;
	}
	public List<String> getAnsC() {
		return ansC;
	}
	public void setAnsC(List<String> ansC) {
		this.ansC = ansC;
	}
	public List<String> getAnsD() {
		return ansD;
	}
	public void setAnsD(List<String> ansD) {
		this.ansD = ansD;
	}
	public List<String> getChoicescore() {
		return choicescore;
	}
	public void setChoicescore(List<String> choicescore) {
		this.choicescore = choicescore;
	}
	public List<String> getFillques() {
		return fillques;
	}
	public void setFillques(List<String> fillques) {
		this.fillques = fillques;
	}
	public List<String> getFillscore() {
		return fillscore;
	}
	public void setFillscore(List<String> fillscore) {
		this.fillscore = fillscore;
	}
	public List<String> getBlanknum() {
		return blanknum;
	}
	public void setBlanknum(List<String> blanknum) {
		this.blanknum = blanknum;
	}
	public List<String> getQues() {
		return ques;
	}
	public void setQues(List<String> ques) {
		this.ques = ques;
	}
	public List<String> getQuesscore() {
		return quesscore;
	}
	public void setQuesscore(List<String> quesscore) {
		this.quesscore = quesscore;
	}
	public List<String> getChoiceans() {
		return choiceans;
	}
	public void setChoiceans(List<String> choiceans) {
		this.choiceans = choiceans;
	}
	public List<String> getFillans() {
		return fillans;
	}
	public void setFillans(List<String> fillans) {
		this.fillans = fillans;
	}
	public List<String> getQuesans() {
		return quesans;
	}
	public void setQuesans(List<String> quesans) {
		this.quesans = quesans;
	}
	public List<String> getQueskey() {
		return queskey;
	}
	public void setQueskey(List<String> queskey) {
		this.queskey = queskey;
	}
	/*
	public static void main(String[] args)
	{
		 List<String> choiceques = new ArrayList<String>();
		 List<String> ansA = new ArrayList<String>(); 
		 List<String> ansB = new ArrayList<String>();
		 List<String> ansC = new ArrayList<String>();
		 List<String> ansD = new ArrayList<String>();
		 List<String> choicescore = new ArrayList<String>();
		  List<String> choiceans = new ArrayList<String>();
		  List<String> fillques = new ArrayList<String>();
		  List<String> fillscore = new ArrayList<String>();
		  List<String> blanknum = new ArrayList<String>();
		  List<String> fillans = new ArrayList<String>();
		  List<String> ques = new ArrayList<String>();
		  List<String> quesans = new ArrayList<String>();
		  List<String> queskey = new ArrayList<String>();
		  List<String> quesscore = new ArrayList<String>(); 
		  choiceques.add("iiiii");
		  choiceques.add("jjjjj");
		  ansA.add("asa");
		  ansA.add("ppap");
		  ansB.add("bsb");
		  ansB.add("bsb");
		  ansC.add("bsb");
		  ansC.add("bsb");
		  ansD.add("bsb");
		  ansD.add("bsb");
		  choicescore.add("12");
		  choicescore.add("6");
		  choiceans.add("A");
		  choiceans.add("B");
		  fillques.add("asaas");
		  fillques.add("adad");
		  fillscore.add("13");
		  fillscore.add("14");
		  blanknum.add("2");
		  blanknum.add("3");
		  fillans.add("asa assa");
		  fillans.add("asasa ad adsd");
		  ques.add("asaasas");
		  ques.add("cccc");
		  quesans.add("asasas");
		  quesans.add("asas");
		  queskey.add("asas");
		  queskey.add("sadasfsasa");
		  quesscore.add("3");
		  quesscore.add("4");
		finishedit x= new finishedit();
		x.setAuthorname("xsz");
		x.setEditname("xsz8");
		x.setWenjuanclass("life");
		x.setWenjuanname("shit8");
		x.setAnsA(ansA);
		x.setAnsB(ansB);
		x.setAnsC(ansC);
		x.setAnsD(ansD);
		x.setBlanknum(blanknum);
		x.setChoiceans(choiceans);
		x.setChoiceques(choiceques);
		x.setChoicescore(choicescore);
		x.setFillans(fillans);
		x.setFillques(fillques);
		x.setFillscore(fillscore);
		x.setQues(quesscore);
		x.setQuesans(quesans);
		x.setQueskey(queskey);
		x.setQuesscore(quesscore);
		x.back();
		System.out.println("wancheng!");
	}
	*/
	public List<String> getListTmp() {
		return listTmp;
	}
	public void setListTmp(List<String> listTmp) {
		this.listTmp = listTmp;
	}

	public String getLianjie() {
		return lianjie;
	}

	public void setLianjie(String lianjie) {
		this.lianjie = lianjie;
	}
	
	
}
