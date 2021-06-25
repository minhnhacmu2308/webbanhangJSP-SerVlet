package controllers;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CheckoutOneController
 */
@WebServlet("/checkoutone")
public class CheckoutOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutOneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 response.setContentType("text/html;charset=UTF-8");
 		request.setCharacterEncoding("UTF-8");
 		
 		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		UserModel user = (UserModel)session.getAttribute("user");
		OrderModel  order = (OrderModel)session.getAttribute("order");
		String total = request.getParameter("sendSum");
		if(total!=null) {
			order.setTotal(Float.parseFloat(total));
		}
		
		if(user!=null) {
			if(session.getAttribute("order")==null) {
				request.setAttribute("messError", "No item");
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/checkout1.jsp");
				dispatcher.forward(request, response);
			}
			
		}else {
			out.println("  <div class=\"toast-header\" style=\"background-color: red\" >\r\n" + 
					"   \r\n" + 
					"    <strong class=\"me-auto\" style=\"color: #ffff\">Error</strong>\r\n" + 
					"  \r\n" + 
					"  </div>\r\n" + 
					"  <div class=\"toast-body\">\r\n" + 
					"     ❌ You need login\r\n" + 
					"  </div>");
		}
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
