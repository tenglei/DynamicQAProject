package action;
//������������ʾ��в���ѡ����
import java.sql.*;

public class insert_QA
{
	private String QAnum;//�ʾ����
	private String question;
	private String answer;
	private String keywords;
	private String score;
	public static boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	public String insert_wenda()
	{
		boolean right = true;
		if(this.question.length()==0||this.answer.length()==0||this.keywords.length()==0||this.score.length()==0)
		{
			return "inputerror";
		}
		if(isNum(this.score)==false)
		{
			return "inputerror";
		}
		if(right==false)
		{
			return "inputerror";
		}
		else//���濪ʼ����
		{
			Connection conn = new initialize().getlink(this.QAnum);
			String sql="insert into qa(question,answer,keywords,score) values(?,?,?,?)";
			try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,this.question);
			ps.setString(2,this.answer);
			ps.setString(3, this.keywords);
			ps.setFloat(4, Float.parseFloat(this.score));//�ܵķ�ֵ�ݶ���0
			ps.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			//���¸�������
			new tongyong().updatebase(conn, 3, Float.parseFloat(this.score));
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
	public void setanswer(String answer)
	{
		this.answer = answer;
	}
	public void setkeywords(String keywords)
	{
		this.keywords = keywords;
	}
	public void setscore(String score)
	{
		this.score = score;
	}
	/*
	public static void main(String[] args)
	{
		insert_QA s = new insert_QA();
		s.setquestion("������ǵ��������ǰ��������ô���أ�");
		s.setQAnum("xuefeng1");
		s.setanswer("�ѵ�������۵����Ĵ�ͽ�ܹ��赲���˵���");
		s.setkeywords("�۵��� ��ͽ �赲");
		s.setscore("3");
		System.out.println(s.insert_wenda());
	}
	*/
}
