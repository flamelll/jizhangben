package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.logindao;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    logindao dao = new logindao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String rname=dao.searchUsername(name);
		String rpassword=dao.searchPassword(name);
		if(name.equals(rname)&&password.equals(rpassword)) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			System.out.println("µÇÂ¼³É¹¦");
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request,response);
			System.out.println("µÇÂ¼Ê§°Ü");
			System.out.println(name+password);
			System.out.println(rname+rpassword);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if("search".equals(method))
		{
			doGet(request, response);
		}
		
	}
	}


