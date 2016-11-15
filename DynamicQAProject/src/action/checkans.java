package action;//用于检测答案

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;

public class checkans 
{
	private String QAnum;//用于传值
	private String wenjuan;//用于向下一级页面传值
	private List<String> selectans=new ArrayList<String>();
	private List<String> fillans=new ArrayList<String>();
	private List<String> qaans=new ArrayList<String>();
	private String totalscore;//总分数5
	private String huidazhe;//回答者的名字1
	private String huidazhemingci;//回答者的名次2
	private String huidacishu;//已经回答结束人数3
	private String tishixinxi;//提示信息4
	public void zhuanhuan(List<String> a,List<String> b)//处理传进来的值,a是原来的
	{
		String x = a.get(0);
		String[] y =x.split(",");
		for(int z=0;z<y.length;z++)
		{
			b.add(y[z]);
		}
	}
	public String checkanswer()//检测答案并更新排名
	{
		//以下用于检测需要的值是否穿了进来
		//传入的值是以逗号分隔的，先对传入的值做处理
		
		
		//先处理传入的list
		List<String> selectans1=new ArrayList<String>();
		List<String> fillans1=new ArrayList<String>();
		List<String> qaans1=new ArrayList<String>();
		zhuanhuan(selectans,selectans1);
		zhuanhuan(fillans,fillans1);
		zhuanhuan(qaans,qaans1);
		//以下用于测试
		System.out.println("问卷号码是：");
		System.out.println(this.QAnum);
		System.out.println("回答者的姓名是：");
		System.out.println(this.huidazhe);
		System.out.println("接收到的选择题答案是：");
		Iterator<String> select = selectans1.iterator();
		while(select.hasNext())
		{
			System.out.println(select.next());
		}
		System.out.println("接收到的填空题答案是：");
		Iterator<String> fill = fillans1.iterator();
		while(fill.hasNext())
		{
			System.out.println(fill.next());
		}
		System.out.println("接收到的问答题答案是：");
		Iterator<String> QA = qaans1.iterator();
		while(QA.hasNext())
		{
			System.out.println(QA.next());
		}
		
		
		//下面开始判定选择题
		this.wenjuan = this.QAnum;
		float total = 0;//起始算0分
		Connection conn = new initialize().getlink(this.QAnum);
		int x1 = -1;
		try
		{
			String sql = "select * from choice";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()!=false)
			{
				x1++;
				if(selectans1.get(x1).equals(rs.getString(6)))//如果答案匹配
				{
					total = total + Float.parseFloat(rs.getString(7));
				}
			}
			stat.close();
			rs.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		//以下开始判定填空题
		int x2 = -1;
		try
		{
			String sql2 = "select * from fill";
			Statement stat2 = conn.createStatement();
			ResultSet rs2 = stat2.executeQuery(sql2);
			while(rs2.next()!=false)
			{
				x2++;
				int correct = 0;
				int kongshu = Integer.parseInt(rs2.getString(1));
				int dange = Integer.parseInt(rs2.getString(4))/kongshu;//单个题的分值
				String[] biaozhun = rs2.getString(3).split(" ");//标准答案
				String[] zuoda = fillans1.get(x2).split(" ");//回答者的回答
				int y = -1;
				for(int z=0;z<biaozhun.length;z++)
				{
					y++;
					if(zuoda[y].equals(biaozhun[z]))
					{
						correct++;
					}
				}
				total = total + correct*dange;
			}
			stat2.close();
			rs2.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//接下来开始判定问答题
		int x3 = -1;
		try
		{
			String sql3 = "select * from qa";
			Statement stat3 = conn.createStatement();
			ResultSet rs3 = stat3.executeQuery(sql3);
			while(rs3.next()!=false)
			{
				x3++;
				int correctguan = 0;
				String[] guanjianci = rs3.getString(3).split(" ");//标准答案
				int dangefenshu = guanjianci.length;
				int cv = Integer.parseInt(rs3.getString(4))/dangefenshu;
				for(int z1 = 0;z1<dangefenshu;z1++)//所有关键词，看有没有？对于所有关键词
				{
					if(qaans1.get(x3).indexOf(guanjianci[z1])!=-1)
					{
						correctguan++;
					}
				}
				total = total+correctguan*cv;
			}
			stat3.close();
			rs3.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//以下用于测试
		this.totalscore = String.valueOf(total);
		System.out.println("计算出来的最终得分是：");
		System.out.println(this.totalscore);
		//以下更新问卷排名
		try{
		String sql4="insert into list(mingci,name,score) values(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql4);
		ps.setInt(1,0);//先默认为0名次
		ps.setString(2,this.huidazhe);
		ps.setFloat(3,total);
		ps.executeUpdate();
		ps.close();
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//接下来更新名次
		int mingci = 0;
		try{
			String sql5 = "select * from list ORDER BY score DESC";
			Statement stat5 = conn.createStatement();
			Statement stat6 = conn.createStatement();
			ResultSet rs5 = stat5.executeQuery(sql5);
			while(rs5.next()!=false)
			{
				mingci++;
				/*
				if(this.huidazhe.equals(rs5.getString(2)))
				{
					String sql6 = "update list set mingci="+String.valueOf(mingci)+" where name="+"\""+this.huidazhe+"\"";
					stat6.executeUpdate(sql6);
					break;
				}
				*/
				String u = rs5.getString(2);
				String sql6 = "update list set mingci="+String.valueOf(mingci)+" where name="+"\""+u+"\"";
				stat6.executeUpdate(sql6);//把所有的名次都更新一遍
				if(this.huidazhe.equals(u))
				{
					this.huidazhemingci = String.valueOf(mingci);
				}
			}
			stat5.close();
			stat6.close();
			rs5.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//接下来更新问卷回答人数和提示信息
		try{
			String sql7 = "select * from property";
			Statement stat7 = conn.createStatement();
			ResultSet rs7 = stat7.executeQuery(sql7);
			int xc = 0;
			while(rs7.next()!=false)
			{
				xc = rs7.getInt(8)+1;
				break;
			}
			stat7.close();
			rs7.close();
			Statement stat8 = conn.createStatement();
			String sql8 = "update property set totalans="+String.valueOf(xc)+" where QAid="+"\""+this.QAnum+"\"";
			stat8.executeUpdate(sql8);
			stat8.close();
			this.huidacishu = String.valueOf(xc);
			if((float)mingci/(float)xc<0.5)
			{
				this.tishixinxi = "姿势水平很高啊骚年，再接再厉！";
			}
			else
			{
				this.tishixinxi = "你还是要提高提高自己的姿势水平啊骚年！";
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return "checkover";
	}
	public String getQAnum() {
		return QAnum;
	}
	public void setQAnum(String qAnum) {
		QAnum = qAnum;
	}
	public List<String> getSelectans() {
		return selectans;
	}
	public void setSelectans(List<String> selectans) {
		this.selectans = selectans;
	}
	public List<String> getFillans() {
		return fillans;
	}
	public void setFillans(List<String> fillans) {
		this.fillans = fillans;
	}
	public String getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(String totalscore) {
		this.totalscore = totalscore;
	}
	public List<String> getQaans() {
		return qaans;
	}
	public void setQaans(List<String> qaans) {
		this.qaans = qaans;
	}
	
	public String getWenjuan() {
		return wenjuan;
	}
	public void setWenjuan(String wenjuan) {
		this.wenjuan = wenjuan;
	}
	public String getHuidazhe() {
		return huidazhe;
	}
	public void setHuidazhe(String huidazhe) {
		this.huidazhe = huidazhe;
	}
	public String getHuidazhemingci() {
		return huidazhemingci;
	}
	public void setHuidazhemingci(String huidazhemingci) {
		this.huidazhemingci = huidazhemingci;
	}
	public String getHuidacishu() {
		return huidacishu;
	}
	public void setHuidacishu(String huidacishu) {
		this.huidacishu = huidacishu;
	}
	public String getTishixinxi() {
		return tishixinxi;
	}
	public void setTishixinxi(String tishixinxi) {
		this.tishixinxi = tishixinxi;
	}
	/*
	public static void main(String[] args)
	{
		checkans s = new checkans();
		s.QAnum = "yaobingkun15";
		s.selectans.add("C");
		s.selectans.add("B");
		s.selectans.add("C");
		s.fillans.add("岂因祸福避趋之");
		s.fillans.add("不会！");
		s.qaans.add("香港记者去吃翔吧！");
		s.huidazhe="xuefeng";
		s.checkanswer();
		System.out.println("问卷号：");
		System.out.println(s.wenjuan);
		System.out.println("总分：");
		System.out.println(s.totalscore);
		System.out.println("回答者名次");
		System.out.println(s.huidazhemingci);
		System.out.println("回答次数");
		System.out.println(s.huidacishu);
		System.out.println("提示信息");
		System.out.println(s.tishixinxi);
	}
	*/
	
	
	
	
}
