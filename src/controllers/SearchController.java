package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.SearchDao;
import models.ProductModel;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/searchcontroller")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchDao search = new  SearchDao();
		
		String keySearch = request.getParameter("keySearch");
		
		
		
		int count = search.getNumberPage(keySearch);
		int pageSize= 12;
		int endPage = 0;
		endPage = count / pageSize;
		
		if(count%pageSize!=0) {
			endPage++;
		}
		System.out.println(endPage);
	    String indexPage = request.getParameter("page");
			if(indexPage == null) {
				indexPage="1";
			}
		int page = Integer.parseInt(indexPage);
        List<ProductModel> listP = search.pagingproduct(page,keySearch);
		System.out.println("search"+ keySearch);
		request.setAttribute("listP", listP);
		request.setAttribute("tagPage", page);
		request.setAttribute("numberPage", endPage);
		request.setAttribute("keySearch", keySearch);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchResultPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
