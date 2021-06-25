package controllers.Admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

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
		request.setAttribute("checkactive", "addproduct");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/addproduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ProductService pro = new ProductServiceImpl();
		String productName = request.getParameter("nameproduct");
		System.out.println(productName);
		String describe = request.getParameter("describe");
		String price = request.getParameter("price");
		System.out.println(price);
		String catId = request.getParameter("option");
		String filename = "";
		PrintWriter out = response.getWriter();
		try {
			Part part  = request.getPart("file");
			String path = request.getServletContext().getRealPath("")+"img";		
			/* String path1 = "D:/Folder all/Vinaenter/WebsiteBanHang/WebContent/img"; */
			filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(path))){
				Files.createDirectory(Path.of(path));
			}
			part.write(path+"/"+filename);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(filename);
		ProductModel productmodel = new ProductModel(productName,describe,filename,Integer.parseInt(catId),Float.parseFloat(price));
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
					"    ❌ Can not empty\r\n" + 
					"  </div>");
		}
			
	}

}
