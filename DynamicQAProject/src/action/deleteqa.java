package action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class deleteqa extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	private String result;

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * 处理ajax请求
	 * @return SUCCESS
	 */
	public String excuteAjax(){
		
		try {
			//获取数据
			String QAname = request.getParameter("name");		
			System.out.println(QAname);
			Connection conn = new initialize().getlink(QAname);
			//下面做参考
			String sql = "select * from property";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			String classname = "";
			String authorid = "";
			String author = "";
			while(rs.next()!=false)
			{
				classname = rs.getString(3);
				authorid = rs.getString(2);
			}
			//下面找作者
			Connection conn2 = new initialize().getlink("project");
			//下面做参考
			String sql2 = "select * from user where UserID="+"\""+authorid+"\"";
			Statement stat2 = conn2.createStatement();
			ResultSet rs2 = stat2.executeQuery(sql2);
			while(rs2.next()!=false)
			{
				author = rs2.getString(1);
			}
			//删除数据库
			Statement stat3 = conn2.createStatement();
			String sql3 = "drop database "+QAname;
			stat3.executeUpdate(sql3);
			//删除allpaper中内容
			String sql4 = "delete from allpaper where paper="+"\""+QAname+"\"";
			Statement stat4 = conn2.createStatement();
			stat4.executeUpdate(sql4);
			//删除该问卷中类。。。
			String sql5 = "delete from "+classname+" where paper="+"\""+QAname+"\"";
			Statement stat5 = conn2.createStatement();
			stat5.executeUpdate(sql5);
			//去作者中删除
			String temp = "";
			StringBuffer x =new StringBuffer("");
			String yuan = "";
			String sql6 = "select * from user where Name="+"\""+author+"\"";
			Statement stat6 = conn2.createStatement();
			ResultSet rs6 = stat6.executeQuery(sql6);
			while(rs6.next()!=false)
			{
				yuan = rs6.getString(6);
			}
			String t[] = yuan.split(" ");
			int cishu = 0;
			for(int i=0;i<t.length;i++)
			{
				if(t[i].equals(QAname)==false)
				{
					if(cishu==0)
					{
						x.append(t[i]);
					}
					else 
					{
						x.append(" ");
						x.append(t[i]);
					}
					cishu++;
				}
			}
			temp = x.toString();
			String sql7 = "update user set wenjuanhao="+"\""+temp+"\""+" where Name="+"\""+author+"\"";
			Statement stat7 = conn2.createStatement();
			stat7.executeUpdate(sql7);
			System.out.println("wancheng!");
			//将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
//			Map<String,Object> map = new HashMap<String,Object>();
//			map.put("name", name);
//			map.put("author", author);
//			JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
//			result = json.toString();//给result赋值，传递给页面
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}


	
}
