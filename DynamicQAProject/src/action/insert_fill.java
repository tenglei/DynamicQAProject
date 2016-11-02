package action;

import java.sql.*;

public class insert_fill 
{
	private String QAnum;
	private String fillnum;
	private String question;
	private String answer;
	private String score;
	public static boolean isfloat(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	public static boolean isNum(String str){
		return str.matches("[0-9]+");
	}
	public String insert_fi()
	{
		boolean right = true;
		if(isfloat(this.score)==false||isNum(this.fillnum)==false)
		{
			return "inputerror";
		}
		if(this.question.length()!=0)
		{
			int p = 0;
			String[] sarray = this.answer.split(" ");
			p = sarray.length;
			if(Integer.parseInt(this.fillnum)!=p)
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
			Connection conn = new initialize().getlink(this.QAnum);
			String sql="insert into fill(blanknum,question,answer,score) values(?,?,?,?)";
			try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(this.fillnum));
			ps.setString(2,this.question);
			ps.setString(3, this.answer);
			ps.setFloat(4, Float.parseFloat(this.score));
			ps.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			new tongyong().updatebase(conn, 2, Float.parseFloat(this.score));
			System.out.println("增加成功！");
			return "successinsert";
		}
	}
	
	public void setQAnum(String QAnum)
	{
		this.QAnum = QAnum;
	}
	public void setfillnum(String fillnum)
	{
		this.fillnum = fillnum;
	}
	public void setquestion(String question)
	{
		this.question = question;
	}
	public void setanswer(String answer)
	{
		this.answer = answer;
	}
	public void setscore(String score)
	{
		this.score = score;
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
