package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProductDao;
import models.ProductModel;
import models.UserModel;

/**
 * Servlet implementation class AddWishListController
 */
@WebServlet("/addwishlist")
public class AddWishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWishListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserModel user = (UserModel)session.getAttribute("user");
		ProductDao proD = new ProductDao();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int productId = Integer.parseInt(request.getParameter("productId"));
		PrintWriter out = response.getWriter();
		if(user==null) {
			
			
			out.println("  <div class=\"toast-header\" style=\"background-color: red\" >\r\n" + 
					"   \r\n" + 
					"    <strong class=\"me-auto\" style=\"color: #ffff\">Error</strong>\r\n" + 
					"  \r\n" + 
					"  </div>\r\n" + 
					"  <div class=\"toast-body\">\r\n" + 
					"     ❌ You need login\r\n" + 
					"  </div>");
		}else {
			
			boolean check = proD.checkExitWish(user.getUserId(), productId);
			if(check==true) {
				out.println("<div class=\"toast-header\" style=\"background-color: red\" >\r\n" + 
						"   \r\n" + 
						"    <strong class=\"me-auto\" style=\"color: #ffff\">Error</strong>\r\n" + 
						"  \r\n" + 
						"  </div>\r\n" + 
						"  <div class=\"toast-body\">\r\n" + 
						"    ❌  Product is exited\r\n" + 
						"  </div>");
			}else {
				boolean addWidh = proD.addWishList(user.getUserId(), productId);
				if(addWidh==true) {
					out.println("  <div class=\"toast-header\" style=\"background-color: #33CC00\" >\r\n" + 
							"   \r\n" + 
							"    <strong class=\"me-auto\" style=\"color: #ffff\">Success</strong>\r\n" + 
							"  \r\n" + 
							"  </div>\r\n" + 
							"  <div class=\"toast-body\">\r\n" + 
							"    ✅  Add wishlist successfully\r\n" + 
							"  </div>");
				}
			}
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
