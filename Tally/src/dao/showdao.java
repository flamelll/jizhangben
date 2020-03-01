package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import bean.tally;
import util.DBUtil;
public class showdao {
	public List<tally> select(){
		Connection conn = DBUtil.getConn(); //连接数据库
	    List<tally> list = new ArrayList<tally>();
	    try {
	        String sql="select * from tally";
	        Statement pstmt = (Statement) conn.createStatement();
	        ResultSet rs = (ResultSet) pstmt.executeQuery(sql);
	        while(rs.next()) {
	        	tally tally=new tally();
	        	tally.setDate(rs.getString("date"));
	        	tally.setMoney(rs.getString("money"));
	        	tally.setType(rs.getString("type"));
	        	tally.setStyle(rs.getString("style"));
	            list.add(tally);
	        }
	        System.out.println("showdao运行成功");
	        rs.close();
	        pstmt.close();
	        conn.close();

	    }catch(SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}
