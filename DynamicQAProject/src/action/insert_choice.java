package action;
//这个类用于在问卷中插入选择题
import java.sql.*;

public class insert_choice 
{
	private String QAnum1;//问卷号码
	private String xxx;
	private String ques1;
	private String first1;
	private String second1;
	private String third1;
	private String fourth1;
	private String key1;
	private String score1;
	private String basename;
	private String yyy;
	private String authorname;
	public static boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	public String insert_cho()
	{
		this.authorname = this.yyy;
		this.QAnum1 = this.xxx;
		this.basename = this.QAnum1;
		boolean right = true;
		if(this.ques1.length()==0||this.first1.length()==0||this.second1.length()==0||this.third1.length()==0||this.fourth1.length()==0)
		{
			right = false;
		}
		if(this.key1.equals("A")==false&&this.key1.equals("B")==false&&this.key1.equals("C")==false&&this.key1.equals("D")==false)
		{
			right = false;
		}
		if(isNum(this.score1)==false)
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
			String sql="insert into choice(question,Ach,Bch,Cch,Dch,answer,score) values(?,?,?,?,?,?,?)";
			try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,this.ques1);
			ps.setString(2,this.first1);
			ps.setString(3, this.second1);
			ps.setString(4, this.third1);//总的分值暂定是0
			ps.setString(5, this.fourth1);
			ps.setString(6, this.key1);
			ps.setFloat(7, Float.parseFloat(this.score1));
			ps.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			//更新各项数据
			new tongyong().updatebase(conn, 1, Float.parseFloat(this.score1));
			System.out.println("增加成功！");
			return "successinsert";
		}
	}
	
	public void setQAnum1(String QAnum1)
	{
		this.QAnum1 = QAnum1;
	}
	public void setques1(String ques1)
	{
		this.ques1 = ques1;
	}
	public void setkey1(String key1)
	{
		this.key1 = key1;
	}
	public void setscore1(String score1)
	{
		this.score1 = score1;
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
	public String getXxx() {
		return xxx;
	}
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
	
	public String getBasename() {
		return basename;
	}
	public void setBasename(String basename) {
		this.basename = basename;
	}
	public String getFirst1() {
		return first1;
	}
	public void setFirst1(String first1) {
		this.first1 = first1;
	}
	public String getSecond1() {
		return second1;
	}
	public void setSecond1(String second1) {
		this.second1 = second1;
	}
	public String getThird1() {
		return third1;
	}
	public void setThird1(String third1) {
		this.third1 = third1;
	}
	public String getFourth1() {
		return fourth1;
	}
	public void setFourth1(String fourth1) {
		this.fourth1 = fourth1;
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
}
