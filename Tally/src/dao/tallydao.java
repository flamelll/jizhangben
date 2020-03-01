package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import bean.tally;
import util.DBUtil;
public class tallydao {
	/**
	 * 用户记账
	 * @param tally
	 * @return
	 */
	public boolean tally(tally tally) {
		String sql = "insert into tally(date,money,type,style) values(?,?,?,?)";
		Connection conn = DBUtil.getConn(); //连接数据库
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);//用于将 SQL 语句发送到数据库中。
			pstmt.setString(1,tally.getDate());//1代表第一列
			pstmt.setString(2,tally.getMoney());
			pstmt.setString(3,tally.getType());
			pstmt.setString(4,tally.getStyle());
			count = pstmt.executeUpdate();//返回的是受影响的行数（即更新的行数）
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(count>0) {
			return true;
		}
		return false;
	}
}
