package controllers.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;
import service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class AdminAddCategory
 */

public class AdminAddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("checkactive", "addcategory");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/addcategory.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		CategoryService category = new CategoryServiceImpl();
		String catName = request.getParameter("namecategory");
		String patId = request.getParameter("option");
		PrintWriter out = response.getWriter();
		
		if(catName=="" || patId=="" ) {
			out.println("  <div class=\"toast-header\" style=\"background-color: red\" >\r\n" + 
					"   \r\n" + 
					"    <strong class=\"me-auto\" style=\"color: #ffff\">Error</strong>\r\n" + 
					"  \r\n" + 
					"  </div>\r\n" + 
					"  <div class=\"toast-body\">\r\n" + 
					"    ❌ Can not empty\r\n" + 
					"  </div>");
		}else {
			boolean result = category.insert(catName, Integer.parseInt(patId));
			if(result==true) {
				out.println("  <div class=\"toast-header\" style=\"background-color: #33CC00\" >\r\n" + 
						"   \r\n" + 
						"    <strong class=\"me-auto\" style=\"color: #ffff\">Success</strong>\r\n" + 
						"  \r\n" + 
						"  </div>\r\n" + 
						"  <div class=\"toast-body\">\r\n" + 
						"    ✅  Add category successfully\r\n" + 
						"  </div>");
			}
		}
		
		
		
	}

}
