package action;
//������������ʾ��в���ѡ����
import java.sql.*;

public class insert_QA
{
	private String QAnum;//�ʾ�����
	private String ques1;
	private String desc1;
	private String key1;
	private String score1;
	public static boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	public String insert_wenda()
	{
		System.out.println("11:");
		System.out.println(this.ques1);
		System.out.println("22:");
		System.out.println(this.desc1);
		System.out.println("33:");
		System.out.println(this.key1);
		System.out.println("44:");
		System.out.println(this.score1);
		boolean right = true;
		if(this.ques1.length()==0||this.desc1.length()==0||this.key1.length()==0||this.score1.length()==0)
		{
			return "inputerror";
		}
		if(isNum(this.score1)==false)
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
			String sql="insert into qa(ques1,desc1,key1,score1) values(?,?,?,?)";
			try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,this.ques1);
			ps.setString(2,this.desc1);
			ps.setString(3, this.key1);
			ps.setFloat(4, Float.parseFloat(this.score1));//�ܵķ�ֵ�ݶ���0
			ps.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			//���¸�������
			new tongyong().updatebase(conn, 3, Float.parseFloat(this.score1));
			System.out.println("���ӳɹ���");
			return "successinsert";
		}
	}
	public String getQAnum() {
		return QAnum;
	}
	public void setQAnum(String qAnum) {
		QAnum = qAnum;
	}
	public String getQues1() {
		return ques1;
	}
	public void setQues1(String ques1) {
		this.ques1 = ques1;
	}
	public String getDesc1() {
		return desc1;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getScore1() {
		return score1;
	}
	public void setScore1(String score1) {
		this.score1 = score1;
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