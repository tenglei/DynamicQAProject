package action;

import java.util.*;
import java.sql.*;//跳转到“随便看看”界面

public class goindex {
	
	private String welcomename;
	private List<String> yonghu = new ArrayList<String>();
	
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
	
	
	
	public String getinfor(){
		Connection conn = new initialize().getlink("project");
		new tongyong();
		String Friends = tongyong.getsth(conn, "user", this.welcomename,"Name" , 5);
		String[] friend = Friends.split(" ");
		//下面找六个还未关注的人
		int friendsnum = new tongyong().getjilu(conn, "user");
		//利用随机数生成，获得朋友仓库
		randomCommon(conn,0,friendsnum-1,6,friend);
		Iterator<String> it = this.yonghu.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
		return "successget";
	}
	
	/*
	public static void main(String[] args)
	{
		
		goindex t = new goindex();
		t.setWelcomename("yaobingkun");
		t.getinfor();
	}
	*/
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
	
}
