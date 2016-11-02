package action;
//������������ʾ��в���ѡ����
import java.sql.*;

public class insert_choice 
{
	private String QAnum;//�ʾ����
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
		else//���濪ʼ����
		{
			Connection conn = new initialize().getlink(this.QAnum);
			String sql="insert into choice(question,Ach,Bch,Cch,Dch,answer,score) values(?,?,?,?,?,?,?)";
			try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,this.question);
			ps.setString(2,this.Ach);
			ps.setString(3, this.Bch);
			ps.setString(4, this.Cch);//�ܵķ�ֵ�ݶ���0
			ps.setString(5, this.Dch);
			ps.setString(6, this.rightans);
			ps.setFloat(7, Float.parseFloat(this.score));
			ps.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			//���¸�������
			new tongyong().updatebase(conn, 1, Float.parseFloat(this.score));
			System.out.println("���ӳɹ���");
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
		s.setquestion("����ϯ�㿴�������ɭ���κò��ð���");
		s.setQAnum("xuefeng1");
		s.setAch("�ð���");
		s.setBch("ͦ�õģ�");
		s.setCch("����");
		s.setDch("�𰡣�");
		s.setrightans("D");
		s.setscore("3");
		System.out.println(s.insert_cho());
	}
	*/
}
