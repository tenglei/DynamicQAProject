package action;//���ڼ���

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;

public class checkans 
{
	private String QAnum;//���ڴ�ֵ
	private List<String> selectans=new ArrayList<String>();
	private List<String> fillans=new ArrayList<String>();
	private List<String> qaans=new ArrayList<String>();
	private String totalscore;//�ܷ���
	public String checkanswer()//���𰸲���������
	{
		//�������ڼ����Ҫ��ֵ�Ƿ��˽���
		
		System.out.println("�ʾ�����ǣ�");
		System.out.println(this.QAnum);
		System.out.println("���յ���ѡ������ǣ�");
		Iterator<String> select = this.selectans.iterator();
		while(select.hasNext())
		{
			System.out.println(select.next());
		}
		System.out.println("���յ����������ǣ�");
		Iterator<String> fill = this.fillans.iterator();
		while(fill.hasNext())
		{
			System.out.println(fill.next());
		}
		System.out.println("���յ����ʴ�����ǣ�");
		Iterator<String> QA = this.qaans.iterator();
		while(QA.hasNext())
		{
			System.out.println(QA.next());
		}
		
		//���濪ʼ�ж�ѡ����
		float total = 0;//��ʼ��0��
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
				if(this.selectans.get(x1).equals(rs.getString(6)))//�����ƥ��
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
		
		//���¿�ʼ�ж������
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
				int dange = Integer.parseInt(rs2.getString(4))/kongshu;//������ķ�ֵ
				String[] biaozhun = rs2.getString(3).split(" ");//��׼��
				String[] zuoda = this.fillans.get(x2).split(" ");//�ش��ߵĻش�
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
		//��������ʼ�ж��ʴ���
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
				String[] guanjianci = rs3.getString(3).split(" ");//��׼��
				int dangefenshu = guanjianci.length;
				int cv = Integer.parseInt(rs3.getString(4))/dangefenshu;
				for(int z1 = 0;z1<dangefenshu;z1++)//���йؼ��ʣ�����û�У��������йؼ���
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
		//�������ڲ���
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
		s.fillans.add("�����������֮");
		s.fillans.add("���ᣡ");
		s.qaans.add("��ۼ���ȥ����ɣ�");
		s.checkanswer();
		System.out.println("�ܷ��ǣ�");
		System.out.println(s.totalscore);
	}
	*/
}
