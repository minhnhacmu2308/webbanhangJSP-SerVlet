package controllers.Admin;

import java.io.IOException;

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
 * Servlet implementation class AdminGetOrderById
 */
@WebServlet("/AdminGetOrderById")
public class AdminGetOrderById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetOrderById() {
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
		
		String id = request.getParameter("id");
		
		OrderService  orderS = new OrderServiceImpl();
		
		OrderModel result = orderS.getOrderById(Integer.parseInt(id));
		
		request.setAttribute("checkactive", "detailorder");
		request.setAttribute("orderDetail", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/detailorder.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
