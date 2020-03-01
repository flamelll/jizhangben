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
//        /* 设置响应头允许ajax跨域访问 */  
//        response.setHeader("Access-Control-Allow-Origin", "*");  
//        /* 星号表示所有的异域请求都可以接受， */  
//        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
//       
//        //获取微信小程序get的参数值并打印
//        String name = request.getParameter("name");
//        
//        System.out.println("姓名   =  "+name);
//        
//        //返回值给微信小程序
//        Writer out = response.getWriter(); 
//        out.write("后台已连接");
//        out.flush();   
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}