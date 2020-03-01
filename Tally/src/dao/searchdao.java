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
public class searchdao {
	public List<tally>selectdate(String date){
		Connection conn = DBUtil.getConn(); //连接数据库
	    List<tally> list1 = new ArrayList<tally>();
	    try {
	        String sql="select * from tally where date like '%"+date+"%' ";
	        Statement pstmt = (Statement) conn.createStatement();
	        ResultSet rs = (ResultSet) pstmt.executeQuery(sql);
	        while(rs.next()) {
	        	tally tally=new tally();
	        	tally.setDate(rs.getString("date"));
	        	tally.setMoney(rs.getString("money"));
	        	tally.setType(rs.getString("type"));
	        	tally.setStyle(rs.getString("style"));
	            list1.add(tally);
	        }
	        
	        rs.close();
	        pstmt.close();
	        conn.close();

	    }catch(SQLException e) {
	        e.printStackTrace();
	    }
	    System.out.println("searchdao运行成功");
	    return list1;
	    
	}
}
