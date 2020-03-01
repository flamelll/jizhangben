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

import bean.tally;
import dao.tallydao;
import service.tallyservice;

/**
 * Servlet implementation class WXServletTally
 */
@WebServlet("/WXServletTally")
public class WXServletTally extends HttpServlet {
	private static final long serialVersionUID = 1L;
//       ���ڼ���
	private tallyservice Ser=new tallyservice();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WXServletTally() {
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

        tally tally = new tally();
        //��ȡ΢��С����get�Ĳ���ֵ����ӡ
        tally.setDate(request.getParameter("date"));
        tally.setMoney(request.getParameter("money"));
        tally.setType(request.getParameter("type"));
        tally.setStyle(request.getParameter("style"));
        System.out.println("date="+tally.getDate()+" ,money="+tally.getMoney()+",type="+tally.getType()+",style="+tally.getStyle());
        //ת��json����
        Map<String, Object> result = new HashMap<String, Object>();
        if(Ser.tally(tally)) {
        result.put("data", tally);
        result.put("msg", "��̨���յ�");
        }else {
        	result.put("data", tally);
            result.put("msg", "��̨û���յ�");
        }
        
        //ʹ��Gson����Ҫ����gson-2.8.0.jar
        String json = new Gson().toJson(result);

        //����ֵ��΢��С����
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
