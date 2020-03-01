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

import bean.user;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;

import util.DBUtil;
import dao.tallydao;
import service.tallyservice;
import bean.tally;

/**
 * Servlet implementation class tallyservlet
 */
@WebServlet("/tallyservlet")
public class tallyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private tallyservice Ser=new tallyservice();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tallyservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");     //getParameter()获取的是客户端设置的数据。
		String money = request.getParameter("money");
		String type = request.getParameter("type");
		String style = request.getParameter("style");
//		String sql = "select name from tally where ";
//		if (name != "") {
//			sql += "name like '%" + name + "%'";
//		}
//		
//		Connection conn = DBUtil.getConn();
//		Statement state = null;
//		ResultSet rs = null;
//		try {
//			state = conn.createStatement();
//			rs = state.executeQuery(sql);//executeQuery()返回包含给定查询所生成数据的 ResultSet 对象,如果没有查询到信息，返回一个next()为false的ResultSet 对象
//			if(rs.next()==false) {
				//name = rs.getString("name");

				tally tally = new tally();
				tally.setDate(date);
				tally.setMoney(money);
				tally.setType(type);
				tally.setStyle(style);
				response.setCharacterEncoding("gbk");
				PrintWriter out = response.getWriter();
//				System.out.println(" "+user.getName()+" "+user.getPassword());
				if(Ser.tally(tally)) {
					out.println("<script> alert('添加成功!'); window.location.href='index.jsp'; </script>");
					
				}else {
					out.println("<script> alert('添加失败!'); window.location.href='tally.jsp'; </script>");
				}
				out.println("</HTML>");
				out.flush();     //out.flush()表示强制将缓冲区中的数据发送出去，不必等到缓冲区满
				out.close();     
		
//			}
//			else {
//				response.setCharacterEncoding("gbk");
//				PrintWriter out = response.getWriter();
//				out.println("<script> alert('该用户已存在，添加失败!'); window.location.href='register.jsp'; </script>");
//				out.println("</HTML>");
//				out.flush();     //out.flush()表示强制将缓冲区中的数据发送出去，不必等到缓冲区满
//				out.close();     
//			}
//	} 
//				catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(rs, state, conn);
//		}

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
