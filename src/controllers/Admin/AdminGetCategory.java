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

import models.CategoryModel;
import models.UserModel;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class AdminGetCategory
 */
public class AdminGetCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetCategory() {
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
		// TODO Auto-generated method stub
		CategoryService category = new CategoryServiceImpl();
		
		List<CategoryModel> listC = category.getAll();
		
		request.setAttribute("listC", listC);
		request.setAttribute("checkactive", "category");
		System.out.println(listC);
		HttpSession session = request.getSession();
		UserModel user =(UserModel) session.getAttribute("admin");
		if(user!=null) {
			
			RequestDispatcher dispatcher =  request.getRequestDispatcher("/Admin/category.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("admin");
		}
		
		
	}

}
