package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ��1805-2 ������ 20183542 
 * 2020��2��3��
 *�������ݿ����
 */
public class DBUtil {
	
	public static String db_url = "jdbc:mysql://localhost:3306/Tally";
	public static String db_user = "root";
	public static String db_pass = "101032";
	
	public static Connection getConn () {
		Connection conn = null;
		
		
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			conn = DriverManager.getConnection(db_url, db_user, db_pass);
			System.out.println("���ӳɹ�!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void main(String[] args) {
		getConn();
	}
	
	/**
	 * @param state
	 * @param conn
	 */
	public static void close (Statement state, Connection conn) {
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close (ResultSet rs, Statement state, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}