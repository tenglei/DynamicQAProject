package action;//���ڼ���

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;

public class checkans 
{
	private String QAnum;//���ڴ�ֵ
	private String wenjuan;//��������һ��ҳ�洫ֵ
	private List<String> selectans=new ArrayList<String>();
	private List<String> fillans=new ArrayList<String>();
	private List<String> qaans=new ArrayList<String>();
	private String totalscore;//�ܷ���5
	private String huidazhe;//�ش��ߵ�����1
	private String huidazhemingci;//�ش��ߵ�����2
	private String huidacishu;//�Ѿ��ش��������3
	private String tishixinxi;//��ʾ��Ϣ4
	public void zhuanhuan(List<String> a,List<String> b)//����������ֵ,a��ԭ����
	{
		String x = a.get(0);
		String[] y =x.split(",");
		for(int z=0;z<y.length;z++)
		{
			b.add(y[z]);
		}
	}
	public String checkanswer()//���𰸲���������
	{
		//�������ڼ����Ҫ��ֵ�Ƿ��˽���
		//�����ֵ���Զ��ŷָ��ģ��ȶԴ����ֵ������
		
		
		//�ȴ������list
		List<String> selectans1=new ArrayList<String>();
		List<String> fillans1=new ArrayList<String>();
		List<String> qaans1=new ArrayList<String>();
		zhuanhuan(selectans,selectans1);
		zhuanhuan(fillans,fillans1);
		zhuanhuan(qaans,qaans1);
		//�������ڲ���
		System.out.println("�ʾ�����ǣ�");
		System.out.println(this.QAnum);
		System.out.println("�ش��ߵ������ǣ�");
		System.out.println(this.huidazhe);
		System.out.println("���յ���ѡ������ǣ�");
		Iterator<String> select = selectans1.iterator();
		while(select.hasNext())
		{
			System.out.println(select.next());
		}
		System.out.println("���յ����������ǣ�");
		Iterator<String> fill = fillans1.iterator();
		while(fill.hasNext())
		{
			System.out.println(fill.next());
		}
		System.out.println("���յ����ʴ�����ǣ�");
		Iterator<String> QA = qaans1.iterator();
		while(QA.hasNext())
		{
			System.out.println(QA.next());
		}
		
		
		//���濪ʼ�ж�ѡ����
		this.wenjuan = this.QAnum;
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
				if(selectans1.get(x1).equals(rs.getString(6)))//�����ƥ��
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
				String[] zuoda = fillans1.get(x2).split(" ");//�ش��ߵĻش�
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
		//�������ڲ���
		this.totalscore = String.valueOf(total);
		System.out.println("������������յ÷��ǣ�");
		System.out.println(this.totalscore);
		//���¸����ʾ�����
		try{
		String sql4="insert into list(mingci,name,score) values(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql4);
		ps.setInt(1,0);//��Ĭ��Ϊ0����
		ps.setString(2,this.huidazhe);
		ps.setFloat(3,total);
		ps.executeUpdate();
		ps.close();
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//��������������
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
				stat6.executeUpdate(sql6);//�����е����ζ�����һ��
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
		//�����������ʾ�ش���������ʾ��Ϣ
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
				this.tishixinxi = "����ˮƽ�ܸ߰�ɧ�꣬�ٽ�������";
			}
			else
			{
				this.tishixinxi = "�㻹��Ҫ�������Լ�������ˮƽ��ɧ�꣡";
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
		s.fillans.add("�����������֮");
		s.fillans.add("���ᣡ");
		s.qaans.add("��ۼ���ȥ����ɣ�");
		s.huidazhe="xuefeng";
		s.checkanswer();
		System.out.println("�ʾ�ţ�");
		System.out.println(s.wenjuan);
		System.out.println("�ܷ֣�");
		System.out.println(s.totalscore);
		System.out.println("�ش�������");
		System.out.println(s.huidazhemingci);
		System.out.println("�ش����");
		System.out.println(s.huidacishu);
		System.out.println("��ʾ��Ϣ");
		System.out.println(s.tishixinxi);
	}
	*/
	
	
	
	
}
