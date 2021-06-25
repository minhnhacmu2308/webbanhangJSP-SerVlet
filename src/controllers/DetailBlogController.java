package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BlogDao;
import models.BlogModel;

/**
 * Servlet implementation class DetailBlogController
 */
@WebServlet("/detailblog")
public class DetailBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailBlogController() {
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
		
		BlogDao blD = new BlogDao();
		String blogId = request.getParameter("blogId");
		System.out.println(blogId);
		List<BlogModel> listB = blD.getAllBlogAndComment(Integer.parseInt(blogId));
		System.out.println(listB);
	    request.setAttribute("listB", listB);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/post.jsp");
	    dispatcher.forward(request, response);
	    
	}

}
