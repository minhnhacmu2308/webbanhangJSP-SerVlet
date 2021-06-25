package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.OrderDao;
import models.OrderModel;

/**
 * Servlet implementation class DetailOrderController
 */
@WebServlet("/detailorder")
public class DetailOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		
		OrderDao  order = new OrderDao();
		OrderModel orderModel = new OrderModel();
		orderModel = order.getListOrderById(Integer.parseInt(orderId));
		
		System.out.println(orderModel);
		request.setAttribute("DetailOrder", orderModel);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/customer-order.jsp");
		dispatcher.forward(request, response);
		
	}

}
