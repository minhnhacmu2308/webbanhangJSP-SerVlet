package controllers.Admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.ProductModel;
import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;
import utils.AuthenticationUtil;
import utils.FileUtil;

/**
 * Servlet implementation class AdminAddProduct
 */
@MultipartConfig
public class AdminAddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuthenticationUtil auth = new AuthenticationUtil();
		if(auth.checkToken(request)==true) {
			request.setAttribute("checkactive", "addproduct");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/addproduct.jsp");
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
		ProductService pro = new ProductServiceImpl();
		String productName = request.getParameter("nameproduct");
		
		String describe = request.getParameter("describe");
		String price = request.getParameter("price");
		
		String catId = request.getParameter("option");
		PrintWriter out = response.getWriter();
		FileUtil fu = new FileUtil();
		Part part  = request.getPart("file");
		String path = request.getServletContext().getRealPath("")+"img";
		String resultUpload = fu.uploadImage(part,path);
		if(resultUpload !=null) {
			ProductModel productmodel = new ProductModel(productName,describe,resultUpload,Integer.parseInt(catId),Float.parseFloat(price));
			boolean result = pro.insert(productmodel);
			if(result == true) {
				request.setAttribute("mes", "success");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/addproduct.jsp");
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
