package action;

import java.util.*;
import java.sql.*;//跳转到“随便看看”界面

public class goindex {
	
	private String welcomename;
	private String password;
	private List<String> yonghu = new ArrayList<String>();
	private String newf1;
	private String newf2;
	private String newf3;
	private String newf4;
	private String newf5;
	private String newf6;
	private String wenjuan1;
	private String wenjuan2;
	private String wenjuan3;
	private String wenjuan4;
	private String wenjuan5;
	private String wenjuan6;
	private String college;
	private String emotion;
	private String life;
	public boolean chongtu(String yaobi,String[] friend)
	{
		boolean ischongfu = false;
		for(int i=0;i<friend.length;i++)
		{
			if(yaobi.equals(friend[i]))
			{
				ischongfu = true;
				break;
			}
		}
		return ischongfu;
	}
	public String sethigh(Connection conn,String table)//寻找排名最高的三类问卷
	{
		String sql = "select * from "+table+" ORDER BY num DESC";
		String u = "";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				u =  rs.getString(1);
				break;
			}
		}
		catch (Exception e) { 
				e.printStackTrace(); 
		} 
		return u;
	}
	public void randomCommon(Connection conn,int min, int max, int n,String[] friend){//生成朋友
	    int[] result = new int[n];  
	    int count = 0;  
	    while(count < n) {  
	        int num = (int) (Math.random() * (max - min)) + min;  
	        boolean flag = true;  
	        for (int j = 0; j < n; j++) {  
	            if(num == result[j]){  
	                flag = false;  
	                break;  
	            }  
	        }  
	        if(flag){  
	        	String u = new tongyong().getExact(conn,"user", num,1);
	        	if(chongtu(u,friend)==false)//没有重复
	        	{
	        		this.yonghu.add(u);
	        		result[count] = num;  
 		            count++;
	        	}
	        	
	        	
	        	
	        }  
	    }    
	}  
	public void getwenjuan(Connection base,String table,int num,ArrayList <String> wenjuan)
	{
		String sql = "select * from "+table+" ORDER BY num DESC";
		try{
			PreparedStatement ps = base.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int h = 0;
			while(rs.next())
			{
				wenjuan.add(rs.getString(1));
				h++;
				if(h==num)
				{
					break;
				}
			}
		}
		catch (Exception e) { 
				e.printStackTrace(); 
			} 
	}
	
	
	public String getinfor(){
		ArrayList <String> wenjuan = new ArrayList <String>();
		Connection conn = new initialize().getlink("project");
		getwenjuan(conn,"allpaper",6,wenjuan);
		this.college=sethigh(conn,"college");
		this.emotion = sethigh(conn,"emotion");
		this.life = sethigh(conn,"life");
		new tongyong();
		String Friends = tongyong.getsth(conn, "user", this.welcomename,"Name" , 5);
		String[] friend = Friends.split(" ");
		//下面找六个还未关注的人
		int friendsnum = new tongyong().getjilu(conn, "user");
		//利用随机数生成，获得朋友仓库
		randomCommon(conn,0,friendsnum-1,6,friend);
		//Iterator<String> it = this.yonghu.iterator();
        this.newf1 = yonghu.get(0);
        this.newf2 = yonghu.get(1);
        this.newf3 = yonghu.get(2);
        this.newf4 = yonghu.get(3);
        this.newf5 = yonghu.get(4);
        this.newf6 = yonghu.get(5);
        this.wenjuan1 = wenjuan.get(0);
        this.wenjuan2 = wenjuan.get(1);
        this.wenjuan3 = wenjuan.get(2);
        this.wenjuan4 = wenjuan.get(3);
        this.wenjuan5 = wenjuan.get(4);
        this.wenjuan6 = wenjuan.get(5);
		return "successget";
	}
	

	public static void main(String[] args)
	{
		
		goindex t = new goindex();
		t.setWelcomename("yaobingkun");
		t.getinfor();
		System.out.println(t.newf1);
		System.out.println(t.newf2);
		System.out.println(t.newf3);
		System.out.println(t.newf4);
		System.out.println(t.newf5);
		System.out.println(t.newf6);
		System.out.println(t.wenjuan1);
		System.out.println(t.wenjuan2);
		System.out.println(t.wenjuan3);
		System.out.println(t.wenjuan4);
		System.out.println(t.wenjuan5);
		System.out.println(t.wenjuan6);
		System.out.println(t.college);
		System.out.println(t.emotion);
		System.out.println(t.life);
	}
	
	public String getWelcomename() {
		return welcomename;
	}

	public void setWelcomename(String welcomename) {
		this.welcomename = welcomename;
	}





	public List<String> getYonghu() {
		return yonghu;
	}





	public void setYonghu(List<String> yonghu) {
		this.yonghu = yonghu;
	}

	public String getNewf1() {
		return newf1;
	}

	public void setNewf1(String newf1) {
		this.newf1 = newf1;
	}

	public String getNewf3() {
		return newf3;
	}

	public void setNewf3(String newf3) {
		this.newf3 = newf3;
	}

	public String getNewf2() {
		return newf2;
	}

	public void setNewf2(String newf2) {
		this.newf2 = newf2;
	}

	public String getNewf5() {
		return newf5;
	}

	public void setNewf5(String newf5) {
		this.newf5 = newf5;
	}

	public String getNewf6() {
		return newf6;
	}

	public void setNewf6(String newf6) {
		this.newf6 = newf6;
	}

	public String getNewf4() {
		return newf4;
	}

	public void setNewf4(String newf4) {
		this.newf4 = newf4;
	}

	public String getWenjuan1() {
		return wenjuan1;
	}

	public void setWenjuan1(String wenjuan1) {
		this.wenjuan1 = wenjuan1;
	}

	public String getWenjuan2() {
		return wenjuan2;
	}

	public void setWenjuan2(String wenjuan2) {
		this.wenjuan2 = wenjuan2;
	}

	public String getWenjuan3() {
		return wenjuan3;
	}

	public void setWenjuan3(String wenjuan3) {
		this.wenjuan3 = wenjuan3;
	}

	public String getWenjuan4() {
		return wenjuan4;
	}

	public void setWenjuan4(String wenjuan4) {
		this.wenjuan4 = wenjuan4;
	}

	public String getWenjuan5() {
		return wenjuan5;
	}

	public void setWenjuan5(String wenjuan5) {
		this.wenjuan5 = wenjuan5;
	}

	public String getWenjuan6() {
		return wenjuan6;
	}

	public void setWenjuan6(String wenjuan6) {
		this.wenjuan6 = wenjuan6;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public String getLife() {
		return life;
	}

	public void setLife(String life) {
		this.life = life;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
