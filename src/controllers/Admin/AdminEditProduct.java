package controllers.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

/**
 * Servlet implementation class AdminEditProduct
 */
public class AdminEditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ProductService product = new ProductServiceImpl();
		String idPro = request.getParameter("productId");
		String namePro  = request.getParameter("proName");
		String price  = request.getParameter("price");
		String desPro  = request.getParameter("proDes");
		System.out.println(namePro);
		System.out.println(idPro);
		System.out.println(desPro);
		PrintWriter out = response.getWriter(); 
	    boolean result = product.edit(Integer.parseInt(idPro), namePro, Float.parseFloat(price), desPro);
	    if(result==true) {
	    	out.println("  <div class=\"toast-header\" style=\"background-color: #33CC00\" >\r\n" + 
					"   \r\n" + 
					"    <strong class=\"me-auto\" style=\"color: #ffff\">Success</strong>\r\n" + 
					"  \r\n" + 
					"  </div>\r\n" + 
					"  <div class=\"toast-body\">\r\n" + 
					"    ✅ Edit product successfully\r\n" + 
					"  </div>");
	    }
	}

}
