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


/**
 * Servlet implementation class CheckoutThreeController
 */
@WebServlet("/checkoutthree")
public class CheckoutThreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutThreeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/checkout3.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		OrderModel order = (OrderModel)session.getAttribute("order");
		
		String typeDelivery = request.getParameter("delivery");
		System.out.println(typeDelivery);
	
		order.setMethodDelivery(Integer.parseInt(typeDelivery));
		session.setAttribute("order", order);
		System.out.println(order);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/checkout3.jsp");
		dispatcher.forward(request, response);
	}

}
