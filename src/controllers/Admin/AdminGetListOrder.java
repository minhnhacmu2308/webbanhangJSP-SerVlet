package controllers.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.OrderModel;
import service.OrderService;
import service.impl.OrderServiceImpl;

/**
 * Servlet implementation class AdminGetListOrder
 */

public class AdminGetListOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetListOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderService order = new OrderServiceImpl();
		List<OrderModel> list = order.getAll();
		request.setAttribute("listO", list);
		
		System.out.println(list);
		request.setAttribute("checkactive", "order");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/order.jsp");
		dispatcher.forward(request, response);
		
	}

}
