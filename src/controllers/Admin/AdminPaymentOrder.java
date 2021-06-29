package controllers.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;
import service.impl.OrderServiceImpl;

/**
 * Servlet implementation class AdminPaymentOrder
 */

public class AdminPaymentOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPaymentOrder() {
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
		
		OrderService orderS =  new OrderServiceImpl();
 		
		String id = request.getParameter("id");
		
		boolean result = orderS.payment(Integer.parseInt(id));
		
		request.setAttribute("mes", "success");
		
		if(result == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("detailorderbyid");
			dispatcher.forward(request, response);
		}
	}

}
