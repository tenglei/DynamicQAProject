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
			String sql = "select * from user where Name="+"\""+QAname+"\"";
//				Statement stat = conn.createStatement();
//				ResultSet rs = stat.executeQuery(sql);
//				while(rs.next()!=false)
//				{
//					temp = rs.getString(5);
//					guanzhu = rs.getInt(7);
//				}
//				rs.close();
//				stat.close();
//				Statement stat2 = conn.createStatement();
//				String sql2 = "update user set Friends="+"\""+temp+" "+name+"\""+" where Name="+"\""+author+"\"";
//				stat2.executeUpdate(sql2);
//				stat2.close();
//				Statement stat3 = conn.createStatement();
//				String sql3 = "update user set guanzhurenshu="+String.valueOf(guanzhu+1)+" where Name="+"\""+author+"\"";
//				stat3.executeUpdate(sql3);
//				stat3.close();
//				String sql4 = "select * from user where Name="+"\""+name+"\"";
//				Statement stat4 = conn.createStatement();
//				ResultSet rs4 = stat4.executeQuery(sql4);
//				while(rs4.next()!=false)
//				{
//					guanzhu = rs4.getInt(8);
//				}
//				Statement stat5 = conn.createStatement();
//				String sql5 = "update user set fensishu="+String.valueOf(guanzhu+1)+" where Name="+"\""+name+"\"";
//				stat5.executeUpdate(sql5);
//				stat5.close();
			
			
			
			
			
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
