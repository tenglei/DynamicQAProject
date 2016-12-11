package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class newregister extends ActionSupport implements ServletRequestAware{
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
	 * ����ajax����
	 * @return SUCCESS
	 */
	public String excuteAjax(){
		
		try {
			//��ȡ����
			String name = request.getParameter("Name");//ע����
			String password = request.getParameter("Password");//ע������
			String email = request.getParameter("Email");
			String returnzhi = "";
			//����Ƿ�������
			System.out.println(name);
			System.out.println(password);
			System.out.println(email);
			Connection conn = new initialize().getlink("project");
			String temp = "";
			int guanzhu = 0;
			try
			{
				
				Connection a1 = new initialize().getlink("project");//���ú������г�ʼ��
				boolean isrepeat = false;
				String sql1 = "select * from user where Name=\""+name+"\"";
				try
				{
					Statement stmt1 = a1.createStatement();
					ResultSet rs1 = stmt1.executeQuery(sql1);
					while(rs1.next()!=false)
					{
						isrepeat = true;
					}
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				if(isrepeat == true)
				{
					returnzhi = "repeat";
				}
				else//û���ظ������Բ���
				{
					/*�ȵõ���ǰ�ı�� �����µ�ǰ�ı��*/
					int idnum = 0;
					try
					{
						String sql2 = "select * from nowinformation";
						String sql3 = "";
						String s1 = "";
						Statement stmt2 = a1.createStatement();
						ResultSet rs2 = stmt2.executeQuery(sql2);
						while(rs2.next()!=false)
						{
							idnum = Integer.parseInt(rs2.getString(2))+1;
							s1 = rs2.getString(2);
						}
						sql3 = "update nowinformation set idnow="+"\""+String.valueOf(idnum)+"\""+"where idnow="+"\""+s1+"\"";                
						stmt2.executeUpdate(sql3);
					}
					catch (SQLException e2)
					{
						e2.printStackTrace();
					}
					/*�õ�������Ϊint�ı��*/
					try
			        {
			        	String sql4="insert into user(Name,PassWord,Email,UserID,Friends,wenjuanhao,guanzhurenshu,fensishu) values(?,?,?,?,?,?,?,?)";
			            PreparedStatement ps=a1.prepareStatement(sql4);
			            ps.setString(1, name);
			            ps.setString(2, password);
			            ps.setString(3, email);
			            ps.setString(4,	String.valueOf(idnum));
			            ps.setString(5, "");
			            ps.setString(6, "");
			            ps.setInt(7, 0);
			            ps.setInt(8, 0);
			            ps.executeUpdate();
			        }
			        catch(Exception e3)
			        {
			        	e3.printStackTrace();
			        }
					returnzhi="success";//����ɹ���
				}
				
			}
			catch(Exception e3)
	        {
	        	e3.printStackTrace();
	        }
			System.out.println(returnzhi);
			//�����ݴ洢��map���ת����json�������ݣ�Ҳ�����Լ��ֶ�����json��������
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("Name", returnzhi);
			map.put("Email", returnzhi);
			map.put("Password", returnzhi);
			JSONObject json = JSONObject.fromObject(map);//��map����ת����json��������
			result = json.toString();//��result��ֵ�����ݸ�ҳ��
			System.out.println("shit");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	
}
