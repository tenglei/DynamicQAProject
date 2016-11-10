package action;

import java.sql.*;

public class insert_fill 
{
	private String QAnum1;
	private String xxx;
	private String fillnum1;
	private String ques1;
	private String answer1;
	private String score1;
	private String basename;
	private String yyy;
	private String authorname;
	public static boolean isfloat(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	public static boolean isNum(String str){
		return str.matches("[0-9]+");
	}
	public String insert_fi()
	{
		this.authorname = this.yyy;
		this.QAnum1=this.xxx;
		this.basename = this.QAnum1;
		System.out.println(fillnum1);
		System.out.println(ques1);
		System.out.println(answer1);
		System.out.println(fillnum1);
		boolean right = true;
		if(isfloat(this.score1)==false||isNum(this.fillnum1)==false)
		{
			return "inputerror";
		}
		if(this.ques1.length()!=0)
		{
			int p = 0;
			String[] sarray = this.answer1.split(" ");
			p = sarray.length;
			if(Integer.parseInt(this.fillnum1)!=p)
			{
				return "inputerror";
			}
		}
		else
		{
			right = false;
		}
		if(right==false)
		{
			return "inputerror";
		}
		else//下面开始插入
		{
			Connection conn = new initialize().getlink(this.QAnum1);
			String sql="insert into fill(blanknum,question,answer,score) values(?,?,?,?)";
			try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(this.fillnum1));
			ps.setString(2,this.ques1);
			ps.setString(3, this.answer1);
			ps.setFloat(4, Float.parseFloat(this.score1));
			ps.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			new tongyong().updatebase(conn, 2, Float.parseFloat(this.score1));
			System.out.println("增加成功！");
			return "successinsert";
		}
	}
	public String getQAnum1() {
		return QAnum1;
	}
	public void setQAnum1(String qAnum1) {
		QAnum1 = qAnum1;
	}
	public String getXxx() {
		return xxx;
	}
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
	public String getFillnum1() {
		return fillnum1;
	}
	public void setFillnum1(String fillnum1) {
		this.fillnum1 = fillnum1;
	}
	public String getQues1() {
		return ques1;
	}
	public void setQues1(String ques1) {
		this.ques1 = ques1;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getScore1() {
		return score1;
	}
	public void setScore1(String score1) {
		this.score1 = score1;
	}
	public String getBasename() {
		return basename;
	}
	public void setBasename(String basename) {
		this.basename = basename;
	}
	public String getYyy() {
		return yyy;
	}
	public void setYyy(String yyy) {
		this.yyy = yyy;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	
	
	/*
	public static void main(String[] args)
	{
		insert_fill s = new insert_fill();
		s.setQAnum("xuefeng1");
		s.setfillnum("5");
		s.setquestion("姚秉坤身高__,体重__,三围__,__,__。");
		s.setanswer("175 62 80 80 80");
		s.setscore("5.0");
		System.out.println(s.insert_fi());
	}
	*/
}
