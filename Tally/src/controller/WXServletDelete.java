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
//       ����ɾ��
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
		//�����������
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /* ������Ӧͷ����ajax������� */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        tally tally = new tally();
        //��ȡ΢��С����get�Ĳ���ֵ����ӡ
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
            
          //ת��json����
            Map<String, Object> result = new HashMap<String, Object>();
           
            result.put("data", tally);
            result.put("msg", "ɾ���ɹ�");
            
            //ʹ��Gson����Ҫ����gson-2.8.0.jar
            String json = new Gson().toJson(result);

            //����ֵ��΢��С����
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
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
