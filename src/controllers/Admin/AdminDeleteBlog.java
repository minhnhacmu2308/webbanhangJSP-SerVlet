package controllers.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BlogService;
import service.impl.BlogServiceImpl;

/**
 * Servlet implementation class AdminDeleteBlog
 */

public class AdminDeleteBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBlog = request.getParameter("idblog");
		
		BlogService blogS = new BlogServiceImpl();
		
		boolean result = blogS.delete(Integer.parseInt(idBlog));
		request.setAttribute("mes", "success");
		 
		 if(result==true) {
			 RequestDispatcher dispatcher =  request.getRequestDispatcher("listblog");
				dispatcher.forward(request, response);
		 }
	}

}
