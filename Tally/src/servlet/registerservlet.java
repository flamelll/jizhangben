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
		String name = request.getParameter("name");     //getParameter()获取的是客户端设置的数据。
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
			rs = state.executeQuery(sql);//executeQuery()返回包含给定查询所生成数据的 ResultSet 对象,如果没有查询到信息，返回一个next()为false的ResultSet 对象
			if(rs.next()==false) {
				//name = rs.getString("name");

				user user = new user();
				user.setName(name);
				user.setPassword(password);
				response.setCharacterEncoding("gbk");
				PrintWriter out = response.getWriter();
				System.out.println(" "+user.getName()+" "+user.getPassword());
				if(Ser.register(user)) {
					out.println("<script> alert('添加成功!'); window.location.href='register.jsp'; </script>");
					
				}else {
					out.println("<script> alert('添加失败!'); window.location.href='register.jsp'; </script>");
				}
				out.println("</HTML>");
				out.flush();     //out.flush()表示强制将缓冲区中的数据发送出去，不必等到缓冲区满
				out.close();     
				
			}
			else {response.setCharacterEncoding("gbk");
				PrintWriter out = response.getWriter();
				out.println("<script> alert('该用户已存在，添加失败!'); window.location.href='register.jsp'; </script>");
				out.println("</HTML>");
				out.flush();     //out.flush()表示强制将缓冲区中的数据发送出去，不必等到缓冲区满
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
