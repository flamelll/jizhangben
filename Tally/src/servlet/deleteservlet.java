package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.deletedao;
import bean.tally;
import util.DBUtil;

/**
 * Servlet implementation class deleteservlet
 */
@WebServlet("/deleteservlet")
public class deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
		        response.setContentType("text/html;charset=utf-8");
		        
		        String date = request.getParameter("date");
		        String money=request.getParameter("money");
		        String type=request.getParameter("type");
		        String style=request.getParameter("style");
		        tally tally = new tally();
		        tally.setDate(date);
		        tally.setMoney(money);
		        tally.setType(type);
		        tally.setStyle(style);
		        //����Ҫɾ�����û�������
		        //String sql = "SELECT * FROM homework WHERE name='"+name+"' AND password='"+password+"'";
		        Connection conn = DBUtil.getConn();
		        Statement state = null;
				ResultSet rs = null;
				
		        deletedao sd = new deletedao();
		        try {
		        	state = conn.createStatement();
		        	//rs = state.executeQuery(sql);//executeQuery()���ذ���������ѯ���������ݵ� ResultSet ����,���û�в�ѯ����Ϣ������һ��next()Ϊfalse��ResultSet ����
		        	//if(rs.next()) {
		            sd.delete(date,money,type,style);
		            response.setCharacterEncoding("gbk");
					PrintWriter out = response.getWriter();
					out.println("<script> alert('ɾ���ɹ�'); window.location.href='showservlet'; </script>");
		            //response.sendRedirect(request.getContextPath() + "/delete.jsp");
		        	//}
		        	//else {response.setCharacterEncoding("gbk");
					//PrintWriter out = response.getWriter();
					//out.println("<script> alert('ɾ��ʧ�ܣ��û������ڻ���������'); window.location.href='delete.jsp'; </script>");}
		        }catch(Exception e) {
		            System.out.println("ɾ��ʧ��");
		            e.printStackTrace();
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
