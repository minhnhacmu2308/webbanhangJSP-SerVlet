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
 * Servlet implementation class CategoryFull
 */
@WebServlet("/categoryfull")
public class CategoryFull extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryFull() {
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
		if(indexPage == null) {
			indexPage="1";
		}
		int page = Integer.parseInt(indexPage);
		List<ProductModel> listP = daoP.pagingproduct(page);
		
		request.setAttribute("listP", listP);
		request.setAttribute("tagPage", page);
		
		int numberPage = daoP.getNumberPage();
		
		
		request.setAttribute("numberPage", numberPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/category-full.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
