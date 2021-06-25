package controllers;

import Dao.ProductDao;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ProductModel;

/**
 * Servlet implementation class DetailProduct
 */
@WebServlet("/detail")
public class DetailProduct extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DetailProduct() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    ProductDao daoP = new ProductDao();

    String productId = request.getParameter("productId");

    ProductModel detailProduct = daoP.getProductById(productId);
    request.setAttribute("product", detailProduct);

    List<ProductModel> listR = daoP.getProductRecently();
    request.setAttribute("listR", listR);

    List<ProductModel> listRe = daoP.getProductRecommend(3);
    request.setAttribute("listRe", listRe);

    daoP.addView(Integer.parseInt(productId));
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("/detail.jsp");
    dispatcher.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
