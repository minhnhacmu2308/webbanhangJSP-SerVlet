package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OrderDao;
import models.OrderModel;
import models.UserModel;

/**
 * Servlet implementation class MyOrderController
 */
@WebServlet("/myorder")
public class MyOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyOrderController() {
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
		HttpSession session = request.getSession();
		UserModel user = (UserModel)session.getAttribute("user");
		
		OrderDao orD = new OrderDao();
		String tag = request.getParameter("tag");
		
		List<OrderModel> list = orD.getListOrder(user.getUserId());
		System.out.println(tag);
		request.setAttribute("listO", list);
		request.setAttribute("tag", tag);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/customer-orders.jsp");
		dispatcher.forward(request, response);
	}

}
