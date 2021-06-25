package controllers;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.CategoryDao;
import Dao.ProductDao;
import models.CategoryModel;
import models.ProductModel;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao dao = new CategoryDao();    
		ProductDao daoP = new ProductDao();
		
		List<CategoryModel> list = dao.getAllCategory();
		request.setAttribute("listC", list);
        
		String indexPage = request.getParameter("page");
		if(indexPage==null) {
			indexPage="1";
		}
		
		int page = Integer.parseInt(indexPage);
		
		
		String catId = request.getParameter("caId");
		List<ProductModel> listId = dao.getCategoryId(catId,page);
		int numberPage = daoP.getNumberCategory(Integer.parseInt(catId));
		request.setAttribute("listP", listId);
		request.setAttribute("numberPage", numberPage);
		request.setAttribute("tag", catId);
		request.setAttribute("page", page);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/category.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
