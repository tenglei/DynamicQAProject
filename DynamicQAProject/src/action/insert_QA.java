package action;
//������������ʾ��в���ѡ����
import java.sql.*;

public class insert_QA
{
	private String QAnum1;//�ʾ����
	private String xxx;
	private String ques1;
	private String desc1;
	private String key1;
	private String score1;
	private String basename;
	private String yyy;
	private String authorname;
	public static boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	public String insert_wenda()
	{
		this.authorname = this.yyy;
		this.QAnum1=this.xxx;
		this.basename = this.QAnum1;
		System.out.println("00:");
		System.out.println(this.QAnum1);
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
			Connection conn = new initialize().getlink(this.QAnum1);
			String sql="insert into qa(question,answer,keywords,score) values(?,?,?,?)";
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
	public String getQAnum1() {
		return QAnum1;
	}
	public void setQAnum(String QAnum1) {
		this.QAnum1 = QAnum1;
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
	public String getBasename() {
		return basename;
	}
	public void setBasename(String basename) {
		this.basename = basename;
	}
	public String getXxx() {
		return xxx;
	}
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getYyy() {
		return yyy;
	}
	public void setYyy(String yyy) {
		this.yyy = yyy;
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
