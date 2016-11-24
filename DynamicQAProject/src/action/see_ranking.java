package action;//查看问卷的排名

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class see_ranking {
	private String QAname;
	private List<String> mingci=new ArrayList<String>();
	private List<String> name = new ArrayList<String>();
	private List<String> score = new ArrayList<String>();
	public String seerank()
	{
		Connection conn = new initialize().getlink(this.QAname);//查看排名
		try{
			String sql = "select * from list ORDER BY mingci DESC";//按照降序排名
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()!=false)
			{
				mingci.add(rs.getString(1));
				name.add(rs.getString(2));
				score.add(rs.getString(3));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return "seesuccess";
	}
	public String getQAname() {
		return QAname;
	}

	public void setQAname(String qAname) {
		QAname = qAname;
	}

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	public List<String> getScore() {
		return score;
	}

	public void setScore(List<String> score) {
		this.score = score;
	}







	public List<String> getMingci() {
		return mingci;
	}







	public void setMingci(List<String> mingci) {
		this.mingci = mingci;
	}
	
}
