package dao;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import util.DBUtil;
public class deletedao {
	Connection conn = DBUtil.getConn(); //连接数据库
	
	public boolean delete(String date,String money,String type,String style) {
		boolean flag=false;
		try {
		    String sql="delete from tally where date='"+date+"' and money='"+money+"' and type='"+type+"' and style='"+style+"'";
		    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		    int i = pstmt.executeUpdate();
		    pstmt.close();
		    conn.close();
		    if(i>0) flag = true;
		}catch(SQLException e) {
		    System.out.println("删除失败");    
		    e.printStackTrace();
		}

		return flag;

		}
}
