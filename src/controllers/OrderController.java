package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OrderDao;
import Dao.ProductDao;
import models.OrderModel;
import models.ProductModel;
import models.UserModel;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDao daoP = new ProductDao();
		HttpSession session = request.getSession();
		OrderModel order = (OrderModel) session.getAttribute("order");
		UserModel user = (UserModel)session.getAttribute("user");
		System.out.println(order);
		List<ProductModel> listRe = daoP.getProductRecommend(3);
		request.setAttribute("listRe", listRe);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/basket.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrderModel order = (OrderModel) session.getAttribute("order");
		UserModel user = (UserModel)session.getAttribute("user");
		System.out.println(order);
		OrderDao daoO = new OrderDao();
		
		java.util.Date date=new java.util.Date();  
		String checkVar = date.toString();
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		boolean resultOrder = daoO.addOrder(order,checkVar);
		int checkDate = daoO.getOrderId(checkVar);
		for(int i=0;i<order.getItems().size();i++) {
			boolean addItem = daoO.addItem(order.getItems().get(i),user.getUserId(),checkDate);
		}
		
		if(resultOrder == true) {
			
			session.removeAttribute("order");
			out.println("  <div >\r\n" + 
					"                <div style=\"margin-left: 270px\">\r\n" + 
					"                	<img alt=\"\" src=\"img/true.png\" width=\"200px\">\r\n" + 
					"                	<h3>Order successfully</h3>\r\n" + 
					"                </div>\r\n" + 
					"                	\r\n" + 
					"                </div>");
		}
	}

}
