package action;//用于检测答案

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;

public class checkans 
{
	private String QAnum;//用于传值
	private List<String> selectans=new ArrayList<String>();
	private List<String> fillans=new ArrayList<String>();
	private List<String> qaans=new ArrayList<String>();
	private String totalscore;//总分数
	public String checkanswer()//检测答案并更新排名
	{
		//以下用于检测需要的值是否穿了进来
		
		System.out.println("问卷号码是：");
		System.out.println(this.QAnum);
		System.out.println("接收到的选择题答案是：");
		Iterator<String> select = this.selectans.iterator();
		while(select.hasNext())
		{
			System.out.println(select.next());
		}
		System.out.println("接收到的填空题答案是：");
		Iterator<String> fill = this.fillans.iterator();
		while(fill.hasNext())
		{
			System.out.println(fill.next());
		}
		System.out.println("接收到的问答题答案是：");
		Iterator<String> QA = this.qaans.iterator();
		while(QA.hasNext())
		{
			System.out.println(QA.next());
		}
		
		//下面开始判定选择题
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
				if(this.selectans.get(x1).equals(rs.getString(6)))//如果答案匹配
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
				String[] zuoda = this.fillans.get(x2).split(" ");//回答者的回答
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
					if(this.qaans.get(x3).indexOf(guanjianci[z1])!=-1)
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
		System.out.println(this.totalscore);
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
	/*
	public static void main(String[] args)
	{
		checkans s = new checkans();
		s.QAnum = "yaobingkun15";
		s.selectans.add("A");
		s.selectans.add("B");
		s.selectans.add("A");
		s.fillans.add("岂因祸福避趋之");
		s.fillans.add("不会！");
		s.qaans.add("香港记者去吃翔吧！");
		s.checkanswer();
		System.out.println("总分是：");
		System.out.println(s.totalscore);
	}
	*/
}
