package controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//        
//        response.setContentType("text/html;charset=utf-8");          
//        /* ������Ӧͷ����ajax������� */  
//        response.setHeader("Access-Control-Allow-Origin", "*");  
//        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
//        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
//       
//        //��ȡ΢��С����get�Ĳ���ֵ����ӡ
//        String name = request.getParameter("name");
//        
//        System.out.println("����   =  "+name);
//        
//        //����ֵ��΢��С����
//        Writer out = response.getWriter(); 
//        out.write("��̨������");
//        out.flush();   
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}