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

import Dao.ProductDao;
import models.ProductModel;
import models.UserModel;

/**
 * Servlet implementation class WishListController
 */
@WebServlet("/wishlistcontroller")
public class WishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserModel user = (UserModel)session.getAttribute("user");
		
		String gettag = (String)request.getParameter("tag");
		ProductDao proD = new ProductDao();
		System.out.println(gettag);
		List<ProductModel> listP = proD.getListWish(user.getUserId());
		
		request.setAttribute("listP", listP);
		request.setAttribute("tag", gettag);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/customer-wishlist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
