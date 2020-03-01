package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import bean.user;
import util.DBUtil;
public class registerdao {
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean register(user user) {
		/*`id` int(11) NOT NULL AUTO_INCREMENT,
		  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
		  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
		  `realname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
		  `sex` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
		  `area` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
		  `phone` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
		  `email` varchar(50)*/
		String sql = "insert into user(name,password) values(?,?)";
		Connection conn = DBUtil.getConn(); //连接数据库
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);//用于将 SQL 语句发送到数据库中。
			pstmt.setString(1,user.getName());//1代表第一列
			pstmt.setString(2,user.getPassword());
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
