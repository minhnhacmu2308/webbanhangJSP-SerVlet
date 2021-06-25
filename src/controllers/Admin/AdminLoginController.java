package controllers.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AuthenticationDao;
import models.UserModel;
import service.AuthenticationService;
import service.impl.AuthenticationServiceImpl;

/**
 * Servlet implementation class AdminLoginController
 */

public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserModel user =(UserModel) session.getAttribute("admin");
		if(user!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/index.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/login.jsp");
			dispatcher.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		AuthenticationDao authdao = new AuthenticationDao();
		AuthenticationService auth = new AuthenticationServiceImpl();
		
		boolean result = auth.login(username, password);
		
		if(result==true) {
			HttpSession session = request.getSession();
			UserModel user = authdao.getInformationUser(username);
			session.setAttribute("admin", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
