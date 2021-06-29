package controllers.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.BlogModel;
import models.ProductModel;
import service.BlogService;
import service.impl.BlogServiceImpl;
import utils.AuthenticationUtil;
import utils.FileUtil;

/**
 * Servlet implementation class AdminAddBlog
 */
@MultipartConfig
public class AdminAddBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthenticationUtil auth = new AuthenticationUtil();
		if(auth.checkToken(request)==true) {
			request.setAttribute("checkactive", "addblog");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/addblogs.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("admin");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		FileUtil fu = new FileUtil();
		BlogService blogS = new BlogServiceImpl();
		
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		String author = request.getParameter("author");
		PrintWriter out = response.getWriter();
		Part part  = request.getPart("file");
		String path = request.getServletContext().getRealPath("")+"img";
		String resultUpload = fu.uploadImage(part,path);
		if(resultUpload !=null) {
			BlogModel blogmodel = new BlogModel(title,author,resultUpload,detail);
			boolean result = blogS.insert(blogmodel);
			if(result == true) {
				request.setAttribute("mes", "success");
				request.setAttribute("checkactive", "addblog");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/addblogs.jsp");
				dispatcher.forward(request, response);
			}else {
				out.println("  <div class=\"toast-header\" style=\"background-color: red\" >\r\n" + 
						"   \r\n" + 
						"    <strong class=\"me-auto\" style=\"color: #ffff\">Error</strong>\r\n" + 
						"  \r\n" + 
						"  </div>\r\n" + 
						"  <div class=\"toast-body\">\r\n" + 
						"    ❌ Upload error\r\n" + 
						"  </div>");
			}
		}else {
			out.println("  <div class=\"toast-header\" style=\"background-color: red\" >\r\n" + 
					"   \r\n" + 
					"    <strong class=\"me-auto\" style=\"color: #ffff\">Error</strong>\r\n" + 
					"  \r\n" + 
					"  </div>\r\n" + 
					"  <div class=\"toast-body\">\r\n" + 
					"    ❌ Upload error server\r\n" + 
					"  </div>");
		}
	}

}
