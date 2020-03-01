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
//       ���ڲ���
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
        //�����������
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /* ������Ӧͷ����ajax������� */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        user user = new user();
        //��ȡ΢��С����get�Ĳ���ֵ����ӡ
        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        System.out.println("username="+user.getName()+" ,password="+user.getPassword());
        //ת��json����
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", user);
        result.put("msg", "��̨���յ�");
        //ʹ��Gson����Ҫ����gson-2.8.0.jar
        String json = new Gson().toJson(result);

        //����ֵ��΢��С����
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
