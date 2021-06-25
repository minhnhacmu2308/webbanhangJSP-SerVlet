package controllers.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CategoryModel;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class AdminDeleteCategory
 */
public class AdminDeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteCategory() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		CategoryService category = new CategoryServiceImpl();
		String idCat = request.getParameter("idcat");
		System.out.println(idCat);
		
		 PrintWriter out = response.getWriter(); boolean result =
		 category.delete(Integer.parseInt(idCat));
		 request.setAttribute("mes", "success");
		 List<CategoryModel> listC = category.getAll();
		 if(result==true) {
			 RequestDispatcher dispatcher =  request.getRequestDispatcher("listcategory");
				dispatcher.forward(request, response);
		 }
		 
	}

}
