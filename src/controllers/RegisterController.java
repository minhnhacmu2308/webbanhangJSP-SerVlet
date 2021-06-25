package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AuthenticationDao;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
        AuthenticationDao auth = new AuthenticationDao();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		String fullName = request.getParameter("fullName");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		
		
	    if(userName == "" || password == "" || rePassword == "" || fullName == "" || phoneNumber == "" || address == "" ) {
	    	
	    	request.setAttribute("messError", "\r\n" + 
	    			"Enter complete information");
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
    		requestDispatcher.forward(request, response);
	    }else if(!password.equals(rePassword)) {
        	
        	request.setAttribute("messError", "Password is not map with rePassword !!");
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
    		requestDispatcher.forward(request, response);
    		
        }else {
        	boolean isExit = auth.checkAccountExit(userName);
        	if(isExit) {
        		
        		request.setAttribute("messError", "UserName is exited !!");
        		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
        		requestDispatcher.forward(request, response);
        		
        	}else {
        		boolean result = auth.register(userName, password, fullName, phoneNumber, address);
        		
        		if(result==true) {
        			
        			request.setAttribute("messSuccess", "Register successefully !! ");
        			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
            		requestDispatcher.forward(request, response);
            		
        		}else {
        			
        			request.setAttribute("messError", "Error");
        			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
            		requestDispatcher.forward(request, response);
            		
        		}
        	}
        }
		
	
	}

}
