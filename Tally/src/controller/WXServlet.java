package controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import com.google.gson.Gson;

import bean.user;

/**
 * Servlet implementation class WXServlet
 */
@WebServlet("/WXServlet")
public class WXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//       用于测试
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WXServlet() {
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

        user user = new user();
        //获取微信小程序get的参数值并打印
        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        System.out.println("username="+user.getName()+" ,password="+user.getPassword());
        //转成json数据
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", user);
        result.put("msg", "后台已收到");
        //使用Gson类需要导入gson-2.8.0.jar
        String json = new Gson().toJson(result);

        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
