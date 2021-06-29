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
 * Servlet implementation class AdminDeleteOrder
 */

public class AdminDeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteOrder() {
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
		
		OrderService order = new OrderServiceImpl();
		String id = request.getParameter("id");
		boolean result = order.delete(Integer.parseInt(id));
		request.setAttribute("mes", "success");
		 
		 if(result==true) {
			 RequestDispatcher dispatcher =  request.getRequestDispatcher("listorder");
				dispatcher.forward(request, response);
		 }
	}

}
