package action;//这个活动用于展示问卷信息

import java.sql.*;
import java.util.*;
public class showtest 
{
	private String wenjuanhao;//获得问卷的依据
	private String author;
	private List<String> choiceques = new ArrayList<String>();
	private List<String> ansA = new ArrayList<String>(); 
	private List<String> ansB = new ArrayList<String>();
	private List<String> ansC = new ArrayList<String>();
	private List<String> ansD = new ArrayList<String>();
	private List<String> choicescore = new ArrayList<String>();
	private List<String> fillques = new ArrayList<String>();
	private List<String> fillscore = new ArrayList<String>();
	private List<String> blanknum = new ArrayList<String>();
	private List<String> ques = new ArrayList<String>();
	private List<String> quesscore = new ArrayList<String>();
	public void test(List<String> a,String b)//用于测试
	{
		Iterator<String> it = a.iterator();
		System.out.println(b);
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
	}
	
	
	
	public String maketest()//生成问卷
	{
		Connection conn = new initialize().getlink(this.wenjuanhao);
		String authorid = "";
		String sql="select * from property";
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()!=false)
			{
				authorid = rs.getString(2);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		Connection conn2 = new initialize().getlink("project");
		String sql2="select * from user where UserID=\""+authorid+"\"";
		try{
			Statement stat2 = conn2.createStatement();
			ResultSet rs2 = stat2.executeQuery(sql2);
			while(rs2.next()!=false)
			{
				this.author = rs2.getString(1);//获得了问卷作者姓名
			}
			stat2.close();
			conn2.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		//先生成选择题
		String sqlx="select * from choice";
		try{
			Statement statx = conn.createStatement();
			ResultSet rsx = statx.executeQuery(sqlx);
			while(rsx.next()!=false)
			{
				this.choiceques.add(rsx.getString(1));
				this.ansA.add(rsx.getString(2));
				this.ansB.add(rsx.getString(3));
				this.ansC.add(rsx.getString(4));
				this.ansD.add(rsx.getString(5));
				this.choicescore.add(rsx.getString(7));
			}
			statx.close();
			rsx.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//再生成填空题
		String sqlt="select * from fill";
		try{
			Statement statt = conn.createStatement();
			ResultSet rst = statt.executeQuery(sqlt);
			while(rst.next()!=false)
			{
				this.fillques.add(rst.getString(2));
				this.fillscore.add(rst.getString(4));
				this.blanknum.add(rst.getString(1));
			}
			statt.close();
			rst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//再生成问答题
		String sqlw="select * from qa";
		try{
			Statement statw = conn.createStatement();
			ResultSet rsw = statw.executeQuery(sqlw);
			while(rsw.next()!=false)
			{
				this.ques.add(rsw.getString(2));
				this.quesscore.add(rsw.getString(4));
			}
			rsw.close();
			statw.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return "successmake";
	}
	
	
	
	
	
	
	public String getWenjuanhao() {
		return wenjuanhao;
	}

	public void setWenjuanhao(String wenjuanhao) {
		this.wenjuanhao = wenjuanhao;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	/*
	public static void main(String[] args)
	{
		showtest s = new showtest();
		s.wenjuanhao = "yaobingkun14";
		s.maketest();
	}
	*/
}
