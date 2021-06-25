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
 * Servlet implementation class editProfileController
 */
@WebServlet("/editprofile")
public class editProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/customer-account.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userD = new UserDao();
		HttpSession session = request.getSession();
		UserModel user = (UserModel)session.getAttribute("user");
		int userID = (int)user.getUserId();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String fullname = request.getParameter("fullname");
		String gettag = (String)request.getParameter("tag");
		System.out.println(fullname);
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		if(fullname==null ) {
			fullname=user.getFullName();
		}else if(phoneNumber==null) {
			phoneNumber=user.getPhoneNumber();
		}if(address==null) {
			address=user.getAddress();
		}
			System.out.println(fullname);	
		boolean result = userD.editProfile(userID, fullname, phoneNumber, address);
		if(result==true) {
			user.setAddress(address);
			user.setFullName(fullname);
			user.setPhoneNumber(phoneNumber);
			session.setAttribute("user", user);
			request.setAttribute("mes1", "success");
			request.setAttribute("tag", "myAccount");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/customer-account.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("mes1", "error");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/customer-account.jsp");
			dispatcher.forward(request, response);
		}
	}

}
