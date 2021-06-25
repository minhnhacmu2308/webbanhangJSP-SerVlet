package controllers.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Admin.ProductDao;
import Dao.impl.ProductDaoImpl;
import models.ProductModel;
import models.UserModel;

/**
 * Servlet implementation class AdminGetListProduct
 */

public class AdminGetListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetListProduct() {
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
		ProductDao product = new ProductDaoImpl();
		
		List<ProductModel> listP = product.getAll();
		request.setAttribute("checkactive", "listproduct");
		request.setAttribute("listP", listP);
		HttpSession session = request.getSession();
		UserModel user =(UserModel) session.getAttribute("admin");
		if(user!=null) {
			RequestDispatcher dispatcher =  request.getRequestDispatcher("/Admin/product.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("admin");
		}
	}

}
