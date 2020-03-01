package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

import bean.user;
import service.registerservice;
import util.DBUtil;

/**
 * Servlet implementation class registerservlet
 */
@WebServlet("/registerservlet")
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private registerservice Ser=new registerservice();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");     //getParameter()��ȡ���ǿͻ������õ����ݡ�
		String password = request.getParameter("password");
		
		String sql = "select name from user where ";
		if (name != "") {
			sql += "name like '%" + name + "%'";
		}
		
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);//executeQuery()���ذ���������ѯ���������ݵ� ResultSet ����,���û�в�ѯ����Ϣ������һ��next()Ϊfalse��ResultSet ����
			if(rs.next()==false) {
				//name = rs.getString("name");

				user user = new user();
				user.setName(name);
				user.setPassword(password);
				response.setCharacterEncoding("gbk");
				PrintWriter out = response.getWriter();
				System.out.println(" "+user.getName()+" "+user.getPassword());
				if(Ser.register(user)) {
					out.println("<script> alert('��ӳɹ�!'); window.location.href='register.jsp'; </script>");
					
				}else {
					out.println("<script> alert('���ʧ��!'); window.location.href='register.jsp'; </script>");
				}
				out.println("</HTML>");
				out.flush();     //out.flush()��ʾǿ�ƽ��������е����ݷ��ͳ�ȥ�����صȵ���������
				out.close();     
				
			}
			else {response.setCharacterEncoding("gbk");
				PrintWriter out = response.getWriter();
				out.println("<script> alert('���û��Ѵ��ڣ����ʧ��!'); window.location.href='register.jsp'; </script>");
				out.println("</HTML>");
				out.flush();     //out.flush()��ʾǿ�ƽ��������е����ݷ��ͳ�ȥ�����صȵ���������
				out.close();     
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
