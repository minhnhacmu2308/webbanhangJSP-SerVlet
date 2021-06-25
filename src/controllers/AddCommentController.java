package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.BlogDao;
import Dao.UserDao;
import models.BlogModel;
import models.CommentModel;
import models.UserModel;

/**
 * Servlet implementation class AddCommentController
 */
@WebServlet("/addcomment")
public class AddCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentController() {
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
		BlogDao blD = new BlogDao();
		HttpSession session = request.getSession();
		UserModel user = (UserModel)session.getAttribute("user");
		String blogId = request.getParameter("blogId");
		System.out.println("blog" + blogId);
		String comment = request.getParameter("comment");
	
		System.out.println("comment" + blogId);
		boolean result = blD.addComment(user.getUserId(), Integer.parseInt(blogId), comment);
		System.out.println(result);
		UserDao us = new UserDao();
		PrintWriter out = response.getWriter();
		if(result==true) {
			if(user!=null) {
				List<BlogModel> listBn = blD.getAllBlogAndComment(Integer.parseInt(blogId));
				out.println(" <h4>"+listBn.get(0).getListComment().size() +" comments</h4>");
				for(CommentModel c:listBn.get(0).getListComment()) {
					String fullname = us.getFullName(c.getUserId());
					out.println(" <div class=\"row comment\">\r\n" + 
							"                    <div class=\"col-md-3 col-lg-2 text-center text-md-center\">\r\n" + 
							"                      <p><img src=\"img/avatar.jpg\" alt=\"\" class=\"img-fluid rounded-circle\"></p>\r\n" + 
							"                    </div>\r\n" + 
							
							"                    <div class=\"col-md-9 col-lg-10\">\r\n" + 
							"                      <h5 >"+fullname+"</h5>\r\n" + 
							"                      <p class=\"posted\"><i class=\"fa fa-clock-o\"></i>"+c.getCreate_time()+"</p>\r\n" + 
							"                      <p>"+c.getComment()+"</p>\r\n" + 
							"                      <p class=\"reply\"><a href=\"#\"><i class=\"fa fa-reply\"></i> Reply</a></p>\r\n" + 
							"                    </div>\r\n" + 
							"                  </div>");
				}
			}
			
		}
	}

}
