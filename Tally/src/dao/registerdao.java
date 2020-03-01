package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import bean.user;
import util.DBUtil;
public class registerdao {
	/**
	 * �û�ע��
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
		Connection conn = DBUtil.getConn(); //�������ݿ�
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);//���ڽ� SQL ��䷢�͵����ݿ��С�
			pstmt.setString(1,user.getName());//1�����һ��
			pstmt.setString(2,user.getPassword());
			count = pstmt.executeUpdate();//���ص�����Ӱ��������������µ�������
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		if(count>0) {
			return true;
		}
		return false;
	}
}
