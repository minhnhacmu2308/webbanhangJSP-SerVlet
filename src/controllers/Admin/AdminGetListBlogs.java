package controllers.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BlogModel;
import service.BlogService;
import service.impl.BlogServiceImpl;
import utils.AuthenticationUtil;

/**
 * Servlet implementation class AdminGetListBlogs
 */

public class AdminGetListBlogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetListBlogs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthenticationUtil auth = new AuthenticationUtil();
		if(auth.checkToken(request)==true) {
			doPost(request, response);
		}else {
			response.sendRedirect("admin");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BlogService blogS = new BlogServiceImpl();
		
		List<BlogModel> list = blogS.getAll();
		
		request.setAttribute("listB", list);
		
		System.out.println(list);
		request.setAttribute("checkactive", "blog");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/blog.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
