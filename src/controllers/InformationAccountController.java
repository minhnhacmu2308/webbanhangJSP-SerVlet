package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AuthenticationDao;
import models.UserModel;

/**
 * Servlet implementation class InformationAccountController
 */
@WebServlet("/detailuser")
public class InformationAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthenticationDao auth = new AuthenticationDao();
		
		String userName = request.getParameter("username");
		
		UserModel user = auth.getInformationUser(userName);
		
		if(user != null) {
			
			request.setAttribute("infoAccount", user);
			request.setAttribute("tag", "myAccount");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer-account.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
