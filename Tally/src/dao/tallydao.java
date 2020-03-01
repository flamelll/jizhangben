package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import bean.tally;
import util.DBUtil;
public class tallydao {
	/**
	 * �û�����
	 * @param tally
	 * @return
	 */
	public boolean tally(tally tally) {
		String sql = "insert into tally(date,money,type,style) values(?,?,?,?)";
		Connection conn = DBUtil.getConn(); //�������ݿ�
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);//���ڽ� SQL ��䷢�͵����ݿ��С�
			pstmt.setString(1,tally.getDate());//1�����һ��
			pstmt.setString(2,tally.getMoney());
			pstmt.setString(3,tally.getType());
			pstmt.setString(4,tally.getStyle());
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
