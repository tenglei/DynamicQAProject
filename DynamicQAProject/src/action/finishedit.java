package action;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class finishedit 
{
	private String welcomename;
	private String authorname;
	private String name;//ϵͳ���ɵ��ʾ��
	private String editname;
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
	public String back()//�ص���¼���棬���������ʾ����,�������ɵ��ʾ�ż��뵽�û�������,�������ɵ��ʾ�ż��뵽�ʾ����б�͸������͵ķ��б��У������ʾ����𣨴�ѧ�������У�
	{
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
		
		
		
		
		
		String testlink = "http://localhost:8080/DynamicQAProject/huida.action?wenjuanhao="+this.name;                     
		try
		{
			String sql = "update property set testlink="+"\""+testlink+"\""+" where QAid="+"\""+this.name+"\"";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			conn.close();
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
			String sql3 = "update user set wenjuanhao="+"\""+temp+" "+this.name+"\""+" where Name="+"\""+this.authorname+"\"";
			stat3.executeUpdate(sql3);
			stat3.close();
			//conn2.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		/*������µ��ʾ��������ܵ��ʾ����*/
		String sql4="insert into allpaper(paper) values(?)";
		try{
			PreparedStatement ps=conn2.prepareStatement(sql4);
			ps.setString(1,this.name);
			ps.executeUpdate();
			//conn2.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//���뵽�ֹ���ĵ��ʾ����
		String sql7="insert into "+this.wenjuanclass+"(paper) values(?)";
		try{
			PreparedStatement ps2=conn2.prepareStatement(sql7);
			ps2.setString(1,this.name);
			ps2.executeUpdate();
			conn2.close();
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
			conn3.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//��������ɡ����в��ԡ���������ÿ���5���ʾ�������һ�Ρ�
		
		
		
		
		
		
		
		
		
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
	
}
