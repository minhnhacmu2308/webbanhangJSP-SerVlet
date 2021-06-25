package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.OrderModel;
import models.UserModel;

/**
 * Servlet implementation class CheckoutTwoController
 */
@WebServlet("/checkouttwo")
public class CheckoutTwoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutTwoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/checkout2.jsp");
		dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrderModel order = (OrderModel)session.getAttribute("order");
		UserModel user = (UserModel)session.getAttribute("user");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
	
		order.setCustomerId(user.getUserId());
		order.setPhoneNumber(phoneNumber);
		order.setAddress(address);
		
		session.setAttribute("order", order);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/checkout2.jsp");
		dispatcher.forward(request, response);
	}

}
