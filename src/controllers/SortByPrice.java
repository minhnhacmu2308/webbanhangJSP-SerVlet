package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDao;
import models.ProductModel;

/**
 * Servlet implementation class SortByPrice
 */
@WebServlet("/sortbyprice")
public class SortByPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortByPrice() {
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
		ProductDao proD = new ProductDao();
		String keySearch = request.getParameter("keySearch");
		List<ProductModel> listP = proD.sortByPrice(keySearch);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		for(ProductModel p :listP) {
			
		 out.println("  <div class=\"col-lg-3 col-md-4\">\r\n" + 
		 		"                  <div class=\"product\">\r\n" + 
		 		"                    <div class=\"flip-container\">\r\n" + 
		 		"                      <div class=\"flipper\">\r\n" + 
		 		"                        <div class=\"front\"><a href=\"detail?productId="+p.getProductId()+"\"><img src=\"img/"+p.getProductPicture()+"\" alt=\"\" class=\"img-fluid\"></a></div>\r\n" + 
		 		"                        <div class=\"back\"><a href=\"detail?productId="+p.getProductId()+"\"><img src=\"img/"+p.getProductPicture()+"\" alt=\"\" class=\"img-fluid\"></a></div>\r\n" + 
		 		"                      </div>\r\n" + 
		 		"                    </div><a href=\"detail?productId="+p.getProductId()+"\" class=\"invisible\"><img src=\"img/"+p.getProductPicture()+"\" alt=\"\" class=\"img-fluid\"></a>\r\n" + 
		 		"                    <div class=\"text\">\r\n" + 
		 		"                      <h3><a href=\"detail?productId="+p.getProductId()+"\">"+p.getProductName()+"</a></h3>\r\n" + 
		 		"                      <p class=\"price\"> \r\n" + 
		 		"                        <del></del>"+p.getProductPrice()+"r\n" + 
		 		"                      </p>\r\n" + 
		 		"                      <p class=\"buttons\"><a href=\"detail?productId="+p.getProductId()+"\" class=\"btn btn-outline-secondary\">View detail</a><a href=\"<%=request.getContextPath()%>/addcart?productId="+p.getProductId()+"\" class=\"btn btn-primary\"><i class=\"fa fa-shopping-cart\"></i>Add to cart</a></p>\r\n" + 
		 		"                    </div>\r\n" + 
		 		"                    <!-- /.text-->\r\n" + 
		 		"                  </div>\r\n" + 
		 		"                  <!-- /.product            -->\r\n" + 
		 		"                </div>");
		}
	}

}
