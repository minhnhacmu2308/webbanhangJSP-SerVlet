package controllers;

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


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("home");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuthenticationDao auth = new AuthenticationDao();
		UserModel user = new UserModel();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		 if(userName == "" || password == "" ) {
			 request.setAttribute("messError1", "\r\n" + 
		    			"Enter complete information");
	        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
	    		requestDispatcher.forward(request, response);
		 }else {
			 boolean isLogin = auth.checkLogin(userName, password);
			 if(isLogin==true) {
				 user = auth.getInformationUser(userName);
				 HttpSession session = request.getSession();
				 session.setAttribute("user", user);
					
				 response.sendRedirect("home");
			 }else {
				request.setAttribute("messError1", "UserName or password incorret !!");
     			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
         		requestDispatcher.forward(request, response);
			 }
		 }
	}

}
