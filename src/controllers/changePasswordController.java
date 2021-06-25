package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import models.UserModel;

/**
 * Servlet implementation class changePasswordController
 */
@WebServlet("/changepassword")
public class changePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userD = new UserDao();
		HttpSession session = request.getSession();
		UserModel user = (UserModel)session.getAttribute("user");
		int userID = (int)user.getUserId();
		String passWordOld = request.getParameter("passwordOld");
		String passwordNew = request.getParameter("passwordNew");
		String rePasswordNew = request.getParameter("rePasswordNew");
		System.out.println(passwordNew);
		System.out.println(rePasswordNew);
		if(!passwordNew.equals(rePasswordNew)) {
			request.setAttribute("mes", "error");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/customer-account.jsp");
			dispatcher.forward(request, response);
		}else {
			boolean result = userD.changePassword(userID, passWordOld, passwordNew);
			
			if(result==true) {
			    request.setAttribute("mes", "success");
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/customer-account.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("mes", "error1");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/customer-account.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}

}
