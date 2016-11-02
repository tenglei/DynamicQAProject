package action;
//这个类用于在问卷中插入选择题
import java.sql.*;

public class insert_choice 
{
	private String QAnum;//问卷号码
	private String question;
	private String Ach;
	private String Bch;
	private String Cch;
	private String Dch;
	private String rightans;
	private String score;
	public static boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	public String insert_cho()
	{
		boolean right = true;
		if(this.question.length()==0||this.Ach.length()==0||this.Bch.length()==0||this.Cch.length()==0||this.Dch.length()==0)
		{
			right = false;
		}
		if(this.rightans.equals("A")==false&&this.rightans.equals("B")==false&&this.rightans.equals("C")==false&&this.rightans.equals("D")==false)
		{
			right = false;
		}
		if(isNum(this.score)==false)
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
			String sql="insert into choice(question,Ach,Bch,Cch,Dch,answer,score) values(?,?,?,?,?,?,?)";
			try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,this.question);
			ps.setString(2,this.Ach);
			ps.setString(3, this.Bch);
			ps.setString(4, this.Cch);//总的分值暂定是0
			ps.setString(5, this.Dch);
			ps.setString(6, this.rightans);
			ps.setFloat(7, Float.parseFloat(this.score));
			ps.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			//更新各项数据
			new tongyong().updatebase(conn, 1, Float.parseFloat(this.score));
			System.out.println("增加成功！");
			return "successinsert";
		}
	}
	
	public void setQAnum(String QAnum)
	{
		this.QAnum = QAnum;
	}
	public void setquestion(String question)
	{
		this.question = question;
	}
	public void setAch(String Ach)
	{
		this.Ach = Ach;
	}
	public void setBch(String Bch)
	{
		this.Bch = Bch;
	}
	public void setCch(String Cch)
	{
		this.Cch = Cch;
	}
	public void setDch(String Dch)
	{
		this.Dch = Dch;
	}
	public void setrightans(String rightans)
	{
		this.rightans = rightans;
	}
	public void setscore(String score)
	{
		this.score = score;
	}
	/*
	public static void main(String[] args)
	{
		insert_choice s = new insert_choice();
		s.setquestion("江主席你看这个董先森连任好不好啊？");
		s.setQAnum("xuefeng1");
		s.setAch("好啊！");
		s.setBch("挺好的！");
		s.setCch("不错！");
		s.setDch("吼啊！");
		s.setrightans("D");
		s.setscore("3");
		System.out.println(s.insert_cho());
	}
	*/
}
