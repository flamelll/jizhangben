package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import dao.deletedao;
import bean.tally;
import util.DBUtil;

/**
 * Servlet implementation class WXServletDelete
 */
@WebServlet("/WXServletDelete")
public class WXServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
//       用于删除
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WXServletDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        tally tally = new tally();
        //获取微信小程序get的参数值并打印
        String date = request.getParameter("date");
        String money=request.getParameter("money");
        String type=request.getParameter("type");
        String style=request.getParameter("style");
        tally.setDate(request.getParameter("date"));
        tally.setMoney(request.getParameter("money"));
        tally.setType(request.getParameter("type"));
        tally.setStyle(request.getParameter("style"));
        System.out.println("date="+tally.getDate()+" ,money="+tally.getMoney()+",type="+tally.getType()+",style="+tally.getStyle());
        Connection conn = DBUtil.getConn();
        Statement state = null;
		ResultSet rs = null;
        deletedao sd = new deletedao();
        
        try {
        	state = conn.createStatement();
            sd.delete(date,money,type,style);
            
          //转成json数据
            Map<String, Object> result = new HashMap<String, Object>();
           
            result.put("data", tally);
            result.put("msg", "删除成功");
            
            //使用Gson类需要导入gson-2.8.0.jar
            String json = new Gson().toJson(result);

            //返回值给微信小程序
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        }catch(Exception e) {
            System.out.println("删除失败");
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
